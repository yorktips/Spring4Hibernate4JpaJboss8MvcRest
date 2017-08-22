package com.tca.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the general_licensees database table.
 * 
 */
@Entity
@Table(name="general_licensees")
@NamedQuery(name="GeneralLicensee.findAll", query="SELECT g FROM GeneralLicensee g")
public class GeneralLicensee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@NotEmpty(message = "Please enter addresss.")
	@Size(min = 2, max = 255, message = "Address must less than 255 characters")
	private String address;

	private String address2;

	private String address3;

	@NotEmpty(message = "Please enter City.")
	@Size(min = 1, max = 120, message = "City must less than 120 characters")
	private String city;

	@NotEmpty(message = "Please enter Country.")
	@Size(min = 1, max = 120, message = "Country must less than 120 characters")
	//@Pattern(regexp="^[A-Z]",message="First one must upper case")
	private String country;

	@Column(name="full_description")
	@Size(max = 255, message = "Full Description must less than 255 characters")
	private String fullDescription;

	@NotEmpty(message = "Please enter Masked Id.")
	@Pattern(regexp="[0-9]{6}",message="Masked Id must be 6 digits")
	@Column(name="masked_id")
	private String maskedId;

	@NotEmpty(message = "Please enter Masked Id.")
	@Size(min = 1, max = 120, message = "Name must less than 120 characters")
	private String name;

	@Size(max=12, message = "Post Code must less than 12 characters")
	@Column(name="post_code")
	private String postCode;

	@NotEmpty(message = "Please enter SIC.")
	@Pattern(regexp="[0-9]{5,6}",message="value can contain only 6 digits")
	private String sic;

	@Column(name="state_prov")
	@NotEmpty(message = "Please enter State/Prov.")
	@Size(min=2, max = 12, message = "SIC code must less than 6 characters")
	private String stateProv;

	@Transient
	private int rowsperpage;
	
	public GeneralLicensee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFullDescription() {
		return this.fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getMaskedId() {
		return this.maskedId;
	}

	public void setMaskedId(String maskedId) {
		this.maskedId = maskedId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getSic() {
		return this.sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	public String getStateProv() {
		return this.stateProv;
	}

	public void setStateProv(String stateProv) {
		this.stateProv = stateProv;
	}

	public int getRowsperpage() {
		return rowsperpage;
	}

	public void setRowsperpage(int rowsperpage) {
		this.rowsperpage = rowsperpage;
	}
	
}