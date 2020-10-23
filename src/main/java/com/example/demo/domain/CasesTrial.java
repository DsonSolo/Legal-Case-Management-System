package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cases_trials database table.
 * 
 */
@Entity
@Table(name="cases_trials")
@NamedQuery(name="CasesTrial.findAll", query="SELECT c FROM CasesTrial c")
public class CasesTrial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="case_trial_id")
	private int caseTrialId;

	@Column(name="case_reference_number")
	private int caseReferenceNumber;

	@Column(name="expected_duration")
	private String expectedDuration;

	@Column(name="other_trial_details")
	private String otherTrialDetails;

	@Column(name="trial_address_id")
	private int trialAddressId;

	@Column(name="trial_end_date")
	private String trialEndDate;

	@Column(name="trial_location_name")
	private String trialLocationName;

	@Column(name="trial_outcome_code")
	private String trialOutcomeCode;

	@Column(name="trial_start_date")
	private String trialStartDate;

	@Column(name="trial_status_code")
	private String trialStatusCode;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Addresses_address_id")
	private Address address;

	//bi-directional many-to-one association to PeopleAtTrial
	@OneToMany(mappedBy="casesTrial")
	private List<PeopleAtTrial> peopleAtTrials;

	public CasesTrial() {
	}

	public int getCaseTrialId() {
		return this.caseTrialId;
	}

	public void setCaseTrialId(int caseTrialId) {
		this.caseTrialId = caseTrialId;
	}

	public int getCaseReferenceNumber() {
		return this.caseReferenceNumber;
	}

	public void setCaseReferenceNumber(int caseReferenceNumber) {
		this.caseReferenceNumber = caseReferenceNumber;
	}

	public String getExpectedDuration() {
		return this.expectedDuration;
	}

	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public String getOtherTrialDetails() {
		return this.otherTrialDetails;
	}

	public void setOtherTrialDetails(String otherTrialDetails) {
		this.otherTrialDetails = otherTrialDetails;
	}

	public int getTrialAddressId() {
		return this.trialAddressId;
	}

	public void setTrialAddressId(int trialAddressId) {
		this.trialAddressId = trialAddressId;
	}

	public String getTrialEndDate() {
		return this.trialEndDate;
	}

	public void setTrialEndDate(String trialEndDate) {
		this.trialEndDate = trialEndDate;
	}

	public String getTrialLocationName() {
		return this.trialLocationName;
	}

	public void setTrialLocationName(String trialLocationName) {
		this.trialLocationName = trialLocationName;
	}

	public String getTrialOutcomeCode() {
		return this.trialOutcomeCode;
	}

	public void setTrialOutcomeCode(String trialOutcomeCode) {
		this.trialOutcomeCode = trialOutcomeCode;
	}

	public String getTrialStartDate() {
		return this.trialStartDate;
	}

	public void setTrialStartDate(String trialStartDate) {
		this.trialStartDate = trialStartDate;
	}

	public String getTrialStatusCode() {
		return this.trialStatusCode;
	}

	public void setTrialStatusCode(String trialStatusCode) {
		this.trialStatusCode = trialStatusCode;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PeopleAtTrial> getPeopleAtTrials() {
		return this.peopleAtTrials;
	}

	public void setPeopleAtTrials(List<PeopleAtTrial> peopleAtTrials) {
		this.peopleAtTrials = peopleAtTrials;
	}

	public PeopleAtTrial addPeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().add(peopleAtTrial);
		peopleAtTrial.setCasesTrial(this);

		return peopleAtTrial;
	}

	public PeopleAtTrial removePeopleAtTrial(PeopleAtTrial peopleAtTrial) {
		getPeopleAtTrials().remove(peopleAtTrial);
		peopleAtTrial.setCasesTrial(null);

		return peopleAtTrial;
	}

}