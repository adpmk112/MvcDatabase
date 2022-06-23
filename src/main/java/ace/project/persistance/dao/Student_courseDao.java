package ace.project.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.RequestStudentDto;

public class Student_courseDao {
	
	static Connection con = null;
	
	static {
		con = MySqlSetup.getConnection();
	}
	
	public void createStudent_course(RequestStudentDto requestStudentDto,
									 RequestCourseDto requestCourseDto) {
		PreparedStatement prepStmt;
		String sql = "insert into student_course (student_id, course_id) values(?,?)";
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, String.valueOf(requestStudentDto.getId()));
			prepStmt.setString(2, requestCourseDto.getId());
			int rowCount = prepStmt.executeUpdate();
			if(rowCount>0) {
				System.out.println("Student_course creation successful");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
