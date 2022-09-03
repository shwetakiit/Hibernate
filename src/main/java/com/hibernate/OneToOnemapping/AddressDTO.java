package com.hibernate.OneToOnemapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ADDRESS")
public class AddressDTO {
	@Id@GeneratedValue
    @Column(name = "ADDRESS_ID")
	private int addressId;
	@Column(name = "ADDRESS_NAME")
	private String addressDetail;
	
	//@Column(name="IS_CORRECT_ADDRESS" )
	//public boolean isCorrectAddress;
	
	/*public boolean isCorrectAddress() {
		return isCorrectAddress;
	}



	public void setCorrectAddress(boolean isCorrectAddress) {
		this.isCorrectAddress = isCorrectAddress;
	}
*/


	public int getAddressId() {
		return addressId;
	}
	

	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	
	

}
