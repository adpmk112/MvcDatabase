package ace.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.UserDao;
import ace.project.persistance.dto.RequestUserDto;
import ace.project.persistance.dto.ResponseUserDto;

/**
 * Servlet implementation class UserFetchController
 */
@WebServlet("/UserFetchController")
public class UserFetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserDao userDao = new UserDao();
	RequestUserDto requestUserDto = new RequestUserDto();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestUserDto.setId(request.getParameter("fetchId"));
		ResponseUserDto responseDtoUser = userDao.selectOneById(requestUserDto);
		request.getServletContext().setAttribute("fetchData",responseDtoUser);
		response.sendRedirect("http://localhost:8080/Mvc_database/userUpdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
