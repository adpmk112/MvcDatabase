package ace.project.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.RequestStudentCourseDto;
import ace.project.persistance.dto.RequestStudentDto;
import ace.project.persistance.dto.RequestUserDto;
import ace.project.persistance.dto.ResponseCourseDto;
import ace.project.persistance.dto.ResponseStudentCourseDto;
import ace.project.persistance.dto.ResponseStudentDto;
import ace.project.persistance.dto.ResponseUserDto;

public class StudentCourseDao {

	static Connection con = null;

	static {
		con = MySqlSetup.getConnection();
	}

	public void createStudent_course(RequestStudentDto requestStudentDto, RequestCourseDto requestCourseDto) {
		PreparedStatement prepStmt;
		String sql = "insert into student_course (student_id, course_id) values(?,?)";
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, String.valueOf(requestStudentDto.getId()));
			prepStmt.setString(2, requestCourseDto.getId());
			int rowCount = prepStmt.executeUpdate();
			if (rowCount > 0) {
				System.out.println("Student_course creation successful");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResponseStudentCourseDto selectOneById(RequestStudentCourseDto requestStudentCourseDto) {
		ResponseStudentCourseDto resStudentCourseDto = new ResponseStudentCourseDto();
		String sql = "select s.`id` AS `student_id`, s.`name` AS `student_name`, s.`birth`, s.`gender`, "
				+ "s.`phone`, s.`education`, c.`id` AS `course_id`, c.`name` AS `course_name` from `student` "
				+ "s join `student_course` sc join `course` c on s.`id`=sc.`student_id` and c.id=sc.`course_id` "
				+ "where s.`id`=?";
		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, String.valueOf(requestStudentCourseDto.getStudentId()));
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				resStudentCourseDto.setStudentId(Integer.valueOf(resultSet.getString("student_id")));
				resStudentCourseDto.setStudentName(resultSet.getString("student_name"));
				resStudentCourseDto.setBirth(resultSet.getString("birth"));
				resStudentCourseDto.setGender(resultSet.getString("gender"));
				resStudentCourseDto.setPhone(resultSet.getString("phone"));
				resStudentCourseDto.setEducation(resultSet.getString("education"));
				resStudentCourseDto.setCourseId(Integer.valueOf(resultSet.getString("course_id")));
				resStudentCourseDto.setCourseName(resultSet.getString("course_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resStudentCourseDto;
	}

	public List<ResponseStudentCourseDto> selectAllStudentwithCourseName() {

		List<ResponseStudentCourseDto> resStudentCourseDtoList = new ArrayList<>();

		String sql = "select s.`id` AS `student_id` ,s.`name` AS `student_name`,"
				+ "s.`birth`, s.`gender`, s.`phone`, s.`education`,"
				+ "c.`id` AS `course_id`,  c.`name` AS `course_name` from "
				+ "`student` s join `student_course` sc join `course` c on"
				+ " s.`id`=sc.`student_id` and c.`id`=sc.`course_id`;";

		PreparedStatement prepStmt;
		try {
			prepStmt = con.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				ResponseStudentCourseDto resStudCourseDto = new ResponseStudentCourseDto();

				resStudCourseDto.setStudentId(Integer.valueOf(resultSet.getString("student_id")));
				resStudCourseDto.setStudentName(resultSet.getString("student_name"));
				resStudCourseDto.setBirth(resultSet.getString("birth"));
				resStudCourseDto.setGender(resultSet.getString("gender"));
				resStudCourseDto.setPhone(resultSet.getString("phone"));
				resStudCourseDto.setEducation(resultSet.getString("education"));

				resStudCourseDto.setCourseId(Integer.valueOf(resultSet.getString("course_id")));
				resStudCourseDto.setCourseName(resultSet.getString("course_name"));

				resStudentCourseDtoList.add(resStudCourseDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resStudentCourseDtoList;
	}
}
