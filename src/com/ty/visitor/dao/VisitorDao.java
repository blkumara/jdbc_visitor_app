package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ty.visitor.util.AppConstant.SECRETE_KEY;
import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionObject;



public class VisitorDao {

	
	public int saveVisitor(Visitor visitor)
	{
String sql="insert into visitor values(?,?,?,?,?,?,?,?)";
		
		Connection connection=ConnectionObject.getConnection();
		
		 
		try {
			
			String enc=AES.encrypt(visitor.getName() ,SECRETE_KEY);
			String enc1=AES.encrypt(visitor.getEmail() ,SECRETE_KEY);
			//String enc2=AES.encrypt(visitor.getPhone()+"", SECRETE_KEY);
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, enc);
			preparedStatement.setString(3, enc1);
			preparedStatement.setLong(4,visitor.getPhone());
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDOB());
			preparedStatement.setString(8, visitor.getVisitDateTime());
			
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection !=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Visitor getvisitorById(int id)
	{
		Connection connection=ConnectionObject.getConnection();
		String sql="Select * From visitor where id=?";
		Visitor visitor= new Visitor();
		
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Visitor visitor2=new Visitor();
			visitor.setId(resultSet.getInt("id"));
			visitor.setName(AES.decrypt(resultSet.getString("name"),SECRETE_KEY));
			visitor.setEmail(AES.decrypt(resultSet.getString("email"),SECRETE_KEY));
			visitor.setPhone(resultSet.getLong("phone"));
			visitor.setAge(resultSet.getInt("age"));
			visitor.setGender(resultSet.getString("gender"));
			visitor.setDOB(resultSet.getString("DOB"));
			visitor.setVisitDateTime(resultSet.getString("visitDateTime"));
			
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return visitor;
		
	}
	
	public List<Visitor> getAllVisitorByDate(String  visitDateTime )
	{
		List<Visitor> list = new ArrayList<Visitor>();
		String query = "Select * from visitor where visitDateTime=?";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, visitDateTime);
			ArrayList<Visitor> arrayList = new ArrayList<Visitor>();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				long phone = resultSet.getLong(4);
				int  age = resultSet.getInt(5);
				String gender=resultSet.getString(6);
				String DOB=resultSet.getString(7);
				String visitorDateTime=resultSet.getString(8);
				

				Visitor visitor1 = new Visitor();
				visitor1.setId(1);
				visitor1.setName(name);
				visitor1.setEmail(email);
				visitor1.setPhone(phone);
				visitor1.setAge(age);
				visitor1.setGender(gender);
				visitor1.setDOB(DOB);
				visitor1.setVisitDateTime(visitDateTime);
				
				list.add(visitor1);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
//	public List<Visitor> getAllVisitorByAgeRange(int  fromage , int belowage )
//	{
//		List<Visitor> list = new ArrayList<Visitor>();
//		String query = "Select * from visitor where age Between=? and?";
//		Connection connection=ConnectionObject.getConnection();
//		
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, fromage);
//			preparedStatement.setInt(1, belowage);
//			ArrayList<Visitor> arrayList = new ArrayList<Visitor>();
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String name = resultSet.getString(2);
//				String email = resultSet.getString(3);
//				long phone = resultSet.getLong(4);
//				int  age = resultSet.getInt(5);
//				String gender=resultSet.getString(6);
//				String DOB=resultSet.getString(7);
//				String visitorDateTime=resultSet.getString(8);
//				
//
//				Visitor visitor1 = new Visitor();
//				visitor1.setId(1);
//				visitor1.setName(name);
//				visitor1.setEmail(email);
//				visitor1.setPhone(phone);
//				visitor1.setAge(age);
//				visitor1.setGender(gender);
//				visitor1.setDOB(DOB);
//				visitor1.setVisitDateTime(visitDateTime);
//				
//				list.add(visitor1);
//
//			}
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
	
	
	
	}
	

