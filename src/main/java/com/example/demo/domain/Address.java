package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	private int addressId;

	private String city;

	private String country;

	@Column(name="lne_1_number_building")
	private String lne1NumberBuilding;

	@Column(name="lne_2_number_street")
	private String lne2NumberStreet;

	@Column(name="lne_3_area_locality")
	private String lne3AreaLocality;

	@Column(name="other_address_details")
	private String otherAddressDetails;

	@Column(name="state_province_county")
	private String stateProvinceCounty;

	@Column(name="zip_postcode")
	private String zipPostcode;

	//bi-directional many-to-one association to CasesTrial
	@OneToMany(mappedBy="address")
	private List<CasesTrial> casesTrials;

	//bi-directional many-to-one association to OrganizationAddress
	@OneToMany(mappedBy="address")
	private List<OrganizationAddress> organizationAddresses;

	//bi-directional many-to-one association to PeopleAddress
	@OneToMany(mappedBy="address")
	private List<PeopleAddress> peopleAddresses;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLne1NumberBuilding() {
		return this.lne1NumberBuilding;
	}

	public void setLne1NumberBuilding(String lne1NumberBuilding) {
		this.lne1NumberBuilding = lne1NumberBuilding;
	}

	public String getLne2NumberStreet() {
		return this.lne2NumberStreet;
	}

	public void setLne2NumberStreet(String lne2NumberStreet) {
		this.lne2NumberStreet = lne2NumberStreet;
	}

	public String getLne3AreaLocality() {
		return this.lne3AreaLocality;
	}

	public void setLne3AreaLocality(String lne3AreaLocality) {
		this.lne3AreaLocality = lne3AreaLocality;
	}

	public String getOtherAddressDetails() {
		return this.otherAddressDetails;
	}

	public void setOtherAddressDetails(String otherAddressDetails) {
		this.otherAddressDetails = otherAddressDetails;
	}

	public String getStateProvinceCounty() {
		return this.stateProvinceCounty;
	}

	public void setStateProvinceCounty(String stateProvinceCounty) {
		this.stateProvinceCounty = stateProvinceCounty;
	}

	public String getZipPostcode() {
		return this.zipPostcode;
	}

	public void setZipPostcode(String zipPostcode) {
		this.zipPostcode = zipPostcode;
	}

	public List<CasesTrial> getCasesTrials() {
		return this.casesTrials;
	}

	public void setCasesTrials(List<CasesTrial> casesTrials) {
		this.casesTrials = casesTrials;
	}

	public CasesTrial addCasesTrial(CasesTrial casesTrial) {
		getCasesTrials().add(casesTrial);
		casesTrial.setAddress(this);

		return casesTrial;
	}

	public CasesTrial removeCasesTrial(CasesTrial casesTrial) {
		getCasesTrials().remove(casesTrial);
		casesTrial.setAddress(null);

		return casesTrial;
	}

	public List<OrganizationAddress> getOrganizationAddresses() {
		return this.organizationAddresses;
	}

	public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}

	public OrganizationAddress addOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().add(organizationAddress);
		organizationAddress.setAddress(this);

		return organizationAddress;
	}

	public OrganizationAddress removeOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().remove(organizationAddress);
		organizationAddress.setAddress(null);

		return organizationAddress;
	}

	public List<PeopleAddress> getPeopleAddresses() {
		return this.peopleAddresses;
	}

	public void setPeopleAddresses(List<PeopleAddress> peopleAddresses) {
		this.peopleAddresses = peopleAddresses;
	}

	public PeopleAddress addPeopleAddress(PeopleAddress peopleAddress) {
		getPeopleAddresses().add(peopleAddress);
		peopleAddress.setAddress(this);

		return peopleAddress;
	}

	public PeopleAddress removePeopleAddress(PeopleAddress peopleAddress) {
		getPeopleAddresses().remove(peopleAddress);
		peopleAddress.setAddress(null);

		return peopleAddress;
	}

}