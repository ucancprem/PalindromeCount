package com.zillion.api.palicount.model;

import java.util.List;


public class Concepts {

	List<String> numbers;
	
	public Concepts() {
		
	}
	

	public Concepts(List<String> numbers) {
		super();
		this.numbers = numbers;
	}


	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "Concepts [numbers=" + numbers + "]";
	}
	
	
	
	
	
	
	
	
	
}
