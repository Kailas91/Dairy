package com.uks.jvs.day3.ass8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Class Details program
 *
 * @author Kailas
 */
public class ClassDetail {

	/**
	 * method printAll prints class details such as constructors,methods,fields
	 */
	public void showAllClassDetails(String nameOfclass) {
		@SuppressWarnings("rawtypes")
		Class className = null;
		try {
			className = Class.forName(nameOfclass.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nName Of Class " + className.getName() + "\n");
		// The getSuperclass() method returns the Class representing the
		// superclass of the entity represented by this Class.
		@SuppressWarnings("rawtypes")
		Class supercl = className.getSuperclass();
		String modifiers = Modifier.toString(className.getModifiers());
		if (modifiers.length() > 0)
			System.out.print(modifiers + " ");
		System.out.print("class " + className.getName());
		if (supercl != null && supercl != Object.class)
			System.out.print(" extends " + supercl.getName());
		System.out.print("\n{\n");
		showAllConstructors(nameOfclass);
		System.out.println();
		showOnlyMethods(nameOfclass);
		System.out.println();
		showOnlyFields(nameOfclass);
		System.out.println("}");
	}

	/**
	 * method printConstructors prints constructors of classes return type :void
	 */
	public void showAllConstructors(String nameOfclass) {

		// get first argument as a class name for passing to methods
		@SuppressWarnings("rawtypes")
		Class cl = null;
		try {
			cl = Class.forName(nameOfclass.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nConstructors Of Class " + cl.getName() + "\n");
		@SuppressWarnings("rawtypes")
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (@SuppressWarnings("rawtypes") Constructor c : constructors) {
			String name = c.getName();
			System.out.print("   ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(name + "(");
			// print parameter types in constructor
			@SuppressWarnings("rawtypes")
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * method printMethods prints methods of classes return type : void
	 */
	public void showOnlyMethods(String nameOfclass) {
		@SuppressWarnings("rawtypes")
		Class className = null;
		try {
			className = Class.forName(nameOfclass.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nMethods Of Class " + className.getName() + "\n");
		Method[] methods = className.getDeclaredMethods();
		for (Method m : methods) {
			@SuppressWarnings("rawtypes")
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("   ");
			// print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			// print parameter types of that method
			@SuppressWarnings("rawtypes")
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * method printFields prints fields of classes return type : void
	 */
	public void showOnlyFields(String nameOfclass) {
		@SuppressWarnings("rawtypes")
		Class className = null;
		try {
			className = Class.forName(nameOfclass.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nFields Of Class " + className.getName() + "\n");
		Field[] fields = className.getDeclaredFields();
		for (Field f : fields) {
			@SuppressWarnings("rawtypes")
			Class type = f.getType();
			String name = f.getName();
			System.out.print("   ");
			// to get all modifiers
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
