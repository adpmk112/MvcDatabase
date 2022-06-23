package ace.project.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.RequestStudentDto;
import ace.project.persistance.dto.ResponseCourseDto;
import ace.project.persistance.dto.ResponseStudentDto;

public class CourseDao {
	
	static Connection con = null;
	
	static {
		con = MySqlSetup.getConnection();
	}
	
	public void createCourse(RequestCourseDto requestCourseDto) {
		String sql = "insert into `course` (`name`) values (?)";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, requestCourseDto.getName());
			int rowCount = prepStmt.executeUpdate();
			if(rowCount>0) {
				System.out.println("Course creation successful");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<ResponseCourseDto> selectAll() {
	    
	    List<ResponseCourseDto> resCourseDtoList = new ArrayList<>();
	    String sql = "select * from course";
	    PreparedStatement prepStmt;
	    try {
			prepStmt = con.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				ResponseCourseDto resCourseDto = new ResponseCourseDto();
				resCourseDto.setId(Integer.valueOf(resultSet.getString("id")));
				resCourseDto.setName(resultSet.getString("name"));
				resCourseDtoList.add(resCourseDto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resCourseDtoList;

}
	
	public ResponseCourseDto selectLastRow() {
		ResponseCourseDto resCourseDto = new ResponseCourseDto();
		String sql = "SELECT `id` FROM `course` ORDER BY `id` DESC LIMIT 1";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				resCourseDto.setId(Integer.valueOf(resultSet.getString("id")));
				resCourseDto.setName(resultSet.getString("name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return resCourseDto;
	}
}
