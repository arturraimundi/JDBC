package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		System.out.println("conectou");
		DB.closeConnection();
		System.out.println("desconectou");

	}

}
