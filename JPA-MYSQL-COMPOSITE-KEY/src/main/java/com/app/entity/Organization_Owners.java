package com.app.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORGANIZATION_OWNERS")
public class Organization_Owners implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Organization_Owner_Key org_owner_key = new Organization_Owner_Key();

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMERKEY")
	@MapsId("customer_seq")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "USERKEY")
	@MapsId("user_seq")
	private Users users;

	@Column(name = "POLICY", nullable = false)
	private Long policy = 1L;

	public Organization_Owner_Key getOrg_owner_key() {
		return org_owner_key;
	}

	public void setOrg_owner_key(Organization_Owner_Key org_owner_key) {
		this.org_owner_key = org_owner_key;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Long getPolicy() {
		return policy;
	}

	public void setPolicy(Long policy) {
		this.policy = policy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, org_owner_key, policy, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization_Owners other = (Organization_Owners) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(org_owner_key, other.org_owner_key)
				&& Objects.equals(policy, other.policy) && Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "Organization_Owners [org_owner_key=" + org_owner_key + ", customer=" + customer + ", users=" + users
				+ ", policy=" + policy + "]";
	}

}
