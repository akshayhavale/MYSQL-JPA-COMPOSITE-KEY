package com.app.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Organization_Owner_Key implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long customer_seq;
	private Long user_seq;

	public Long getCustomer_seq() {
		return customer_seq;
	}

	public void setCustomer_seq(Long customer_seq) {
		this.customer_seq = customer_seq;
	}

	public Long getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(Long user_seq) {
		this.user_seq = user_seq;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_seq, user_seq);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization_Owner_Key other = (Organization_Owner_Key) obj;
		return Objects.equals(customer_seq, other.customer_seq) && Objects.equals(user_seq, other.user_seq);
	}

	@Override
	public String toString() {
		return "Organization_Owner_Key [customer_seq=" + customer_seq + ", user_seq=" + user_seq + "]";
	}

}
