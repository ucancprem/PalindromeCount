package com.zillion.api.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.zillion.api.palicount.dao.NASADao;
import com.zillion.api.palicount.dao.NASADaoImpl;
import com.zillion.api.palicount.model.NASAResultsWrapper;
import com.zillion.api.palicount.utils.PaliUtils;

/**
 * @author Prem
 * 
 *         PayLoadTest test the following 1) Returned Status code 2) Tests for
 *         num of records returned 3) Test for No data, when a bad param is
 *         passed 4) Palindome count verificaiton 5) Media type verificaiton
 */
public class PayLoadTest {

	@Test
	public void testStatusCode() {
		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palindromes?search=electricity&limit=2");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);

			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 201);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testData() {
		NASADao daoObj = new NASADaoImpl();
		NASAResultsWrapper wrapper = daoObj.getResource("electricity", 2);
		Assert.assertTrue(wrapper.getCount() > 0);
	}

	@Test
	public void testNoData() {
		NASADao daoObj = new NASADaoImpl();
		NASAResultsWrapper wrapper = daoObj.getResource(
				"pppppppppppppppppppppppppppppppppppp", 2);
		Assert.assertTrue(wrapper.getCount() == 0);
	}

	@Test
	public void testPaliCount() {
		PaliUtils paliRunner = new PaliUtils("MariaMayer");
		Thread t = new Thread(paliRunner);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(paliRunner.getCount() == 7776);
		paliRunner = new PaliUtils("MarieCurie");
		t = new Thread(paliRunner);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(paliRunner.getCount() == 16807);

	}

	public void testMediaType() {

		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palindromes?search=electricity&limit=2");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);
			Assert.assertEquals(statusCodeResponse.getEntity().getContentType()
					.getValue(), "application/json");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
