package ace.project.persistance.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ace.project.persistance.dto.RequestUserDto;
import ace.project.persistance.dto.ResponseUserDto;

public class UserDao {
		MySqlSetup mysqlCon = new MySqlSetup();
		
		Connection con = mysqlCon.getConnection();
		
		public void createUser(RequestUserDto requestUserDto) {
			String sql = "insert into `user` "
					+ "(`email`,`password`,`userId`) values (?,?,?)";
			PreparedStatement prepStmt;
			try {
				prepStmt = con.prepareStatement(sql);
				prepStmt.setString(1, requestUserDto.getEmail());
				prepStmt.setString(2, requestUserDto.getPassword());
				prepStmt.setString(3, requestUserDto.getUserId());
				int rowCount = prepStmt.executeUpdate();
				
				if(rowCount>0) {
					System.out.println("Insertion Successful");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		public void updateByUserId(RequestUserDto requestUserDto) {
			String sql = "update `user` "
					+ "set email=?,password=? where user_id=?";
			PreparedStatement prepStmt;
			try {
				prepStmt = con.prepareStatement(sql);
				prepStmt.setString(1,requestUserDto.getEmail() );
				prepStmt.setString(2,requestUserDto.getPassword());
				prepStmt.setString(3, requestUserDto.getUserId());
				int rowCount = prepStmt.executeUpdate();
				
				if(rowCount>0) {
					System.out.println("Update Successful");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteByUserId(RequestUserDto requestUserDto) {
			String sql = "delete from user where user_id=?";
			PreparedStatement prepStmt;
			try {
				prepStmt = con.prepareStatement(sql);
				prepStmt.setString(1, requestUserDto.getUserId());
				int rowCount = prepStmt.executeUpdate();
				
				if(rowCount>0) {
					System.out.println("Delete Successful");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		public ResponseUserDto selectOneById(RequestUserDto requestUserDto) {
		    ResponseUserDto resUserDto = new ResponseUserDto();
		    String sql = "select * from user where user_id=?";
		    PreparedStatement prepStmt;
		    try {
				prepStmt = con.prepareStatement(sql);
				prepStmt.setString(1, requestUserDto.getUserId());
				ResultSet resultSet = prepStmt.executeQuery();
				while(resultSet.next()) {
					resUserDto.setEmail(resultSet.getString("email"));
					resUserDto.setPassword(resultSet.getString("password"));
					resUserDto.setUserId(resultSet.getString("user_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return resUserDto;
		}
		
		public ResponseUserDto selectOneByEmail(RequestUserDto requestUserDto) {
		    ResponseUserDto resUserDto = new ResponseUserDto();
		    String sql = "select * from user where email=?";
		    PreparedStatement prepStmt;
		    try {
				prepStmt = con.prepareStatement(sql);
				prepStmt.setString(1, requestUserDto.getEmail());
				ResultSet resultSet = prepStmt.executeQuery();
				while(resultSet.next()) {
					resUserDto.setEmail(resultSet.getString("email"));
					resUserDto.setPassword(resultSet.getString("password"));
					resUserDto.setUserId(resultSet.getString("user_id"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return resUserDto;
		}
		
		public List<ResponseUserDto> selectAll(RequestUserDto requestUserDto) {
		    ResponseUserDto resUserDto = new ResponseUserDto();
		    
		    List<ResponseUserDto> resUserDtoList = new ArrayList<>();
		    String sql = "select * from user";
		    PreparedStatement prepStmt;
		    try {
				prepStmt = con.prepareStatement(sql);
				ResultSet resultSet = prepStmt.executeQuery();
				while(resultSet.next()) {
					resUserDto.setEmail(resultSet.getString("email"));
					resUserDto.setPassword(resultSet.getString("password"));
					resUserDto.setUserId(resultSet.getString("user_id"));
					resUserDtoList.add(resUserDto);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return resUserDtoList;
		}
}
