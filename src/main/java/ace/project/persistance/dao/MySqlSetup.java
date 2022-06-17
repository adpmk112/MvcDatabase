package ace.project.persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlSetup {
			private Connection con;
			public void init() {
				try {
						Class.forName("com.mysql.jdbc.Driver");
				}
					catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
				String url = "jdbc:mysql://localhost:3306/project";
				String name = "root";
				String password = "zxcv1234";
				
				try {
					con = DriverManager.getConnection(url, name, password);
				}
					catch(SQLException e){
							e.printStackTrace();
					}
			}
			
			public Connection getConnection() {
				return con;
			}
}
