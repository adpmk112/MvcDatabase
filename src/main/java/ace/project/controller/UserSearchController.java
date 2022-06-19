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
 * Servlet implementation class UserSearchController
 */
@WebServlet("/UserSearchController")
public class UserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	RequestUserDto requestUserDto = new RequestUserDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResponseUserDto responseUserDto = null;
		if(request.getParameter("userId")!="") {
			requestUserDto.setId(request.getParameter("userId"));
			responseUserDto = userDao.selectOneById(requestUserDto);
			request.getServletContext().setAttribute("searchedUserDto", responseUserDto);
			response.sendRedirect("http://localhost:8080/Mvc_database/userSearched.jsp");
			}
		
		else if(request.getParameter(("email"))!=""){
			requestUserDto.setEmail(request.getParameter("email"));
			responseUserDto = userDao.selectOneByEmail(requestUserDto);
			request.getServletContext().setAttribute("searchedUserDto", responseUserDto);
			response.sendRedirect("http://localhost:8080/Mvc_database/userSearched.jsp");
			}
		
		else {
			request.getServletContext().setAttribute("searchNull", "Fill the blank to search");
			response.sendRedirect("http://localhost:8080/Mvc_database/userView.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
