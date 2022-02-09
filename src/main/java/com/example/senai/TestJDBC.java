//package com.example.senai;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TestJDBC {
//	public static void main(String[] args) throws SQLException {
//		Connection connection = DriverManager.getConnection(
//				"jdbc:postgresql://localhost:5432/viladev",
//				"eduardotelmann",
//				"");
//		
//		Statement stmt = connection.createStatement();
//		stmt.execute("SELECT * FROM resident");
//		ResultSet rs = stmt.getResultSet();
//		while(rs.next()) {
//			String string = rs.getString("name");
//			System.out.println("NOME: "+string);
//		}
//		stmt.close();
//		connection.close();
//		System.out.println("FOI");
//	}
//}
