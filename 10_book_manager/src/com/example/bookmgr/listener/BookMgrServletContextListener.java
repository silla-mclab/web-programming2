package com.example.bookmgr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.bookmgr.model.DbConnectionInfo;

public class BookMgrServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		
		ServletContext context = sce.getServletContext();
		
		DbConnectionInfo connInfo = new DbConnectionInfo();
		connInfo.setDriver(context.getInitParameter("jdbc_driver"));
		connInfo.setUrl(context.getInitParameter("db_url"));
		connInfo.setUser(context.getInitParameter("db_user"));
		connInfo.setPasswd(context.getInitParameter("db_passwd"));
		connInfo.setDbTable(context.getInitParameter("db_table"));
		
		context.setAttribute("connection_info", connInfo);
	}
}
