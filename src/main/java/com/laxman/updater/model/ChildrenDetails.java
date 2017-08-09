package com.laxman.updater.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author "Laxman Singh ~ laxman.1390@gmail.com"
 *
 */
@Entity
@Table (name = "children_details")
public class ChildrenDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "child_id")
	private int childId;
	
	@Column (name = "child_name")
	@NotEmpty (message = "Please Enter Child Name")
	private String childName;
	
	@Column (name = "child_dob")
	@NotNull (message = "Please Enter Child's date of birth")
	private Date childDob;
	
	@Column (name = "child_gender")
	@NotNull (message = "Please Enter Child's gender")
	@Enumerated(EnumType.STRING)
	private Gender childGender;
	
	@ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private ParentDetails parentDetails;
		
	public ParentDetails getParentDetails() {
		return parentDetails;
	}

	public void setParentDetails(ParentDetails parentDetails) {
		this.parentDetails = parentDetails;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Date getChildDob() {
		return childDob;
	}

	public void setChildDob(Date childDob) {
		this.childDob = childDob;
	}

	public Gender getChildGender() {
		return childGender;
	}

	public void setChildGender(Gender childGender) {
		this.childGender = childGender;
	}

	public enum Gender {
	    M("Male"),
	    F("Female"),
	    UNKNOWN("Unknown");

	    private final String name;

	    private Gender(String name) {
	        this.name = name;
	    }
	    
	    public String getGenderName() {
	        return this.name;
	    }
	}
}
