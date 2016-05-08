package com.fanfan.system.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.dao.IOrgDao;
import com.fanfan.system.entity.Org;
import com.fanfan.system.service.IOrgService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Org_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	组织部门service
 */
@Service
@Transactional //异常回滚
public class OrgServiceImpl implements IOrgService{

	@Autowired
	private IOrgDao orgDao;
	
	/**
	 * 保存或更新
	 * @param role
	 */
	public void saveOrUpdate(Org org){
		
		if(VTools.StringIsEmpty(org.getId())){
			
			org.setId(null);
		}
		
		orgDao.saveOrUpdate(org);
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String[] ids){
		
		String strIds = "";
		for(String str:ids){
			
			strIds+=str+",";
		}
		for(int i = 0;i<ids.length;i++){
			
			List<Org> list = orgDao.queryOrgByPid(ids[i]);
			if(!VTools.ListIsEmpty(list)){
				
				for(Org o:list){
					
					if(strIds.indexOf(o.getId()) == -1){
						
						throw new BusinessException("有节点包含未选择删除的子节点，请先选择删除该子节点！");
					}
				}
				
			}
			orgDao.delete(ids[i]);
		}
	}
	
	/**
	 * 获取组织结构数据
	 * @param pid
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Org> getOrg(String pid,String id,String queryText,String queryValue){
		
		if(!VTools.StringIsEmpty(queryText)){
			
			if(!VTools.StringIsEmpty(queryValue)){
				
				String[] ids = queryValue.split(",");
				return orgDao.queryOrgPathByIds(ids);
			}
			return orgDao.queryOrgPathByName(queryText.trim());
			
		}
		if(VTools.StringIsEmpty(pid) || Org_Constants.ROOT_DIRECTORY_PID.equals(pid)){
			
			if(VTools.StringIsEmpty(id) || Org_Constants.ROOT_DIRECTORY_PID.equals(id)){
				
				pid = Org_Constants.ROOT_DIRECTORY_PID;
			}else {
				
				Org o = orgDao.queryOrgById(id);
				List<Org> list = new ArrayList<Org>();
				list.add(o);
				return list;
			}
		}
		return orgDao.queryOrgByPid(pid);
		
	}
	
	/**
	 * 获取组织机构路径
	 * @param fromOrgid
	 * @param name
	 * @param initData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Org> getOrgByPath(String queryText,String queryValue){
		
		if(!VTools.StringIsEmpty(queryText)){
			
			if(!VTools.StringIsEmpty(queryValue)){
				
				String[] ids = {queryValue};
				return orgDao.queryOrgPathByIds(ids);
			}
			return orgDao.queryOrgPathByName(queryText.trim());
			
		}
		return null;
	}
	
}
