package com.fanfan.system.dao.imp;

import com.fanfan.system.dao.ILogDao;
import com.fanfan.system.entity.Log;
import com.fanfan.system.entity.Org;
import com.fanfan.system.util.VTools;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:系统日志Dao
 * @autor: huan.gao
 * @Time: 2016/9/12 15:55
 */
@Repository
public class LogDaoImpl extends BaseDaoImpl implements ILogDao{
    @Override
    public void saveOrUpdate(Log log) {
        super.saveOrUpdate(log);
    }

    @Override
    public void delete(String id) {
        super.executeHql("delete from Log where id = ?0",new Object[]{id});
    }

    @Override
    public List<Log> getLog(String startTime, String endTime, int type) {
        String sql = "select * from t_sys_log t where 1 = 1";
        if(!VTools.StringIsEmpty(startTime)){
            sql += " and t.createTime >= '"+startTime+"'";
        }
        if(!VTools.StringIsEmpty(endTime)){
            sql += " and t.createTime <= '"+endTime+"'";
        }
        sql += " and t.type = " + type + " order by createtime desc";
        return super.queryListBeanBySql(Log.class,sql,new Object[]{});
    }
}
