package com.app.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMERKEY")
	private Long id;
	@Column(name = "CUSTOMERNAME", nullable = false, unique = true)
	private String customername;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "UPDATEUSER")
	private Users updateUser;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "CREATEUSER")
	private Users createUser;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Organization_Owners> organization_Owners;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Users getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Users updateUser) {
		this.updateUser = updateUser;
	}

	public Users getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Users createUser) {
		this.createUser = createUser;
	}

	public List<Organization_Owners> getOrganization_Owners() {
		return organization_Owners;
	}

	public void setOrganization_Owners(List<Organization_Owners> organization_Owners) {
		this.organization_Owners = organization_Owners;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createUser, customername, id, organization_Owners, updateUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(createUser, other.createUser) && Objects.equals(customername, other.customername)
				&& Objects.equals(id, other.id) && Objects.equals(organization_Owners, other.organization_Owners)
				&& Objects.equals(updateUser, other.updateUser);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customername=" + customername + ", updateUser=" + updateUser + ", createUser="
				+ createUser + ", organization_Owners=" + organization_Owners + "]";
	}

}
