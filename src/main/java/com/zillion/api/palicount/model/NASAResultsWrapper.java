package com.zillion.api.palicount.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NASAResultsWrapper {

	public NASAResultsWrapper() {

	}

	public NASAResultsWrapper(int count, List<Results> results) {
		super();
		this.count = count;
		this.results = results;
	}

	@XmlElement(name = "count")
	private int count;

	List<Results> results;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "NASAResultsWrapper [count=" + count + ", results=" + results
				+ "]";
	}

}
