package com.uks.kailas.ass6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;
import com.uks.kailas.common.UserDetailsBean;

/**
 * It is called by userdetails.jsp This servlet is used to update database. New
 * entered values are saved in database and message is displayed on
 * screen"successfully Updated"
 *
 * @author kailas
 * Date :22/8/2019
 *
 */
@WebServlet(Constants.PATTERNASS63)
public class UpdateUserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 8457037754439422291L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetailsBean objUserDetailsBean = null;
		UserDetailsBean objUserDetailsBean2 = null;
		RequestDispatcher objRequestDispatcher = null;
		DBLogicClass objLogicClass = null;
		String userID = null;
		String username;
		String password;
		HttpSession session = null;
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		try {
			// It is to support Japanese language
			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);
			objLogicClass = new DBLogicClass();
			// Bin object is created
			objUserDetailsBean = new UserDetailsBean();
			 objUserDetailsBean2 =new UserDetailsBean();

			// Here Values are taken from Userdetails.jsp Page and Seated in
			// userDetailsBin Object
			objUserDetailsBean.setUsername(request
					.getParameter(Constants.USERNAME));
			objUserDetailsBean.setPassword(request
					.getParameter(Constants.PASSWARD));

			username=request.getParameter(Constants.USERNAME);
			password=request.getParameter(Constants.PASSWARD);

			objUserDetailsBean.setSalutation(request
					.getParameter(Constants.SALUTATION));
			objUserDetailsBean.setFirstname(request
					.getParameter(Constants.FIRSTNAME));
			objUserDetailsBean.setMiddlename(request
					.getParameter(Constants.MIDDLENAME));
			objUserDetailsBean.setLastname(request
					.getParameter(Constants.LASTNAME));
			objUserDetailsBean.setSex(request.getParameter(Constants.SEX));
			objUserDetailsBean.setEmailId(request
					.getParameter(Constants.EMAILID));
			objUserDetailsBean.setDay(request.getParameter(Constants.DATE));
			objUserDetailsBean.setMonth(request.getParameter(Constants.MONTH));
			objUserDetailsBean.setYear(request.getParameter(Constants.YEAR));
			objUserDetailsBean.setAddress(request
					.getParameter(Constants.ADDRESS));
			objUserDetailsBean.setInterest(request
					.getParameterValues(Constants.INTERESTS));
			objUserDetailsBean.setOtherinterest(request
					.getParameter(Constants.OTHERINTEREST));
			// Update query is executed by this function
			session = request.getSession(false);
			if (session != null) {
				// this "UserId" is used as a key to update the data
				userID = (String) session.getAttribute(Constants.USER);
			}

			objLogicClass.update(objUserDetailsBean, userID);

			session = request.getSession();
			session.setAttribute(Constants.USER, username);


			// It display successful message on screen


			objUserDetailsBean2 = objLogicClass.checkUserIdPassword(
					username, password);
			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);
			// redirecting to Resultone.jsp page which display user Data
			objRequestDispatcher = request
					.getRequestDispatcher(Constants.ASS6_RESULT);
			request.setAttribute(Constants.LISTDATA, objUserDetailsBean2);
			request.setAttribute(Constants.RESULT,
					Constants.DATAUPDATESUCCESS );
			objRequestDispatcher.forward(request, response);


		} catch (Exception e) {
			objRequestDispatcher = request
					.getRequestDispatcher(Constants.ERRORPAGE);
			objRequestDispatcher.forward(request, response);
			System.out.print(e);

		} finally {
			objUserDetailsBean = null;
			objRequestDispatcher = null;
			objLogicClass = null;
			userID = null;
		}
	}
}
