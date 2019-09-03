package com.uks.kailas.common;

public class LoginValidation {

	/**
	 * This method is used to check whether user has enetered his details or no
	 * if not then the error message is set
	 *
	 * @param userNAme
	 *            - holds the value of entered userName
	 * @param password
	 *            - holds the value of entered password
	 * @throws Exception
	 *             - thrown when there is any exception condition
	 * @return boolean - used to return the validation result
	 */
	public boolean validateUserdetailsForm(String userNAme, String password)
			throws Exception {
		// Declare & initialize the ErrorMessage class tp set the error message
		ErrorMessage objErrorMessage = null;
		try {
			objErrorMessage = new ErrorMessage();
			// check whether the entered name is null or blank character
			if (userNAme == null || Constants.BLANKCHARACTER.equals(userNAme)) {
				// if blank then set the error message
				objErrorMessage.setError(Constants.ENTERUSERNAME);
				return false;
			}
			// check whether the entered password is null or blank character
			if (password == null || Constants.BLANKCHARACTER.equals(password)) {
				objErrorMessage.setError(Constants.ENTERPASSWORD);
				return false;
			}
		} finally {
			objErrorMessage = null;
		}
		return true;
	}
}
