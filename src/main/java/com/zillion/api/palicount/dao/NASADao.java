package com.zillion.api.palicount.dao;

import com.zillion.api.palicount.model.NASAResultsWrapper;

public interface NASADao {
	public NASAResultsWrapper getResource(String search, int count);
}
