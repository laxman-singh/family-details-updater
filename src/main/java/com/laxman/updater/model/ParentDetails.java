package com.laxman.updater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
@Entity
@Table (name="parent_details")
public class ParentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "father_name")
	@NotEmpty(message = "Please enter father's name.")
	private String fatherName;
	
	@Column(name = "mother_name")
	@NotEmpty(message = "Please enter mother's name.")
	private String motherName;
	
	@Column(name = "father_occ")
	@NotEmpty(message = "Please enter father's occupation.")
	private String fatherOcc;
	
	@Column(name = "mother_occ")
	@NotEmpty(message = "Please enter mother's occupation.")
	private String motherOcc;
	
	@Column(name = "phone")
	@NotEmpty(message = "Please enter phone no")
	private String phone;
	
	@Column(name = "address")
	@NotEmpty(message = "Please enter address.")
	private String address;
	
	//@ManyToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "children_details", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
	@OneToMany(mappedBy="parentDetails", cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private List<ChildrenDetails> childrenDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherOcc() {
		return fatherOcc;
	}

	public void setFatherOcc(String fatherOcc) {
		this.fatherOcc = fatherOcc;
	}

	public String getMotherOcc() {
		return motherOcc;
	}

	public void setMotherOcc(String motherOcc) {
		this.motherOcc = motherOcc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ChildrenDetails> getChildrenDetails() {
		if(childrenDetails == null) {
			childrenDetails = new ArrayList<ChildrenDetails>();
		}
		return childrenDetails;
	}

	public void setChildrenDetails(List<ChildrenDetails> childrenDetails) {
		this.childrenDetails = childrenDetails;
	}
}
