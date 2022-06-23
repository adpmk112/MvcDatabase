package ace.project.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.CourseDao;
import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.ResponseCourseDto;

/**
 * Servlet implementation class CourseCreateController
 */
@WebServlet("/CourseCreateController")
public class CourseCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CourseDao courseDao = new CourseDao();
    RequestCourseDto requestCourseDto = new RequestCourseDto();
    int courseId = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResponseCourseDto resCourseDto = courseDao.selectLastRow();
		System.out.println("Fetching course_id");
		courseId = resCourseDto.getId()+1;
		request.getServletContext().setAttribute("courseId", "COU-"+courseId);
		response.sendRedirect("http://localhost:8080/Mvc_database/courseRegister.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResponseCourseDto resCourseDto = courseDao.selectLastRow();
		courseId = resCourseDto.getId()+2;
		request.getServletContext().setAttribute("courseId", "COU-"+courseId);
		requestCourseDto.setName(request.getParameter("name"));
		courseDao.createCourse(requestCourseDto);
		response.sendRedirect("http://localhost:8080/Mvc_database/courseRegister.jsp");
	}

}
