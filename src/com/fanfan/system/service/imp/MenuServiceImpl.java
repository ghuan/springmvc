package com.fanfan.system.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.dao.IMenuDao;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.service.IMenuService;
import com.fanfan.system.util.VTools;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	菜单service
 */
@Service
@Transactional //异常回滚
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private IMenuDao menuDao;
	
	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Menu menu){
		//后台获取前台空字段是空字符串，所以这里需要转为null
		if(VTools.StringIsEmpty(menu.getId())){
			
			menu.setId(null);
		}
		menuDao.saveOrUpdate(menu);
	}
	
	
	/**
	 * 删除菜单
	 */
	@SuppressWarnings("unchecked")
	public void delete(String[] ids){
		
		String strIds = "";
		for(String str:ids){
			
			strIds+=str+",";
		}
		for(int i = 0;i<ids.length;i++){
			
			List<Menu> list = menuDao.queryMenusByPid(ids[i]);
			if(!VTools.ListIsEmpty(list)){
				
				for(Menu menu:list){
					
					if(strIds.indexOf(menu.getId()) == -1){
						
						throw new BusinessException("有菜单包含未选择删除的子菜单，请先选择删除该子菜单！");
					}
				}
				
			}
			menuDao.delete(ids[i]);
		}
	}
	
	/**
	 * 加载菜单
	 * @param pid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> loadMenu(String pid){
		
	    return menuDao.queryMenusByPid(pid);
	}
}
