package com.uks.jdbc.Day2.ass2;
/**
 * this class is used to get and set the results from the database
 *
 * @author Kailas
 * @date 24/7/2019
 */

public class SalesByCatData {
	public Double TotalPurchase;
	public String ProductName;

	// constructor to get and set data
	public SalesByCatData(String ProductName, Double TotalPurchase) {
		this.TotalPurchase = TotalPurchase;
		this.ProductName = ProductName;
	}

}
