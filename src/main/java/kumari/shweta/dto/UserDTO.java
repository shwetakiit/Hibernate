package kumari.shweta.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="USERTABLE")
@Table(name="USERTABLE") //If we don't prvide table name by default table name create with Entity name and attributes of table 
                    //is member variable of Entity class
public class UserDTO {
    
	@Id
	@Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE ->We need to provide primary key for inserting data
	private Integer userId;
	
	@Column(name="USERNAME")
	private String userName;
 
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

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
}
