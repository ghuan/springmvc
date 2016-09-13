package com.fanfan.system.entity;

import com.fanfan.system.util.constants.System_Constants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "T_SYS_LOG")
public class Log {

	@Id
	@GeneratedValue(generator = System_Constants.MY_UUID)
	@GenericGenerator(name = System_Constants.MY_UUID, strategy = System_Constants.PACKAGE_UUIDCLASS)
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	private String description;
	private String method;
	private Integer type;
	private String params;
	private String exceptioncode;
	private String exceptiondetail;
	private String requestip;
	private String creator;
	private String createtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getExceptioncode() {
		return exceptioncode;
	}

	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode;
	}
	@Lob
	//@Basic(fetch = FetchType.LAZY)默认值
	@Type(type = "org.hibernate.type.MaterializedClobType")
	public String getExceptiondetail() {
		return exceptiondetail;
	}

	public void setExceptiondetail(String exceptiondetail) {
		this.exceptiondetail = exceptiondetail;
	}

	public String getRequestip() {
		return requestip;
	}

	public void setRequestip(String requestip) {
		this.requestip = requestip;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}