package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.User;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：管理service接口
 */
public interface ISystemService{

	/**
	 * 登陆并获取用户所有信息
	 * @param user
	 * @return
	 */
	public LoginInfo LoginAndGetLoginInfo(User user);
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public Dict getDictByPath(String path);
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public List<Dict> getDictListByPath(String path);
	
	/**
	 * 加载子系统的菜单
	 * @param pid
	 * @param subsystemid
	 * @return
	 */
	public List<Menu> loadSubsystemMenu(String pid,String subsystemid,LoginInfo loginInfo);
	
	/**
	 * 修改用户密码
	 * @param user
	 */
	public void modifyPWD(String loginName,String oldPwd,String newPwd);
	
	/**
	 * 下载本地文件
	 * @param localPath
	 * @param fileName
	 * @param response
	 */
	public void downloadLocalFile(String localFilePath,String returnFileName);
	
	/**
	 * 二进制转文件并下载
	 * @param content
	 * @param returnFileName
	 * @param response
	 */
	public void downloadBinaryFile(byte[] content,String returnFileName);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 验证权限
	 * @param authPath
	 * @return
	 */
	public boolean checkSystemAuth(String authPath,LoginInfo loginInfo);
	
	/**
	 * 显示二进制图片
	 * @param content
	 */
	public void showBinaryImage(byte[] content);
	
}
