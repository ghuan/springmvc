package com.fanfan.system.ws.service;


import com.fanfan.subsystem.gsgl.dao.personnel.IPersonnelJbxxMngDao;
import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.system.core.hibernate.Page;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * @description:获取员工分页数据 webservice
 * @autor: huan.gao
 * @Time: 2016/9/21 15:06
 */
@Service
@WebService(targetNamespace = "com.fanfan.system.ws.service")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class GetPersonnel {

    @Autowired
    private IPersonnelJbxxMngDao personnelJbxxMngDao;

    @WebMethod
    public String getPersonnelPage(){
        Page page = new Page();
        page.setLimit(20);
        page.setStart(0);
        Page page1 =  personnelJbxxMngDao.queryPersonnelPage(page,new Personnel());
        return ((ArrayList<Personnel>)page1.getData()).toString();
    }
}
