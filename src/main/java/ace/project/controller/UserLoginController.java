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
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestUserDto requestUserDto = new RequestUserDto();
	UserDao userDao = new UserDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
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
		requestUserDto.setEmail(request.getParameter("email"));
		ResponseUserDto resUserDto = userDao.selectOneByEmail(requestUserDto);
		
		if(request.getParameter("email").equals(resUserDto.getEmail()) &&
				request.getParameter("password").equals(resUserDto.getPassword())) {
			 	request.getSession().setAttribute("userSession", resUserDto);
			 	response.sendRedirect("http://localhost:8080/Mvc_database/menu.jsp");
		}
		else{
			request.getServletContext().setAttribute("loginFail", "The account name or password that you have entered is incorrect");
			response.sendRedirect("http://localhost:8080/Mvc_database/login.jsp");
		}
	}
}
