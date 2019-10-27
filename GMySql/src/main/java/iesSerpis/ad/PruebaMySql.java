package iesSerpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PruebaMySql {
	
	public static String url="jdbc:mysql://localhost/dbprueba?serverTimezone=UTC";
	static Connection connection;
	
	public static void main(String[] args) throws SQLException {
		
		connection=DriverManager.getConnection(url, "root", "sistemas");
		insert();
		shoAll();
		connection.close();
	
	}
	
	public static void shoAll() throws SQLException {
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from categoria order by id");
		
		while (resultSet.next()) {
			System.out.printf("id=%s nombre=%s %n",resultSet.getObject("id"),resultSet.getObject("nombre"));
			
			
		}
		
		statement.close();
	}
	
	public static void insert() throws SQLException {
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into categoria (nombre) values(?)");
		preparedStatement.setObject(1,"cat 10"+LocalDateTime.now());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		
	}
	

}
