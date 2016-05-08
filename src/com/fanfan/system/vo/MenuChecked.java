package com.fanfan.system.vo;

import com.fanfan.system.entity.Menu;
import com.fanfan.system.util.VTools;

/**
 * 
* Copy right huan.gao 下午6:53:29
* All right reserved
* QQ:2223486623 
* description：菜单权限选择树bean
 */
public class MenuChecked extends Menu {

	private static final long serialVersionUID = 1L;
	private String checks;

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

	public boolean getChecked() {
		return !VTools.StringIsEmpty(this.checks);
	}

	public boolean getCheck() {
		return getChecked();
	}
}
