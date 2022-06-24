package ace.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.StudentCourseDao;
import ace.project.persistance.dao.StudentDao;
import ace.project.persistance.dto.ResponseStudentCourseDto;

/**
 * Servlet implementation class StudentViewController
 */
@WebServlet("/StudentViewController")
public class StudentViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentCourseDao studentCourseDao = new StudentCourseDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ResponseStudentCourseDto>resStudCourseDtoList = 
				studentCourseDao.selectAllStudentwithCourseName();
		
		request.getServletContext().setAttribute("studWithCourse", resStudCourseDtoList);
		response.sendRedirect("http://localhost:8080/Mvc_database/studentView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
