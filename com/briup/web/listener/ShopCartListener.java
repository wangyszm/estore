package com.briup.web.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.briup.bean.Customer;
import com.briup.bean.Line;
import com.briup.bean.Order;
import com.briup.service.impl.CustomerServiceImpl;
import com.briup.service.impl.LineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;

/**
 * Application Lifecycle Listener implementation class ShopCartListener
 *
 */
@WebListener
public class ShopCartListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ShopCartListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	
    	if("username".equals(se.getName())){
	    	HttpSession session = se.getSession();
	    
	    	String userName =(String) session.getAttribute("username");
	    	Order order=getOrder(userName);
	    	session.setAttribute("order", order);
	    	
	    	Map<Long, Line> oldLines = getLines(order);
	    	if(oldLines!=null){
	    		session.setAttribute("oldLines", oldLines);
	    	}
	    	
	    	Map<Long,Line> newLines=new HashMap<Long,Line>();
	    	Map<Long,Line> deleteLines=new HashMap<>();
	    	
	    	session.setAttribute("deleteLines", deleteLines);
	    	session.setAttribute("newLines", newLines);
	    	
	    	System.out.println("-------看看能不能执行到这--------");
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

    private Order getOrder(String userName){
    	Order order=OrderServiceImpl.getInstance().findOrderByCustomer(userName);
    	
    	if(order==null){
    		Customer customer=CustomerServiceImpl.getInstance().getCustomer(userName, null);
    		order=new Order(0d,new Date(),customer);
    		//没取出order证明数据库中无值，此时向数据库中添加该数据
    		//用户下线后仅需更新数据库数据便可
    		//同时需要重新获得order以便得到id
    		OrderServiceImpl.getInstance().addOrder(order, customer);
    		order=OrderServiceImpl.getInstance().findOrderByCustomer(userName);
    		return order;
    	}
    	return order;
    }
    
    private Map<Long,Line> getLines(Order order){
    	Map<Long, Line> oldLines = LineServiceImpl.getInstance().findLine(order);
    	
    	if(oldLines==null){
    		return null;
    	}
    	return oldLines;
    }
}
