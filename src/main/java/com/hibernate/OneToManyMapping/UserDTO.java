package com.hibernate.OneToManyMapping;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserDTO {
	
	@Id
	@Column(name="U_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(name="USER_NAME")
	private String userName;
	
   @OneToMany(mappedBy = "user1")
   Collection<VehicleDTO> vehicleDTO;
	
	
	public UserDTO(Integer userId, String userName) {
		
		this.userId = userId;
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<VehicleDTO> getVehicleDTO() {
		return vehicleDTO;
	}
	public void setVehicleDTO(Collection<VehicleDTO> vehicleDTO) {
		this.vehicleDTO = vehicleDTO;
	}
	
	
	

}
