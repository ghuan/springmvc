package com.fanfan.system.dao;

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
     * 获取日志数据
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    public List<Log> getLog(String startTime, String endTime, int type);
}
