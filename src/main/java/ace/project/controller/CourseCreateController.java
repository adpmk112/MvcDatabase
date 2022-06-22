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

/**
 * Servlet implementation class CourseCreateController
 */
@WebServlet("/CourseCreateController")
public class CourseCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CourseDao courseDao = new CourseDao();
    RequestCourseDto requestCourseDto = new RequestCourseDto();
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getServletContext().setAttribute("courseId", "COU-");
		requestCourseDto.setName(request.getParameter("name"));
		courseDao.createCourse(requestCourseDto);
		response.sendRedirect("http://localhost:8080/Mvc_database/courseRegister.jsp");
	}

}
