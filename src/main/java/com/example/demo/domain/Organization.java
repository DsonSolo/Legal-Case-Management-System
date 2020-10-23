package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organizations database table.
 * 
 */
@Entity
@Table(name="organizations")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="organization_id")
	private int organizationId;

	@Column(name="organization_name")
	private String organizationName;

	@Column(name="organization_type_code")
	private String organizationTypeCode;

	@Column(name="other_organization_details")
	private String otherOrganizationDetails;

	//bi-directional many-to-one association to OrganizationAddress
	@OneToMany(mappedBy="organization")
	private List<OrganizationAddress> organizationAddresses;

	//bi-directional many-to-one association to People
	@OneToMany(mappedBy="organization")
	private List<People> peoples;

	public Organization() {
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationTypeCode() {
		return this.organizationTypeCode;
	}

	public void setOrganizationTypeCode(String organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}

	public String getOtherOrganizationDetails() {
		return this.otherOrganizationDetails;
	}

	public void setOtherOrganizationDetails(String otherOrganizationDetails) {
		this.otherOrganizationDetails = otherOrganizationDetails;
	}

	public List<OrganizationAddress> getOrganizationAddresses() {
		return this.organizationAddresses;
	}

	public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}

	public OrganizationAddress addOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().add(organizationAddress);
		organizationAddress.setOrganization(this);

		return organizationAddress;
	}

	public OrganizationAddress removeOrganizationAddress(OrganizationAddress organizationAddress) {
		getOrganizationAddresses().remove(organizationAddress);
		organizationAddress.setOrganization(null);

		return organizationAddress;
	}

	public List<People> getPeoples() {
		return this.peoples;
	}

	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}

	public People addPeople(People people) {
		getPeoples().add(people);
		people.setOrganization(this);

		return people;
	}

	public People removePeople(People people) {
		getPeoples().remove(people);
		people.setOrganization(null);

		return people;
	}

}