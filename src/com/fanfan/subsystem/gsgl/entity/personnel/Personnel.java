package com.fanfan.subsystem.gsgl.entity.personnel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fanfan.system.util.constants.System_Constants;

@Entity
@Table(name = "T_JBXX_PERSONNEL")
public class Personnel {

	@Id
	@GeneratedValue(generator = System_Constants.MY_UUID)
	@GenericGenerator(name = System_Constants.MY_UUID, strategy = System_Constants.PACKAGE_UUIDCLASS)
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	private String name;
	private Integer sex;
	private String idCard;
	private String birthday;
	private String address;
	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}