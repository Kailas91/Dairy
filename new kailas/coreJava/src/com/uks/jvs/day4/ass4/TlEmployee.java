package com.uks.jvs.day4.ass4;


public class TlEmployee extends PLEmployee {


	public TlEmployee(String firstName, String lastName, String empType, String basicSalary) {
		super(firstName, lastName, empType, basicSalary);
		// TODO Auto-generated constructor stub
	}
	public void reportToSenior() {
		System.out.println("ReportToSenior method called from interface implemented in PLEmployee class ");
	}

}
