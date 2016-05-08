package com.fanfan.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fanfan.system.util.constants.System_Constants;

@Entity
@Table(name = "T_SYS_FILES")
public class Files {

	@Id
	@GeneratedValue(generator = System_Constants.MY_UUID)
	@GenericGenerator(name = System_Constants.MY_UUID, strategy = System_Constants.PACKAGE_UUIDCLASS)
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	private String title;
	private byte[] blobContent;
	private String clobContent;
	private String updateTime;
	private String type;
	public Files() {
	   super();
	}

	//构造方法
	public Files(String id, String title, String updateTime, String type) {
		this.id=id;
	    this.title = title;
	    this.updateTime = updateTime;
	    this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	@Lob
	//@Basic(fetch = FetchType.LAZY)默认值
	//@Type(type = "org.springframework.orm.hibernate3.support.BlobByteArrayType")默认值
	public byte[] getBlobContent() {
		return blobContent;
	}
	public void setBlobContent(byte[] blobContent) {
		this.blobContent = blobContent;
	}
	@Lob
	//@Basic(fetch = FetchType.LAZY)默认值
	@Type(type = "org.hibernate.type.MaterializedClobType")
	public String getClobContent() {
		return clobContent;
	}
	public void setClobContent(String clobContent) {
		this.clobContent = clobContent;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}