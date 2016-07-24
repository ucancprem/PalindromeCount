package com.zillion.api.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Prem
 * 
 *         ExceptionTest tests for Invalid request, Bad request, no data and too
 *         any requests Exception 1) Invalid request with Bad URL 2) Bad Params
 *         3) invalid param value(limit > 10) 4) Bad Param value returning no
 *         data 5) Too many requests
 * 
 */
public class ExceptionTest {

	@Test
	public void testInvalidURL1() {

		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/xxxxxpalindromes?search=electricity&limit=10");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);
			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidParams1() {

		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palasdindromes?search=ppppppppppppp&lasimit=2");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);
			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidLimitParamStatusCode() {

		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palindromes?search=electricity&limit=10");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);

			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBadSearchParamStatusCode() {

		HttpUriRequest statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palindromes?search=ppppppppppppp&limit=2");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);
			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 404);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTooManyRequests() {
		HttpUriRequest statusCodeRequest = null;
		for (int i = 0; i < 500; i++) {
			statusCodeRequest = new HttpGet(
					"http://localhost:8010/palicount/palindromes?search=electricity&limit=10");
		}
		statusCodeRequest = new HttpGet(
				"http://localhost:8010/palicount/palindromes?search=electricity&limit=10");
		HttpResponse statusCodeResponse;
		try {
			statusCodeResponse = HttpClientBuilder.create().build()
					.execute(statusCodeRequest);

			Assert.assertEquals(statusCodeResponse.getStatusLine()
					.getStatusCode(), 429);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
