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
import com.uks.kailas.common.UserDetailsBean;

/**
 * It is called by Resultone.jsp when we click on Edit Button It Takes data from
 * database and redirects to userdetails.jsp
 *
 * @author kailas
 * Date :22/8/2019
 *
 */
@WebServlet(Constants.PATTERNASS62)
public class EditUserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = -2925396876072718448L;

	/**
	 * It is called by Resultone.jsp when we click on Edit Button It Takes data
	 * from database and redirects to userdetails.jsp
	 *
	 * @exception ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBLogicClass objLogicClass = new DBLogicClass();
		UserDetailsBean objUserDetailsBean = null;
		RequestDispatcher objRequestDispatcher = null;
		UserDetailsBean objUserDetailsBinSecond = null;
		String userID = null;

		try {
			// It is to support Japanese language
			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);
			// Bean object is created
			objUserDetailsBean = new UserDetailsBean();
			// * This is used to get session attribute for further login
			HttpSession session = request.getSession(false);
			if (session != null) {
				// this "UserId" is used for further login
				userID = (String) session.getAttribute(Constants.USER);
			}
			// userId is seted in object of bin to execute query
			objUserDetailsBean.setUsername(userID);
			objUserDetailsBinSecond = objLogicClass
					.selectValues(objUserDetailsBean);

			String[] date = objUserDetailsBinSecond.getBirthdate().split("-");
			objUserDetailsBinSecond.setYear(date[0]);
			objUserDetailsBinSecond.setMonth(date[1]);
			objUserDetailsBinSecond.setDay(date[2].substring(0, 2));

			String[] interest = objUserDetailsBinSecond.getInterstTwo().split(
					Constants.COMMA);

			objUserDetailsBinSecond.setInterest(interest);
			// * To proper display of checkbox following logic used
			if (objUserDetailsBinSecond.getInterstTwo().contains(Constants.WEB)) {
				objUserDetailsBinSecond.setWeb(Constants.WEB);
			}
			if (objUserDetailsBinSecond.getInterstTwo().contains(
					Constants.DATABASE)) {
				objUserDetailsBinSecond.setDatabase(Constants.DATABASE);
			}
			if (objUserDetailsBinSecond.getInterstTwo().contains(
					Constants.SWING)) {
				objUserDetailsBinSecond.setSwing(Constants.SWING);
			}
			if (objUserDetailsBinSecond.getInterstTwo().contains(
					Constants.MOBILE)) {
				objUserDetailsBinSecond.setMobile(Constants.MOBILE);
			}
			// * It redirects to Userdetails.jsp page with object of bean
			// contain data
			objRequestDispatcher = request
					.getRequestDispatcher(Constants.DISPATCHER_ASS6);
			request.setAttribute(Constants.OBJ_USERDETAILSBIN_SECOND,
					objUserDetailsBinSecond);
			objRequestDispatcher.forward(request, response);
		} catch (Exception e) {
			objRequestDispatcher = request
					.getRequestDispatcher(Constants.ERRORPAGE);
			objRequestDispatcher.forward(request, response);
		} finally {
			objUserDetailsBinSecond = null;
			objUserDetailsBean = null;
			objRequestDispatcher = null;
			objLogicClass = null;
		}
	}
}
