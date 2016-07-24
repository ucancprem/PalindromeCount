package com.zillion.api.palicount.service;

import java.util.List;

import org.json.simple.JSONArray;

import com.zillion.api.palicount.model.NASAResultsWrapper;

public interface PaliService {
	public JSONArray getCount(List<String> inputList, String uri);
	public List<String> getInnovatorDetails(NASAResultsWrapper nasaResponse);
}
