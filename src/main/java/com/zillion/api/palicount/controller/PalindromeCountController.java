package com.zillion.api.palicount.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.simple.JSONArray;

import com.zillion.api.palicount.dao.NASADao;
import com.zillion.api.palicount.dao.NASADaoImpl;
import com.zillion.api.palicount.exceptions.DataNotFoundException;
import com.zillion.api.palicount.model.NASAResultsWrapper;
import com.zillion.api.palicount.service.PaliService;
import com.zillion.api.palicount.service.PaliServiceImpl;

@Path("/palindromes")
public class PalindromeCountController {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "application/json" media type.
	 * 
	 * @return String that will be returned as a "application/json" response.
	 * @throws MalformedURLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPalindrome(@QueryParam("search") String search,
			@QueryParam("limit") int limit, @Context UriInfo uriInfo)
			throws MalformedURLException {

		
		// if search param does not match our criteria, bad request exception is thrown 
		if (search == null || search.trim().equals("") || limit < 1
				|| limit > 5)
			throw new BadRequestException("Invalid query paramters ");

		JSONArray arr = new JSONArray();

		NASADao daoObj = new NASADaoImpl();
		NASAResultsWrapper wrapper = daoObj.getResource(search, limit);
		PaliService paliSerivice = new PaliServiceImpl();
		List<String> innovatorList = paliSerivice.getInnovatorDetails(wrapper);

		if (innovatorList == null || innovatorList.size() < 1) {
			throw new DataNotFoundException(
					"No Data found for request, please check the parameters of your call ");
			/*
			 * return Response.noContent().encoding("UTF-8").type(MediaType.
			 * APPLICATION_JSON).build();
			 */
		}
		URI uri = uriInfo.getAbsolutePathBuilder().queryParam("search", search)
				.queryParam("limit", limit).build();
		arr = paliSerivice.getCount(innovatorList, uri.toString());

		return Response.created(uri).entity(arr.toString()).location(uri)
				.encoding("UTF-8").type(MediaType.APPLICATION_JSON).build();
	}
}
