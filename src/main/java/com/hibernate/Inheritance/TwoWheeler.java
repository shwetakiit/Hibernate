package com.hibernate.Inheritance;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	
	String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}
//मप्ु्ह्ु्ुिन्न्
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	

}
