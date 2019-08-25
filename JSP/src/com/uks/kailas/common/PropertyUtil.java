package com.uks.kailas.common;

import java.io.IOException;
import java.util.ResourceBundle;

public class PropertyUtil {
	private ResourceBundle objResourceBundle = null;

	/**
	 * This method is used to fetch the requierd details(keys) from the resource
	 * file
	 *
	 * @param base
	 *            - holds the path of the properties path from where value have
	 *            to be retrived
	 * @throws IOException
	 *             - thrown when there is an I/O error
	 * @throws Exception
	 *             - Thrown to handle all general exception conditions
	 */
	public PropertyUtil(String base) throws IOException, Exception {
		objResourceBundle = ResourceBundle.getBundle(base);
	}

	/**
	 * This method is used to return the requierd details(keys) from the
	 * resource file
	 *
	 * @param key
	 *            - holds the value of key who's value is needed
	 * @return String - holds the value corresponding to the key passed
	 */
	public String getProperty(String key) {
		return objResourceBundle.getString(key);
	}
}
