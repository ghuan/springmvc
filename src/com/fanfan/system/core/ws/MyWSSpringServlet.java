package com.fanfan.system.core.ws;

/**
 * @description:
 * @autor: huan.gao
 * @Time: 2016/9/27 13:29
 */

import com.sun.xml.ws.transport.http.servlet.ServletAdapterList;
import com.sun.xml.ws.transport.http.servlet.SpringBinding;
import com.sun.xml.ws.transport.http.servlet.SpringBindingList;
import com.sun.xml.ws.transport.http.servlet.WSServletDelegate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @description:自定义WSSpringServlet
 * @autor: huan.gao
 * @Time: 2016/9/26 16:27
 */
public class MyWSSpringServlet extends HttpServlet {

    private WSServletDelegate delegate;
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        LinkedHashSet bindings = new LinkedHashSet();
        Map m = wac.getBeansOfType(SpringBindingList.class);
        Iterator l = m.values().iterator();

        while(l.hasNext()) {
            SpringBindingList i$ = (SpringBindingList)l.next();
            bindings.addAll(i$.getBindings());
        }

        bindings.addAll(wac.getBeansOfType(SpringBinding.class).values());
        ServletAdapterList l1 = new ServletAdapterList();
        Iterator i$1 = bindings.iterator();

        while(i$1.hasNext()) {
            Object binding = i$1.next();
            Class c = binding.getClass();
            Field[] fs = c.getDeclaredFields();
            for(Field f : fs){
                f.setAccessible(true);
                try {
                    if("urlPattern".equals(f.getName())){
                        String path = servletConfig.getServletContext().getInitParameter("url");
                        System.out.println("加载webservice:"+path +f.get(binding)+"?wsdl");
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            ((SpringBinding)binding).create(l1);
        }

        this.delegate = new WSServletDelegate(l1, this.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.delegate.doPost(request, response, this.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.delegate.doGet(request, response, this.getServletContext());
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.delegate.doPut(request, response, this.getServletContext());
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.delegate.doDelete(request, response, this.getServletContext());
    }
}
