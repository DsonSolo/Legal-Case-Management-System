package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the people_at_trial database table.
 * 
 */
@Entity
@Table(name="people_at_trial")
@NamedQuery(name="PeopleAtTrial.findAll", query="SELECT p FROM PeopleAtTrial p")
public class PeopleAtTrial implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeopleAtTrialPK id;

	@Column(name="appearance_and_datetime")
	private String appearanceAndDatetime;

	@Column(name="appearance_nr")
	private String appearanceNr;

	@Column(name="appearance_start_datetime")
	private String appearanceStartDatetime;

	@Column(name="other_details")
	private String otherDetails;

	@Column(name="person_id")
	private int personId;

	@Column(name="role_code")
	private String roleCode;

	//bi-directional many-to-one association to CasesTrial
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Cases_Trials_case_trial_id")
	private CasesTrial casesTrial;

	//bi-directional many-to-one association to PeopleRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="People_Roles_People_person_id", referencedColumnName="People_person_id"),
		@JoinColumn(name="People_Roles_person_id", referencedColumnName="person_id")
		})
	private PeopleRole peopleRole;

	public PeopleAtTrial() {
	}

	public PeopleAtTrialPK getId() {
		return this.id;
	}

	public void setId(PeopleAtTrialPK id) {
		this.id = id;
	}

	public String getAppearanceAndDatetime() {
		return this.appearanceAndDatetime;
	}

	public void setAppearanceAndDatetime(String appearanceAndDatetime) {
		this.appearanceAndDatetime = appearanceAndDatetime;
	}

	public String getAppearanceNr() {
		return this.appearanceNr;
	}

	public void setAppearanceNr(String appearanceNr) {
		this.appearanceNr = appearanceNr;
	}

	public String getAppearanceStartDatetime() {
		return this.appearanceStartDatetime;
	}

	public void setAppearanceStartDatetime(String appearanceStartDatetime) {
		this.appearanceStartDatetime = appearanceStartDatetime;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public CasesTrial getCasesTrial() {
		return this.casesTrial;
	}

	public void setCasesTrial(CasesTrial casesTrial) {
		this.casesTrial = casesTrial;
	}

	public PeopleRole getPeopleRole() {
		return this.peopleRole;
	}

	public void setPeopleRole(PeopleRole peopleRole) {
		this.peopleRole = peopleRole;
	}

}