package ace.project.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.persistance.dao.UserDao;
import ace.project.persistance.dto.RequestUserDto;

/**
 * Servlet implementation class UserCreateController
 */
@WebServlet("/UserCreateController")
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
	RequestUserDto requestUserDto= new RequestUserDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateController() {
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
		String confirmPassword;
		requestUserDto.setEmail(request.getParameter("email"));
		requestUserDto.setPassword(request.getParameter("password"));
		confirmPassword = request.getParameter("confirmPassword");
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(requestUserDto.getEmail());
		
		if(matcher.matches() & requestUserDto.getPassword().equals(confirmPassword)) {
			userDao.createUser(requestUserDto);
			response.sendRedirect("UserViewController");
		}
		else {
			request.getServletContext().setAttribute("createFail", "Something is wrong in email and password.");
			response.sendRedirect("http://localhost:8080/Mvc_database/userRegister.jsp");
		}
	}
}
