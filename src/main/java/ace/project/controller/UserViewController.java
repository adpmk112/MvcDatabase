package ace.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.UserDao;
import ace.project.persistance.dto.ResponseUserDto;

/**
 * Servlet implementation class UserViewController
 */
@WebServlet("/UserViewController")
public class UserViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	 List<ResponseUserDto> resUserDtoList = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resUserDtoList = userDao.selectAll();
		request.getServletContext().setAttribute("resUserDtoList", resUserDtoList);
		response.sendRedirect("http://localhost:8080/Mvc_database/userView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
