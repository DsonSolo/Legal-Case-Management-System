package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the people_addresses database table.
 * 
 */
@Embeddable
public class PeopleAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="person_id")
	private int personId;

	@Column(insertable=false, updatable=false)
	private int people_person_id;

	@Column(insertable=false, updatable=false)
	private int addresses_address_id;

	public PeopleAddressPK() {
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
	public int getAddresses_address_id() {
		return this.addresses_address_id;
	}
	public void setAddresses_address_id(int addresses_address_id) {
		this.addresses_address_id = addresses_address_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeopleAddressPK)) {
			return false;
		}
		PeopleAddressPK castOther = (PeopleAddressPK)other;
		return 
			(this.personId == castOther.personId)
			&& (this.people_person_id == castOther.people_person_id)
			&& (this.addresses_address_id == castOther.addresses_address_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personId;
		hash = hash * prime + this.people_person_id;
		hash = hash * prime + this.addresses_address_id;
		
		return hash;
	}
}