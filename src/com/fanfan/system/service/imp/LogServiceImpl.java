package com.fanfan.system.service.imp;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.ILogDao;
import com.fanfan.system.entity.Log;
import com.fanfan.system.entity.Org;
import com.fanfan.system.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:系统日志 service
 * @autor: huan.gao
 * @Time: 2016/9/12 15:37
 */
@Service
@Transactional
public class LogServiceImpl implements ILogService{

    @Autowired
    private ILogDao logDao;

    @Override
    public void saveOrUpdate(Log log) {
        logDao.saveOrUpdate(log);
    }

    @Override
    public void delete(String[] ids) {
        for(String id : ids){
            logDao.delete(id);
        }
    }

    @Override
    public Page getLogPage(Page page, String startTime, String endTime, int type, String userId) {
        return logDao.getLogPage(page,startTime,endTime,type,userId);
    }

    @Override
    public String getExceptionDetail(String id){
        return logDao.getExceptionDetail(id);
    }
}
