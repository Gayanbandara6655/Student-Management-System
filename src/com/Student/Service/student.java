package com.Student.Service;

import java.sql.*;



public class student {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uni", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("success connected");
		}
		return con;
	}


	public String readStudents() {
		String output="";
		
		
		
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to the database for reading";
			}
			
			output = "<table id='customers'><tr><th>Student Name</th><th>Gender</th><th>Age</th>"
					+ "<th>Address</th><th>Phone No</th><th>BirthDate</th><th>Email</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select *from student";
			
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				
				String StudentID = Integer.toString(result.getInt("StudentID"));
				String StudentName = result.getString("StudentName");
			    String Sex = result.getString("Sex");
			    String Age = Integer.toString(result.getInt("Age"));
			    String Address = result.getString("Address");
			    String PhoneNo = Integer.toString(result.getInt("PhoneNo"));
			    String BirthDate = result.getString("BirthDate");
				String Email = result.getString("Email");
				
				output += "<tr><td><input id='hidStudentIDUpdate' name='hidStudentIDUpdate' type='hidden' value='" + StudentID 
					   + "'>" + StudentName + "</td>";
				output += "<td>" + Sex + "</td>";
				output += "<td>" + Age + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + PhoneNo + "</td>";
				output += "<td>" + BirthDate +"</td>";
				output += "<td>" + Email + "</td>";
				 
				output += "<td><input name='btnUpdate' type='button'  value='Update' class='btnUpdate btn btn-success'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-id='"
						+ StudentID + "'>" + "</td></tr>";
			
			}
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Students.";
			System.err.println(e.getMessage());
		}
		return output;
		}

	public String insertStudents(String StudentName,String Sex,String Age,String Address,String PhoneNo,String BirthDate,String Email) {
		
		String output = "";
		try {
			Connection con = connect();
		
		if(con == null) {
			return "Error while connecting to the DataBase";
		}
		
		String query = " insert into student(`StudentID`,`StudentName`,`Sex`,`Age`,`Address`,`PhoneNo`,`BirthDate`,`Email`)" + "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, StudentName);
		preparedStmt.setString(3, Sex);
		preparedStmt.setInt(4, Integer.parseInt(Age));
		preparedStmt.setString(5, Address);
		preparedStmt.setInt(6, Integer.parseInt(PhoneNo));
		preparedStmt.setString(7, BirthDate);
		preparedStmt.setString(8, Email);
		
		preparedStmt.execute();
		con.close();
		String newStd = readStudents();
		output = "{\"status\":\"success\", \"data\": \"" + newStd + "\"}";    
		
	
		
		}catch(SQLException e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the Students.\"}";
		}
			return output;
		}
	
	public String updateStudents(String StudentID,String StudentName,String Sex,String Age,String Address, String PhoneNo,String BirthDate,String Email) {
		
		String output="";
		
		try {
			Connection con = connect();
			
			if(con == null) {
				return "Error while connectiong to the database for updating";
				
				
			}
			String query = "UPDATE student SET StudentName=?,Sex=?,Age=?,Address=?,PhoneNo=?,BirthDate=?,Email=? Where StudentID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setString(1,StudentName);
			preparedStmt.setString(2, Sex);
			preparedStmt.setInt(3, Integer.parseInt(Age));
			preparedStmt.setString(4, Address);
			preparedStmt.setInt(5, Integer.parseInt(PhoneNo));
			preparedStmt.setString(6, BirthDate);
			preparedStmt.setString(7, Email);
			preparedStmt.setInt(8, Integer.parseInt(StudentID));
			
			preparedStmt.execute();
			
			con.close();
			String newStd = readStudents();
				output = "{\"status\":\"success\", \"data\": \"" + newStd + "\"}";
				
				
			
			}catch(SQLException e) {
				output = "{\"status\":\"error\", \"data\":\"Error while updating the Students.\"}";
			}
				return output;
			}
	
	public String deleteStudents(String StudentID) {
		
		String output="";
		try {
			Connection con =connect();
			
		
		if(con == null) {
			return "Error while connecting to the Database for deleting";
		}
		String query = "delete from student where StudentID=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
			
		preparedStmt.setInt(1, Integer.parseInt(StudentID));
		preparedStmt.execute();
		con.close();
		String newStd = readStudents();
		output = "{\"status\":\"success\", \"data\": \"" + newStd + "\"}";
		
		
		
	} catch (Exception e) {
		output = "{\"status\":\"error\", \"data\":\"Error while deleting the Students.\"}";
		System.err.println(e.getMessage());
	}
	return output;
		
	}
	
	}


