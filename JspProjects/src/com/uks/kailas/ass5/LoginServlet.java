package com.uks.kailas.ass5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;
import com.uks.kailas.common.UserDetailsBean;;
/**
 * validate user login details and show user data
 *
 * @author kailas
 * Date :22/8/2019
 *
 */
@WebServlet(Constants.PATTERNASS5)
public class LoginServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		RequestDispatcher objRequestDispatcher = null;
		UserDetailsBean objUserDetailsBean = null;
		DBLogicClass objLogicClass = null;
		String userName = null;
		String password = null;


		try {

			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);

			objLogicClass = new DBLogicClass();
			// load the data onto bin class
			userName = request.getParameter(Constants.LOGINID);
			password = request.getParameter(Constants.IDPASSWORD);

			objUserDetailsBean = objLogicClass.checkUserIdPassword(userName,
					password);
			// It checks Entered userid and password with the result from
			// database
			if (userName == null || Constants.BLANKCHARACTER.equals(userName)) {
				objRequestDispatcher = request
						.getRequestDispatcher(Constants.DISPATCHER_ASS4);
				request.setAttribute(Constants.RESULT, Constants.ENTERUSERNAME);
			} else if (password == null
					|| Constants.BLANKCHARACTER.equals(password)) {

				objRequestDispatcher = request
						.getRequestDispatcher(Constants.DISPATCHER_ASS4);
				request.setAttribute(Constants.RESULT, Constants.ENTERPASSWORD);
			} else if (userName.equals(objUserDetailsBean.getUsername())
					&& objUserDetailsBean.getPassword().equals(password)) {
				request.setCharacterEncoding(Constants.UTF);
				response.setCharacterEncoding(Constants.UTF);
				objRequestDispatcher = request
						.getRequestDispatcher(Constants.DISPATCHER_ASS4_RES);
				request.setAttribute(Constants.LISTDATA, objUserDetailsBean);
				objRequestDispatcher.forward(request, response);
			} else {

				objRequestDispatcher = request
						.getRequestDispatcher(Constants.DISPATCHER_ASS4);
				request.setAttribute(Constants.RESULT, Constants.INVUSERPASS);
				objRequestDispatcher.forward(request, response);

			}

		} catch (Exception e) {

			objRequestDispatcher = request
					.getRequestDispatcher(Constants.ERRORPAGE);
			objRequestDispatcher.forward(request, response);
			   out.println(e);

		} finally {
			objUserDetailsBean = null;
			objRequestDispatcher = null;
			objLogicClass = null;
			userName = null;
			password = null;

		}
	}

}
