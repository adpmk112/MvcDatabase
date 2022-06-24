package ace.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.CourseDao;
import ace.project.persistance.dao.StudentCourseDao;
import ace.project.persistance.dto.RequestStudentCourseDto;
import ace.project.persistance.dto.ResponseCourseDto;
import ace.project.persistance.dto.ResponseStudentCourseDto;

/**
 * Servlet implementation class StudentFetchController
 */
@WebServlet("/StudentFetchController")
public class StudentFetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestStudentCourseDto requestStudentCourseDto = new RequestStudentCourseDto();
	StudentCourseDao studentCourseDao = new StudentCourseDao();
	CourseDao courseDao = new CourseDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestStudentCourseDto.setStudentId(Integer.valueOf(request.getParameter("fetchStudentId")));
		ResponseStudentCourseDto responseStudentCourseDto = 
				studentCourseDao.selectOneById(requestStudentCourseDto);
		
		List<ResponseCourseDto>courseList = courseDao.selectAll();
		System.out.println("CourseList -->"+courseList.size());
		request.getServletContext().setAttribute("courseList", courseList);
		request.getServletContext().setAttribute("fetchedStudent",responseStudentCourseDto );
		response.sendRedirect("http://localhost:8080/Mvc_database/studentUpdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
