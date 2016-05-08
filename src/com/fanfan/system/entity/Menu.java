package com.fanfan.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fanfan.system.util.constants.System_Constants;

@Entity
@Table(name = "T_SYS_MENU")
public class Menu implements Serializable{
	
	private static final long serialVersionUID = 6296626952423805366L;
	
	@Id
	@GeneratedValue(generator = System_Constants.MY_UUID)
	@GenericGenerator(name = System_Constants.MY_UUID, strategy = System_Constants.PACKAGE_UUIDCLASS)
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	private String name;
	private String iconCls;
	private String url;
	private Integer type;
	private Integer state;
	private Integer openMethod;
	private Integer rank;
	private String pid;
	private String remark;
	@Transient
	private Integer subNodes;

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

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getOpenMethod() {
		return openMethod;
	}

	public void setOpenMethod(Integer openMethod) {
		this.openMethod = openMethod;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSubNodes() {
		return subNodes;
	}
	public void setSubNodes(Integer subNodes) {
		this.subNodes = subNodes;
	}

	@Transient
	public boolean getLeaf() {
		if (this.type == null) {
			return false;
		}

		switch (this.type.intValue()) {
		case 1:
		case 2:
			return false;
		case 4:
			return true;
		case 3:
			return (this.subNodes == null) || (this.subNodes.intValue() <= 0);
		}

		return true;
	}
}
