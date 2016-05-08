package com.fanfan.system.service.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.web.RequestResponseContext;
import com.fanfan.system.dao.ISystemDao;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.User;
import com.fanfan.system.service.ISystemService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Menu_Constants;
import com.fanfan.system.util.constants.User_Constants;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	管理service
 */
@Service
@Transactional //异常回滚
public class SystemServiceImpl implements ISystemService{

	@Autowired
	private ISystemDao systemDao;
	
	/**
	 * 登陆并获取用户所有信息
	 * @param user
	 * @return
	 */
	public LoginInfo LoginAndGetLoginInfo(User user){
		
//		User u1 = new User();
//		u1.setLOGINNAME("gaohuan d");
//		u1.setPASSWORD("111111111");
		
//		userDao.save(u1);
	    LoginInfo loginInfo = new LoginInfo();
	    if ((VTools.StringIsEmpty(user.getLoginName())) || (VTools.StringIsEmpty(user.getPassword())))
	    {
	      loginInfo.setSuccess(false);
	      loginInfo.setMessage("用户名或密码为空。");
	      throw new BusinessException("用户名或密码为空。");
	    }

	    User u = systemDao.getUser(user);
	    if (VTools.StringIsEmpty(u.getId()))
        {
          loginInfo.setSuccess(false);
          loginInfo.setMessage("输入的用户名不存在。");
          throw new BusinessException("输入的用户名不存在。");
        }
	    
	    String dbpwd = VTools.getMD5(user.getPassword());
	    boolean flag = dbpwd.equals(u.getPassword());
	    loginInfo.setSuccess(flag);

	    if (flag)
	    {
	      loginInfo.setUser(u);
	      loginInfo.setMessage("登陆成功。");
	      
	      //获取除用户基本信息外的其他信息
	      loginInfo.setOrg(systemDao.queryUserOrg(u));
	      loginInfo.setUserExts(systemDao.queryUserExt(u));

		    if (User_Constants.ADMIN_ID.equals(u.getId()))
		    {
		      loginInfo.setRoles(systemDao.getRoles());
		      loginInfo.setSubsystem(systemDao.queryMenusByRoles(loginInfo,  Menu_Constants.ROOT_DIRECTORY_PID, null, null));
		    }
		    else {
		      loginInfo.setSubsystem(systemDao.queryUserMenuByUserid(u.getId()));
		      loginInfo.setRoles(systemDao.queryUserRoleByUserid(u.getId()));
		    }
	    }
	    else {
	      loginInfo.setMessage("密码错误。");
	      throw new BusinessException("密码错误。");
	    }
	    return loginInfo;
	}
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public Dict getDictByPath(String path){
		
		return systemDao.getDictByPath(path);
	}
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public List<Dict> getDictListByPath(String path){
		
		return systemDao.getDictListByPath(path);
	}
	
	/**
	 * 加载子系统的菜单
	 * @param pid
	 * @param subsystemid
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Menu> loadSubsystemMenu(String pid,String subsystemid,LoginInfo loginInfo){
		
		List menus = null;
	    if (Menu_Constants.ROOT_DIRECTORY_PID.equals(pid))
	    {
	      if (VTools.StringIsEmpty(subsystemid))
	      {
	        if (VTools.ListIsEmpty(loginInfo.getSubsystem()))
	        {
	          return null;
	        }

	        menus = systemDao.queryMenusByRoles(loginInfo, Menu_Constants.ROOT_DIRECTORY_PID, ((Menu)loginInfo.getSubsystem().get(0)).getId(), null);
	      }
	      else {
	        menus = systemDao.queryMenusByRoles(loginInfo, Menu_Constants.ROOT_DIRECTORY_PID, subsystemid, null);
	      }
	    }
	    else {
	      menus = systemDao.queryMenusByRoles(loginInfo, pid, null, null);
	    }

	    return menus;
	}
	
	/**
	 * 修改用户密码
	 * @param user
	 */
	public void modifyPWD(String loginName,String oldPwd,String newPwd){
		
		User user = new User();
		user.setLoginName(loginName);
		user = systemDao.getUser(user);
		if(user.getPassword().equals(VTools.getMD5(oldPwd))){
			
			user.setPassword(VTools.getMD5(newPwd));
			systemDao.updateUser(user);
		}else {
			
			throw new BusinessException("您输入的原来密码不对，请重新输入！");
		}
	}
	
	/**
	 * 下载本地文件
	 * @param localFilePath
	 * @param returnFileName
	 * @param response
	 */
	public void downloadLocalFile(String localFilePath,String returnFileName){
		
		HttpServletResponse response = RequestResponseContext.getResponse();
		try {
			
			returnFileName = returnFileName + localFilePath.substring(localFilePath.lastIndexOf("."));
			InputStream inStream = new FileInputStream(localFilePath);
			response.reset();
	        response.setContentType("bin");
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(returnFileName.getBytes("GBK"),"ISO-8859-1") + "\"");
	        // 循环取出流中的数据
	        byte[] b = new byte[100];
	        int len;
	        while ((len = inStream.read(b)) > 0){
	        	
	        	response.getOutputStream().write(b, 0, len);
	        }
            inStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			try {
				response.getOutputStream().write("<meta charset='GBK'><script>alert('服务器内部错误！请联系管理员');</script>".getBytes());
				response.getOutputStream().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * 二进制转文件并下载
	 * @param content
	 * @param returnFileName
	 * @param response
	 */
	public void downloadBinaryFile(byte[] content,String returnFileName){
		
		HttpServletResponse response = RequestResponseContext.getResponse();
		try {
			
			String extensions = returnFileName.substring(returnFileName.lastIndexOf("."));//获取文件名后缀
			if(".xlsx".equals(extensions) || ".xls".equals(extensions)){//如果是excel文件
				
				 response.setContentType("application/x-excel");  
		         response.setCharacterEncoding("UTF-8");  
			     response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(returnFileName.getBytes("GBK"),"ISO-8859-1") + "\"");
		         //response.setHeader("Content-Length",String.valueOf(f.length())); 
		         OutputStream out=response.getOutputStream();
		         out.write(content);
		         out.flush();
		         out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				response.getOutputStream().write("<meta charset='GBK'><script>alert('服务器内部错误！请联系管理员');</script>".getBytes());
				response.getOutputStream().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user){
		
		systemDao.updateUser(user);
	}
	
	/**
	 * 验证权限
	 * @param authPath
	 * @return
	 */
	public boolean checkSystemAuth(String authPath,LoginInfo loginInfo){
		
		if(loginInfo.getUser().getId().equals(User_Constants.ADMIN_ID)){
			
			return true;
		}else {
			
			return systemDao.checkAuth(authPath, loginInfo.getUser().getId());
		}
	}
	
	/**
	 * 显示二进制图片
	 * @param content
	 */
	public void showBinaryImage(byte[] content){
		
		try {
			HttpServletResponse response = RequestResponseContext.getResponse();
			response.setContentType("image/jpeg");  
			OutputStream out=response.getOutputStream();
	        out.write(content);
	        out.flush();
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
