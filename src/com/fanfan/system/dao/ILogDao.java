package com.fanfan.system.dao;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Log;
import com.fanfan.system.entity.Org;

import java.util.List;

/**
 * @description:系统日志Dao接口
 * @autor: huan.gao
 * @Time: 2016/9/12 15:52
 */
public interface ILogDao {
    /**
     * 保存或更新
     * @param log
     */
    public void saveOrUpdate(Log log);

    /**
     * 删除
     * @param id
     */
    public void delete(String id);

    /**
     * 获取日志分页数据数据
     * @param page
     * @param startTime
     * @param endTime
     * @param type
     * @param userId
     * @return
     */
    public Page getLogPage(Page page,String startTime, String endTime, int type, String userId);

    /**
     * 获取异常具体描述
     * @param id
     * @return
     */
    public String getExceptionDetail(String id);
}
