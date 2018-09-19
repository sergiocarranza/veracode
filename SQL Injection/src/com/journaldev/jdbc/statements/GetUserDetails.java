
package com.journaldev.jdbc.statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.DriverManager;
import java.util.Scanner;


public class GetUserDetails {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//read user entered data
		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor, ingrese email: ");
		String id = scanner.nextLine();
		System.out.println("Correo="+id);
		System.out.println("Por favor, ingrese clave: ");
		String pwd = scanner.nextLine();
		
		if (pwd.length() == 0)
			System.out.println("-- blank password --");
		printUserData(id,pwd);
		
		scanner.close();
		
	}

	private static void printUserData(String id, String pwd) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			System.out.println("\nEjecutando query...");
			
			con = DBConnection.getConnection();
			
			stmt = con.createStatement();
			String query = "select name, country, balance from users where email = '"+id+"' and password='"+pwd+"'";
			System.out.println("Executing: '"+ query + "'");
			
			rs = stmt.executeQuery(query);
			int a=0;
			while(rs.next()){
				a++;
				//System.out.println("");
				System.out.println("\nNombre="+rs.getString("name")+", País="+rs.getString("country")+", Saldo="+rs.getString("balance"));
				//System.out.println("");
			}
			if (a==0) {
				System.out.println("No hay registros!");
			}else {
				System.out.println("\nFin!");
			}
			}
			catch(SQLException e){
				System.out.println("error sql" + e);
			}
			finally{
				if(rs != null) rs.close();
				stmt.close();
				con.close();
			}
		// carse03@ca.com' or '1'='1
		// carse03@ca.com' or '1'='1;update Users set balance=400;
	}

}

