package com.uks.kailas.ass6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;
import com.uks.kailas.common.ErrorMessage;
import com.uks.kailas.common.LoginValidation;
import com.uks.kailas.common.UserDetailsBean;

/**
 * This servlet is used called by Login jsp page . It is used to check UserId
 * and Password
 *
 * @author kailas
 * Date :22/8/2019
 *
 */
@WebServlet(Constants.PATTERNASS6)
public class LoginServletTwo extends HttpServlet {
	private static final long serialVersionUID = -336330491911299317L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean ischeck = false; // it is used to check for correct username and
									// password
		LoginValidation objLaginValidation = null;
		ErrorMessage objErrorMessage = null;
		RequestDispatcher objRequestDispatcher = null;
		UserDetailsBean objUserDetailsBean = null;
		DBLogicClass objLogicClass = null;
		HttpSession session = null;
		String userName = null;
		String password = null;

		try {
			// It is to support Japanese language
			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);
			objLogicClass = new DBLogicClass();
			// for error message
			objErrorMessage = new ErrorMessage();
			// * Here Values are taken from Login.jsp Page
			userName = request.getParameter(Constants.LOGINID);
			password = request.getParameter(Constants.IDPASSWORD);

			// * To perform Validation which support Japanese Language
			objLaginValidation = new LoginValidation();
			ischeck = objLaginValidation.validateUserdetailsForm(userName,
					password);

			if (ischeck) {
				// * If Validation is Successful

				// select query is executed by this function and taken result
				// from database
				objUserDetailsBean = objLogicClass.checkUserIdPassword(
						userName, password);
				// * It checks Entered userid and password with the result from
				// database
				if (userName.equals(objUserDetailsBean.getUsername())
						&& objUserDetailsBean.getPassword().equals(password)) {
					// If UserId and Password is correct

					// * session object is created and Attribute is seated for
					// further use ::

					session = request.getSession();
					session.setAttribute(Constants.USER, userName);
					// * object of RequestDispatcher is created and It

					// redirecting to Resultone.jsp page which display user Data
					objRequestDispatcher = request
							.getRequestDispatcher(Constants.ASS6_RESULT);
					request.setAttribute(Constants.LISTDATA, objUserDetailsBean);

					objRequestDispatcher.forward(request, response);
				} else {
					// * If UserId and Password is correct Not correct: It
					// redirects to Login.jsp page with error message

					objRequestDispatcher = request
							.getRequestDispatcher(Constants.ASS6_LOGIN);

					request.setAttribute(Constants.RESULT,
							Constants.INVUSERPASS);
					objRequestDispatcher.forward(request, response);
				}
			} else {
				// * If Validation is Not Successful : It redirects to Login.jsp
				// page with error message
				objRequestDispatcher = request
						.getRequestDispatcher(Constants.ASS6_LOGIN);
				request.setAttribute(Constants.RESULT,
						objErrorMessage.getError());
				objRequestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			objRequestDispatcher = request
					.getRequestDispatcher(Constants.ERRORPAGE);
			objRequestDispatcher.forward(request, response);
		} finally {
			objUserDetailsBean = null;
			objLaginValidation = null;
			objErrorMessage = null;
			objRequestDispatcher = null;
			objLogicClass = null;
			userName = null;
		}
	}
}
