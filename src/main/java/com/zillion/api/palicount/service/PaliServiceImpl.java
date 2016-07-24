package com.zillion.api.palicount.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.zillion.api.palicount.model.Innovators;
import com.zillion.api.palicount.model.NASAResultsWrapper;
import com.zillion.api.palicount.model.Results;
import com.zillion.api.palicount.utils.PaliUtils;

public class PaliServiceImpl implements PaliService {

	@Override
	public JSONArray getCount(List<String> inputList, String uri) {
		if (inputList == null || inputList.size() == 0)
			return null;

		JSONArray responseArray = new JSONArray();
		for (String nextInput : inputList) {
			JSONObject countObject = new JSONObject();
			PaliUtils paliRunner = new PaliUtils(nextInput); // .generateComb(nextInput);
			Thread t = new Thread(paliRunner);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			countObject.put(nextInput, paliRunner.getCount());
			responseArray.add(countObject);
		}
		// add href to the response for clients references.
		JSONObject obj = new JSONObject();
		obj.put("href", uri);
		responseArray.add(obj);

		return responseArray;

	}

	@Override
	public List<String> getInnovatorDetails(NASAResultsWrapper nasaResponse) {
		if (nasaResponse == null || nasaResponse.getCount() == 0)
			return null;

		List<Results> results = nasaResponse.getResults();
		if (results == null || results.size() == 0)
			return null;

		List<String> listOfValues = new ArrayList<String>();

		for (Results currResult : results) {
			Innovators[] innovators = currResult.getInnovators();
			for (int i = 0; i < innovators.length; i++) {
				String firstName = innovators[i].getFname();
				String lastName = innovators[i].getLname();

				String fullName = null;
				if (firstName != null && !firstName.trim().equals(""))
					fullName = firstName.trim();
				if (lastName != null && !lastName.trim().equals(""))
					fullName += lastName.trim();

				if (fullName != null && !fullName.trim().equals(""))
					listOfValues.add(fullName);
			}

		}

		return listOfValues;
	}

}
