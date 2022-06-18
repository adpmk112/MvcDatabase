package ace.project.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ace.project.persistance.dto.RequestStudentDto;
import ace.project.persistance.dto.ResponseStudentDto;

public class StudentDao {
	MySqlSetup mysqlCon = new MySqlSetup();
	
	Connection con = mysqlCon.getConnection();
	
	public void createStudent(RequestStudentDto requestStudentDto) {
		String sql = "insert into `student` "
				+ "(`name`,`birth`,`gender`,`phone`,`education`) "
				+ "values (?,?,?,?,?)";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestStudentDto.getName());
			prepStmt.setString(2, requestStudentDto.getBirth());
			prepStmt.setString(3, requestStudentDto.getGender());
			prepStmt.setString(4, requestStudentDto.getPhone());
			prepStmt.setString(5, requestStudentDto.getEducation());
			int rowCount = prepStmt.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Insertion Successful");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateByStudentId(RequestStudentDto requestStudentDto) {
		String sql = "update `student` set name=?,birth=?,gender=?,"
				+ "phone=?,education=? where student_id=?";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestStudentDto.getName());
			prepStmt.setString(2, requestStudentDto.getBirth());
			prepStmt.setString(3, requestStudentDto.getGender());
			prepStmt.setString(4, requestStudentDto.getPhone());
			prepStmt.setString(5, requestStudentDto.getEducation());
			prepStmt.setString(6, requestStudentDto.getStudentId());
			int rowCount = prepStmt.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Update Successful");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByStudentId(RequestStudentDto requestStudentDto) {
		String sql = "delete from student where student_id=?";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestStudentDto.getStudentId());
			int rowCount = prepStmt.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Delete Successful");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResponseStudentDto selectOneById(ResponseStudentDto requestStudentDto) {
	    ResponseStudentDto resStudentDto = new ResponseStudentDto();
	    String sql = "select * from student where student_id=?";
	    PreparedStatement prepStmt;
	    try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestStudentDto.getStudentId());
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				resStudentDto.setName(resultSet.getString("name"));
				resStudentDto.setBirth(resultSet.getString("birth"));
				resStudentDto.setGender(resultSet.getString("gender"));
				resStudentDto.setPhone(resultSet.getString("phone"));
				resStudentDto.setEducation(resultSet.getString("education"));
				resStudentDto.setStudentId(resultSet.getString("student_id"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resStudentDto;
	}
	
	public ResponseStudentDto selectOneByName(RequestStudentDto requestStudentDto) {
	    ResponseStudentDto resStudentDto = new ResponseStudentDto();
	    String sql = "select * from student where name=?";
	    PreparedStatement prepStmt;
	    try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestStudentDto.getName());
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				resStudentDto.setName(resultSet.getString("name"));
				resStudentDto.setBirth(resultSet.getString("birth"));
				resStudentDto.setGender(resultSet.getString("gender"));
				resStudentDto.setPhone(resultSet.getString("phone"));
				resStudentDto.setEducation(resultSet.getString("education"));
				resStudentDto.setStudentId(resultSet.getString("student_id"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resStudentDto;
	}
	
	public List<ResponseStudentDto> selectAll(RequestStudentDto requestStudentDto) {
	    ResponseStudentDto resStudentDto = new ResponseStudentDto();
	    
	    List<ResponseStudentDto> resStudentDtoList = new ArrayList<>();
	    String sql = "select * from student";
	    PreparedStatement prepStmt;
	    try {
			prepStmt = con.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				resStudentDto.setName(resultSet.getString("name"));
				resStudentDto.setBirth(resultSet.getString("birth"));
				resStudentDto.setGender(resultSet.getString("gender"));
				resStudentDto.setPhone(resultSet.getString("phone"));
				resStudentDto.setEducation(resultSet.getString("education"));
				resStudentDto.setStudentId(resultSet.getString("student_id"));
				resStudentDtoList.add(resStudentDto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resStudentDtoList;
	}
}
