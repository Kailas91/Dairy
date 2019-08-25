package com.uks.kailas.common;

public class ErrorMessage {
	static String error = null;


	public String getError() {
		return error;
	}

	/**
	 * This method is used to set the error messages
	 *
	 * @param String
	 *            error - holds the error message that needs to be displayed
	 *
	 * @return void
	 */
	public void setError(String error) {
		ErrorMessage.error = error;
	}

}
