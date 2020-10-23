package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the people_at_trial database table.
 * 
 */
@Embeddable
public class PeopleAtTrialPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="trial_id")
	private int trialId;

	@Column(insertable=false, updatable=false)
	private int people_Roles_person_id;

	@Column(insertable=false, updatable=false)
	private int people_Roles_People_person_id;

	@Column(insertable=false, updatable=false)
	private int cases_Trials_case_trial_id;

	public PeopleAtTrialPK() {
	}
	public int getTrialId() {
		return this.trialId;
	}
	public void setTrialId(int trialId) {
		this.trialId = trialId;
	}
	public int getPeople_Roles_person_id() {
		return this.people_Roles_person_id;
	}
	public void setPeople_Roles_person_id(int people_Roles_person_id) {
		this.people_Roles_person_id = people_Roles_person_id;
	}
	public int getPeople_Roles_People_person_id() {
		return this.people_Roles_People_person_id;
	}
	public void setPeople_Roles_People_person_id(int people_Roles_People_person_id) {
		this.people_Roles_People_person_id = people_Roles_People_person_id;
	}
	public int getCases_Trials_case_trial_id() {
		return this.cases_Trials_case_trial_id;
	}
	public void setCases_Trials_case_trial_id(int cases_Trials_case_trial_id) {
		this.cases_Trials_case_trial_id = cases_Trials_case_trial_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeopleAtTrialPK)) {
			return false;
		}
		PeopleAtTrialPK castOther = (PeopleAtTrialPK)other;
		return 
			(this.trialId == castOther.trialId)
			&& (this.people_Roles_person_id == castOther.people_Roles_person_id)
			&& (this.people_Roles_People_person_id == castOther.people_Roles_People_person_id)
			&& (this.cases_Trials_case_trial_id == castOther.cases_Trials_case_trial_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trialId;
		hash = hash * prime + this.people_Roles_person_id;
		hash = hash * prime + this.people_Roles_People_person_id;
		hash = hash * prime + this.cases_Trials_case_trial_id;
		
		return hash;
	}
}