package com.fanfan.system.vo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.Org;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserExt;
import com.fanfan.system.util.VTools;

/**
 * 
* Copy right huan.gao 2015-7-5上午12:29:43
* All right reserved
* QQ:2223486623 
* description：用户信息
 */
@Service
public class LoginInfo
{
  private boolean success;
  private User user;
  private String message;
  private List<Menu> subsystem;
  private List<Role> roles;
  private Org org;
  private List<UserExt> userExts;

  public boolean isSuccess()
  {
    return this.success;
  }
  public void setSuccess(boolean success) {
    this.success = success;
  }
  public User getUser() {
    return this.user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  public String getMessage() {
    return this.message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public List<Menu> getSubsystem() {
    return this.subsystem;
  }
  public void setSubsystem(List<Menu> subsystem) {
    this.subsystem = subsystem;
  }
  public List<Role> getRoles() {
    return this.roles;
  }
  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
  public Org getOrg() {
    return this.org;
  }
  public void setOrg(Org org) {
    this.org = org;
  }
  public List<UserExt> getUserExts() {
    return this.userExts;
  }
  public void setUserExts(List<UserExt> userExts) {
    this.userExts = userExts;
  }

  public String getRoleString()
  {
    if (!VTools.ListIsEmpty(this.roles))
    {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < this.roles.size(); i++)
      {
        sb.append("'");
        sb.append(((Role)this.roles.get(i)).getId());
        sb.append("',");
      }
      sb.deleteCharAt(sb.length() - 1);
      return sb.toString();
    }

    return "";
  }
}
