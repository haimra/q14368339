package org.haim.springframwork.stackoverflow;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericService<T, T_DAO extends GenericDao<T>>{
	
	@Autowired
	private DaoLocator daoLocatorFactoryBean;

	T_DAO dao;
	
  
   @SuppressWarnings("unchecked")
   @PostConstruct
   protected void autowireDao(){
	   //Read the actual class at run time
	   final Type type; 
	   type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	   //figure out the class of of the fully qualified class name
	   //this way you can know the bean name to look for
	   final String typeClass = type.toString();	   
	   String daoName = typeClass.substring(typeClass.lastIndexOf('.')+1,typeClass.length());
	   daoName = Character.toLowerCase(daoName.charAt(0)) + daoName.substring(1);
	   
	   this.dao = (T_DAO) daoLocatorFactoryBean.lookup(daoName);
   }
   
   
   public void create(T record){
	   dao.create(record);
   }  
   
 }

