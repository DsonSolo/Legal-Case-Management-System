package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the people_roles database table.
 * 
 */
@Entity
@Table(name="people_roles")
@NamedQuery(name="PeopleRole.findAll", query="SELECT p FROM PeopleRole p")
public class PeopleRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeopleRolePK id;

	@Column(name="date_role_from")
	private String dateRoleFrom;

	@Column(name="date_role_to")
	private String dateRoleTo;

	@Column(name="role_code")
	private String roleCode;

	//bi-directional many-to-one association to PeopleAtTrial
	@OneToMany(mappedBy="peopleRole")
	private List<PeopleAtTrial> peopleAtTrials;

	//bi-directional many-to-one association to People
	@ManyToOne(fetch=FetchType.LAZY)
	private People people;

	public PeopleRole() {
	}

	public PeopleRolePK getId() {
		return this.id;
	}

	public void setId(PeopleRolePK id) {
		this.id = id;
	}

	public String getDateRoleFrom() {
		return this.dateRoleFrom;
	}

	public void setDateRoleFrom(String dateRoleFrom) {
		this.dateRoleFrom = dateRoleFrom;
	}

	public String getDateRoleTo() {
		return this.dateRoleTo;
	}

	public void setDateRoleTo(String dateRoleTo) {
		this.dateRoleTo = dateRoleTo;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<PeopleAtTrial> getPeopleAtTrials() {
		return this.peopleAtTrials;
	}

	public void setPeopleAtTrials(List<PeopleAtTrial> peopleAtTrials) {
		this.peopleAtTrials = peopleAtTrials;
	}

	public PeopleAtTrial addPeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().add(peopleAtTrial);
		peopleAtTrial.setPeopleRole(this);

		return peopleAtTrial;
	}

	public PeopleAtTrial removePeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().remove(peopleAtTrial);
		peopleAtTrial.setPeopleRole(null);

		return peopleAtTrial;
	}

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}