package ace.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.StudentCourseDao;
import ace.project.persistance.dao.StudentDao;
import ace.project.persistance.dto.RequestCourseDto;
import ace.project.persistance.dto.RequestStudentDto;

/**
 * Servlet implementation class StudentUpdateController
 */
@WebServlet("/StudentUpdateController")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao = new StudentDao();
	StudentCourseDao studentCourseDao = new StudentCourseDao();
	RequestStudentDto requestStudentDto = new RequestStudentDto();
	RequestCourseDto requestCourseDto = new RequestCourseDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
