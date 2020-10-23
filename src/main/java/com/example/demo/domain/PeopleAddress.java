package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the people_addresses database table.
 * 
 */
@Entity
@Table(name="people_addresses")
@NamedQuery(name="PeopleAddress.findAll", query="SELECT p FROM PeopleAddress p")
public class PeopleAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeopleAddressPK id;

	@Column(name="address_id")
	private String addressId;

	@Column(name="address_type_code")
	private String addressTypeCode;

	@Column(name="date_address_from")
	private String dateAddressFrom;

	@Column(name="date_address_to")
	private String dateAddressTo;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Addresses_address_id")
	private Address address;

	//bi-directional many-to-one association to People
	@ManyToOne(fetch=FetchType.LAZY)
	private People people;

	public PeopleAddress() {
	}

	public PeopleAddressPK getId() {
		return this.id;
	}

	public void setId(PeopleAddressPK id) {
		this.id = id;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressTypeCode() {
		return this.addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public String getDateAddressFrom() {
		return this.dateAddressFrom;
	}

	public void setDateAddressFrom(String dateAddressFrom) {
		this.dateAddressFrom = dateAddressFrom;
	}

	public String getDateAddressTo() {
		return this.dateAddressTo;
	}

	public void setDateAddressTo(String dateAddressTo) {
		this.dateAddressTo = dateAddressTo;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}