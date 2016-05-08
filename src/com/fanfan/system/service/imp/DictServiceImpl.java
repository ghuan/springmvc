package com.fanfan.system.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.dao.IDictDao;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.service.IDictService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.System_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	数据字典service
 */
@Service
@Transactional //异常回滚
public class DictServiceImpl implements IDictService{

	@Autowired
	private IDictDao dictDao;
	
	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Dict dict){
		//后台获取前台空字段是空字符串，所以这里需要转为null
		if(VTools.StringIsEmpty(dict.getId())){
			
			dict.setId(null);
			dict.setUpdateTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
		}
		dictDao.saveOrUpdate(dict);
	}
	
	/**
	 * 删除数据字典
	 */
	public void delete(String[] ids){
		
		String strIds = "";
		for(String str:ids){
			
			strIds+=str+",";
		}
		for(int i = 0;i<ids.length;i++){
			
			List<Dict> list = dictDao.getDictByPid(ids[i]);
			if(!VTools.ListIsEmpty(list)){
				
				for(Dict dict : list){
					
					if(strIds.indexOf(dict.getId()) == -1){
						
						throw new BusinessException("有数据字典包含未选择删除的子节点，请先选择删除该子节点！");
					}
				}
				
			}
			dictDao.delele(ids[i]);
		}
	}
	
	/**
	 * 加载数据字典数据
	 * @param pid
	 * @return
	 */
	public List<Dict> loadSystemDicts(String pid) {
		// TODO Auto-generated method stub
		if(VTools.StringIsEmpty(pid)){
			
			throw new BusinessException("父节点pid值为空！");
		}
		return dictDao.getDictByPid(pid);
	}

	
	
}
