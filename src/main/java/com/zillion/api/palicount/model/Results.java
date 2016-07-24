package com.zillion.api.palicount.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Results {

	public Results() {

	}

	private String category;
	private String client_record_id;
	private String trl;
	private String reference_number;
	private String expiration_date;
	private String title;
	@XmlElement(name="innovator")
	private Innovators[] innovators;
	private Contact contact;
	private String publication;
	@XmlElement(name="concepts")
	private Concepts concepts;
	private String serial_number;
	private String _id;
	private String id;
	private String center;

	
	


	public Results(String category, String client_record_id, String trl,
			String reference_number, String expiration_date, String title,
			Innovators[] innovators, Contact contact, String publication,
			Concepts concepts, String serial_number, String _id, String id,
			String center) {
		super();
		this.category = category;
		this.client_record_id = client_record_id;
		this.trl = trl;
		this.reference_number = reference_number;
		this.expiration_date = expiration_date;
		this.title = title;
		this.innovators = innovators;
		this.contact = contact;
		this.publication = publication;
		this.concepts = concepts;
		this.serial_number = serial_number;
		this._id = _id;
		this.id = id;
		this.center = center;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClient_record_id() {
		return client_record_id;
	}

	public void setClient_record_id(String client_record_id) {
		this.client_record_id = client_record_id;
	}

	public String getTrl() {
		return trl;
	}

	public void setTrl(String trl) {
		this.trl = trl;
	}

	public String getReference_number() {
		return reference_number;
	}

	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Innovators[] getInnovators() {
		return innovators;
	}

	public void setInnovators(Innovators[] innovators) {
		this.innovators = innovators;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	

	public Concepts getConcepts() {
		return concepts;
	}

	public void setConcepts(Concepts concepts) {
		this.concepts = concepts;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Results [category=" + category + ", client_record_id="
				+ client_record_id + ", trl=" + trl + ", reference_number="
				+ reference_number + ", expiration_date=" + expiration_date
				+ ", title=" + title + ", innovators=" + innovators
				+ ", contact=" + contact + ", publication=" + publication
				+ ", concepts=" + concepts + ", serial_number=" + serial_number
				+ ", _id=" + _id + ", id=" + id + ", center=" + center + "]";
	}



}
