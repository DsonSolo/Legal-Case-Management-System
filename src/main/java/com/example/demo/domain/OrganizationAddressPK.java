package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the organization_addresses database table.
 * 
 */
@Embeddable
public class OrganizationAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="organization_id")
	private int organizationId;

	@Column(insertable=false, updatable=false)
	private int addresses_address_id;

	@Column(insertable=false, updatable=false)
	private int organizations_organization_id;

	public OrganizationAddressPK() {
	}
	public int getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getAddresses_address_id() {
		return this.addresses_address_id;
	}
	public void setAddresses_address_id(int addresses_address_id) {
		this.addresses_address_id = addresses_address_id;
	}
	public int getOrganizations_organization_id() {
		return this.organizations_organization_id;
	}
	public void setOrganizations_organization_id(int organizations_organization_id) {
		this.organizations_organization_id = organizations_organization_id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrganizationAddressPK)) {
			return false;
		}
		OrganizationAddressPK castOther = (OrganizationAddressPK)other;
		return 
			(this.organizationId == castOther.organizationId)
			&& (this.addresses_address_id == castOther.addresses_address_id)
			&& (this.organizations_organization_id == castOther.organizations_organization_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId;
		hash = hash * prime + this.addresses_address_id;
		hash = hash * prime + this.organizations_organization_id;
		
		return hash;
	}
}