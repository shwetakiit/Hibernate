package com.hibernate.hibernatepractice;

import javax.persistence.*;

@Entity
//@Table(name="two_wheeler")
//@PrimaryKeyJoinColumn(name = "VEHICLE_ID")
//@DiscriminatorValue("Bike")
public class TwoWheelerDTO extends VehicleDTO
{
        @Column(name="STEERING_TYPE")
        private String steeringTwoWheeler;

 public String getSteeringTwoWheeler()
 {
  return steeringTwoWheeler;
 }

 public void setSteeringTwoWheeler(String steeringTwoWheeler) 
 {
  this.steeringTwoWheeler = steeringTwoWheeler;
 }

@Override
public String toString() {
	return "TwoWheelerDTO [steeringTwoWheeler=" + steeringTwoWheeler + "]";
}
 
 
}