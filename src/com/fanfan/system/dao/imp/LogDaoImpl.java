package com.fanfan.system.dao.imp;

import com.fanfan.system.core.hibernate.Page;
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
    public Page getLogPage(Page page, String startTime, String endTime, int type, String userId){
        String sql = "select t.*,t1.name as createName from t_sys_log t left join t_sys_user t1 on t1.id = t.creator where 1 = 1";
        if(!VTools.StringIsEmpty(startTime)){
            sql += " and t.createTime >= '"+startTime+" 00:00:00'";
        }
        if(!VTools.StringIsEmpty(endTime)){
            sql += " and t.createTime <= '"+endTime+" 23:59:59'";
        }
        if(!VTools.StringIsEmpty(userId)){
            sql += " and t.creator = '"+userId+"'";
        }
        sql += " and t.type = " + type + " order by t.createtime desc";
        return super.queryPageBySql(page,Log.class,sql,new Object[]{});
    }

    @Override
    public String getExceptionDetail(String id){
        return ((Log)super.queryObject("from Log where id = ?0",new Object[]{id})).getExceptionDetail();
    }
}
