package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the people_roles database table.
 * 
 */
@Embeddable
public class PeopleRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="person_id")
	private int personId;

	@Column(insertable=false, updatable=false)
	private int people_person_id;

	public PeopleRolePK() {
	}
	public int getPersonId() {
		return this.personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getPeople_person_id() {
		return this.people_person_id;
	}
	public void setPeople_person_id(int people_person_id) {
		this.people_person_id = people_person_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeopleRolePK)) {
			return false;
		}
		PeopleRolePK castOther = (PeopleRolePK)other;
		return 
			(this.personId == castOther.personId)
			&& (this.people_person_id == castOther.people_person_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personId;
		hash = hash * prime + this.people_person_id;
		
		return hash;
	}
}