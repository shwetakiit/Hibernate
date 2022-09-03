package com.hibernate.hibernatepractice;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="VEHICLE")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //One one table for parent and child entity both

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Table for each entity parent and child 
//DiscriminatorColumn not required
//@DiscriminatorColumn(name ="VEHICLE_TYPE",discriminatorType = DiscriminatorType.STRING)

@Inheritance(strategy = InheritanceType.JOINED)

public class VehicleDTO {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="VEHICLE_ID")
	 private int vehicleId;
	 
	
	 private String vehicleName;
	 
	 @Transient
	 private String modelNo;
	@Transient
	 private String launchDate;
	 
	 public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String string) {
		this.launchDate = string;
	}
	public int getVehicleId() {
	  return vehicleId;
	 }
	 public void setVehicleId(int vehicleId) {
	  this.vehicleId = vehicleId;
	 }
	 
	 public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	@Column(name="VEHICLE_NAME")
	 public String getVehicleName() {
	  return "HONDA";
	 }
	 public void setVehicleName(String vehicleName) {
	  this.vehicleName = vehicleName;
	 }
}


