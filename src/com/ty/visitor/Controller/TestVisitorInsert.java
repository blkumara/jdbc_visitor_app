package com.ty.visitor.Controller;

import java.util.List;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class TestVisitorInsert {
public static void main(String[] args) {
	
	Visitor visitor = new Visitor();
	 
	VisitorDao dao=new  VisitorDao();
	
//	visitor.setId(3);
//	visitor.setName("pavan ");
//	visitor.setEmail("pavan@gamil.com");
//	visitor.setPhone(7441524541l);
//	visitor.setAge(24);
//	visitor.setGender("male");;
//	visitor.setDOB("18/01/1998");
//	visitor.setVisitDateTime("5/05/2022");
//	
//
//	int res=dao.saveVisitor(visitor);
//	if(res>0)
//	{
//		System.out.println("Data Inserted");
//	}
//	else
//	{
//		System.out.println("No data Inserted");
//	}
	
	Visitor visitor2=dao.getvisitorById(3);
	System.out.println(visitor2);
	
	
	
//	List<Visitor> list=dao.getAllVisitorByDate("29/10/2019");
//	System.out.println(list);
	
//	List<Visitor> list=dao.getAllVisitorByAgeRange(18,22);
//		System.out.println(list);
	
	
//	
}
}
