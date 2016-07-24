package com.zillion.api.palicount.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Innovators {
	
	private String lname;
	private String  mname;
	private String company;
	private String order;
	private String fname;
	
	public Innovators() {
		
	}
	
	public Innovators(String lname, String mname, String company,
			String order, String fname) {
		super();
		this.lname = lname;
		this.mname = mname;
		this.company = company;
		this.order = order;
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	@Override
	public String toString() {
		return "Innovators [lname=" + lname + ", mname=" + mname + ", company="
				+ company + ", order=" + order + ", fname=" + fname + "]";
	}

}
