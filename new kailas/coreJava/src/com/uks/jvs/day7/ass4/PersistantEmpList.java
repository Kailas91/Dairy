package com.uks.jvs.day7.ass4;

/**
 * Date:27/06/2019
 * Assignment: Day 7
 * Task: Generic classes in Java
 *
 * @author Kailas
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

public class PersistantEmpList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			Hashtable<Integer, EmployeeDetail> empTable = new Hashtable<>();
			int empCount = 1;
			String option;
			do {

				System.out.println("Enter employee name ,age and salary ");
				String empName = scanner.next();
				Integer empAge = scanner.nextInt();
				Double basicSalary = scanner.nextDouble();

				empTable.put(empCount++, new EmployeeDetail(empName, empAge, basicSalary));
				System.out.println("Want to add another employee (Y|N) ?");
				option = scanner.next();
			} while (option.equals("Y")||option.equals("y"));
			scanner.close();

			//calling serialize method Serializing the data
			System.out.println("Serializing the employee table");
			serialize(empTable, "C:\\Users\\Kailas\\Desktop\\serirailzeTable.ser");
			empTable.clear();

			System.out.println("Employee Table size : " + empTable.size());
			// deSerializing the data
			System.out.println("Deserializing the data");
			empTable = deSerialize("C:\\Users\\Kailas\\Desktop\\serirailzeTable.ser");

			for (EmployeeDetail e : empTable.values()) {
				System.out.println("Employee Name \t:" + e.name);
				System.out.println("Employee Age \t:" + e.age);
				System.out.println("Salary \t:" + e.salary);
			}

		} catch (Exception e) {
			System.out.println("Enter valid option");
		}
	}

	/*
	 * method serialize is used to serialize the data
	 *
	 * @String filename contains file name to be used for serialization return
	 * type : void
	 */

	static void serialize(Hashtable<Integer, EmployeeDetail> empTable, String filename) throws IOException {
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);
		// Method for serialization of object
		out.writeObject(empTable);
		out.close();
		file.close();
		System.out.println("serialization is successful");
	}

	/**
	 *
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	static Hashtable<Integer, EmployeeDetail> deSerialize(String filename) throws IOException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Hashtable<Integer, EmployeeDetail> empTable = null;
		try {
			empTable = (Hashtable<Integer, EmployeeDetail>) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee Table has been deserialized");
		in.close();
		return empTable;
	}
}