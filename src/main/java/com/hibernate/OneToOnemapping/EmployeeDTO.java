package com.hibernate.OneToOnemapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEE")
public class EmployeeDTO {
	
	@Id@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
private Integer employeeId;
	
	@Column(name= "E_NAME")
	private String name;
	
	
	   @OneToOne
	   @JoinColumn(name="ADDRESS_ID")
    	private AddressDTO addressDTO;
	
	@Column(name="ADDRESS_ID")
	Integer addressID;
	
   public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getAddressID() {
		return addressID;
	}
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	

}
