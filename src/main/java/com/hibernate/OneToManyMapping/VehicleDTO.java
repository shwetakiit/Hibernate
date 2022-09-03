package com.hibernate.OneToManyMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")

public class VehicleDTO {
	@Id
	@Column(name="V_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicleId;
	
	@Column(name="VEHICLENAME")
	private String vehicleName;
	
	@Column(name="VEHICLE_TYPE")
	
	String vehicleType;
	
	@Column(name="STEERING_TYPE")
	
	String steeringType;
	
	@ManyToOne
	@JoinColumn(name="USER_ID",nullable =false)
	UserDTO user1;

	public VehicleDTO(Integer vehicleId, String vehicleName, String vehicleType, String steeringType) {
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.steeringType = steeringType;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getSteeringType() {
		return steeringType;
	}

	public void setSteeringType(String steeringType) {
		this.steeringType = steeringType;
	}
	
	
	
	

}
