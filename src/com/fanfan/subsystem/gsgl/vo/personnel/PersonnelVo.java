package com.fanfan.subsystem.gsgl.vo.personnel;


@SuppressWarnings("serial")
public class PersonnelVo implements java.io.Serializable {

    // Fields
	private String id;
	private String name;
	private Integer sex;
	private String idCard;
	private String birthday;
	private String address;
	private String phone;
	
	public PersonnelVo() {
		 
	}
	
	public PersonnelVo(String id, String name, Integer sex, String idCard,
			String birthday, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.idCard = idCard;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		
	}
	

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

	@Override
	public String toString() {
		return "PersonnelVo [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", idCard=" + idCard + ", birthday=" + birthday + ""
						+ ", address=" + address + ", phone=" + phone
				+"]";
	}
	
 }