package com.awadhesh22791.springmvclearningcrm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTest {
	
	
	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/customer_tracker?useSSL=false";
		String username="root";
		String password="root";
		try {
			log.info("Connecting to mysql.");
			Connection connection=DriverManager.getConnection(jdbcUrl, username, password);
			log.info("Connection success...");
		} catch (Exception e) {
			log.error("Error connecting db.",e);
		}
	}
}
