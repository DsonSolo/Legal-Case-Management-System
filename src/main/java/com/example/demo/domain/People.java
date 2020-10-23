package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the people database table.
 * 
 */
@Entity
@NamedQuery(name="People.findAll", query="SELECT p FROM People p")
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="person_id")
	private int personId;

	@Column(name="date_of_birth")
	private String dateOfBirth;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="other_person_details")
	private String otherPersonDetails;

	//bi-directional many-to-one association to Organization
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organization_id")
	private Organization organization;

	//bi-directional many-to-one association to PeopleAddress
	@OneToMany(mappedBy="people")
	private List<PeopleAddress> peopleAddresses;

	//bi-directional many-to-one association to PeopleRole
	@OneToMany(mappedBy="people")
	private List<PeopleRole> peopleRoles;

	public People() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getOtherPersonDetails() {
		return this.otherPersonDetails;
	}

	public void setOtherPersonDetails(String otherPersonDetails) {
		this.otherPersonDetails = otherPersonDetails;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<PeopleAddress> getPeopleAddresses() {
		return this.peopleAddresses;
	}

	public void setPeopleAddresses(List<PeopleAddress> peopleAddresses) {
		this.peopleAddresses = peopleAddresses;
	}

	public PeopleAddress addPeopleAddress(PeopleAddress peopleAddress) {
		getPeopleAddresses().add(peopleAddress);
		peopleAddress.setPeople(this);

		return peopleAddress;
	}

	public PeopleAddress removePeopleAddress(PeopleAddress peopleAddress) {
		getPeopleAddresses().remove(peopleAddress);
		peopleAddress.setPeople(null);

		return peopleAddress;
	}

	public List<PeopleRole> getPeopleRoles() {
		return this.peopleRoles;
	}

	public void setPeopleRoles(List<PeopleRole> peopleRoles) {
		this.peopleRoles = peopleRoles;
	}

	public PeopleRole addPeopleRole(PeopleRole peopleRole) {
		getPeopleRoles().add(peopleRole);
		peopleRole.setPeople(this);

		return peopleRole;
	}

	public PeopleRole removePeopleRole(PeopleRole peopleRole) {
		getPeopleRoles().remove(peopleRole);
		peopleRole.setPeople(null);

		return peopleRole;
	}

}