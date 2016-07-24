package com.zillion.api.palicount.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {

	private String email;
	private String office;
	private String facility;

	public Contact() {

	}

	public Contact(String email, String office, String facility) {
		super();
		this.email = email;
		this.office = office;
		this.facility = facility;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	@Override
	public String toString() {
		return "Contact [email=" + email + ", office=" + office + ", facility="
				+ facility + "]";
	}

}
