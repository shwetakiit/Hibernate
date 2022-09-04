package kumari.shweta.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name="IMMUTABLE")
@Immutable
public class ImmutableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public String name;
	public String address;
	
	//Non Immutable Entity 
	
	@OneToOne
	@JoinColumn(name="USER_ID",referencedColumnName = "USER_ID")
	UserDTO userDTO;
	
	public ImmutableEntity() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "ImmutableEntity [id=" + id + ", name=" + name + ", address=" + address + ", userDTO=" + userDTO + "]";
	}
	
	
	
}
