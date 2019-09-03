/**
 *
 */
package com.uks.jdbc.sam;



public class UpdateIntoResultSetMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Cretaing object of UpdateIntoResultSet and calling methods for operation
		UpdateIntoResultSet objUpdateIntoResultSet = new UpdateIntoResultSet();
		objUpdateIntoResultSet.connect();
		objUpdateIntoResultSet.updateInto();
		objUpdateIntoResultSet.disconnect();
	}

}
