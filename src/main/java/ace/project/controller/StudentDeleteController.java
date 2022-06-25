package ace.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.StudentDao;
import ace.project.persistance.dto.RequestStudentDto;

/**
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/StudentDeleteController")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao = new StudentDao();
	RequestStudentDto requestStudentDto = new RequestStudentDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestStudentDto.setId(Integer.valueOf(request.getParameter("deleteId")));
		studentDao.deleteByStudentId(requestStudentDto);
		response.sendRedirect("http://localhost:8080/Mvc_database/StudentViewController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
