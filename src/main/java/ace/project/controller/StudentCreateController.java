package ace.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.CourseDao;
import ace.project.persistance.dao.StudentDao;
import ace.project.persistance.dao.StudentCourseDao;
import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.RequestStudentDto;
import ace.project.persistance.dto.ResponseCourseDto;
import ace.project.persistance.dto.ResponseStudentDto;

/**
 * Servlet implementation class StudentCreateController
 */
@WebServlet("/StudentCreateController")
public class StudentCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao = new StudentDao();
	CourseDao courseDao = new CourseDao();
	RequestCourseDto requestCourseDto = new RequestCourseDto();
	RequestStudentDto requestStudentDto = new RequestStudentDto();
	StudentCourseDao student_courseDao = new StudentCourseDao();
	String[]attend;
	int studId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ResponseCourseDto>courseList = courseDao.selectAll();
		System.out.println("CourseList -->"+courseList.size());
		request.getServletContext().setAttribute("courseList", courseList);
		response.sendRedirect("http://localhost:8080/Mvc_database/studentRegister.jsp");
		ResponseStudentDto resStudentDto = studentDao.selectLastRow();
		studId = resStudentDto.getId()+1;
		request.getServletContext().setAttribute("studId", "STU-"+studId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResponseStudentDto resStudentDto = studentDao.selectLastRow();
		studId = resStudentDto.getId()+1;
		requestStudentDto.setId(studId);
		requestStudentDto.setName(request.getParameter("name"));
		requestStudentDto.setBirth(request.getParameter("birth"));
		requestStudentDto.setGender(request.getParameter("gender"));
		requestStudentDto.setPhone(request.getParameter("phone"));
		requestStudentDto.setEducation(request.getParameter("education"));
		studentDao.createStudent(requestStudentDto);
		String[]attend = request.getParameterValues("course");
		for(int i=0;i<attend.length;i++) {
			requestCourseDto.setId(attend[i]);
			student_courseDao.createStudent_course(requestStudentDto, requestCourseDto);
		}
		response.sendRedirect("http://localhost:8080/Mvc_database/StudentViewController");
	}

}
