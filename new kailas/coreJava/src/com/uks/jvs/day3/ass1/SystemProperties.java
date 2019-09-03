package com.uks.jvs.day3.ass1;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: System Properties Program
 * @author Kailas
 */
public class SystemProperties {
	String stringCommand;
	public void allMethods(String stringCommand){
		this.stringCommand = stringCommand;
		// this will exception in program when any error occurred on opening note pad
		try
        {
        	// get command as a input and call that particuler case
        	switch(stringCommand){
        	case "uname":
        		getUserName(); // this method will call getUserName() from SystemProperties class
        		break;
        	case "osname":
        		getOsName();
        		break;
        	case "udir":
        		getDirectoryName();
        		break;
        	case "all" :
        		getUserName();
        		getOsName();
        		getDirectoryName();
        		break;
        	}

        } catch (Exception exception)// this will catch that exception and display
        {
            System.out.println("Error Executing notepad."+exception);
        }

	}
	// to get the user name of system
	public void getUserName(){
		 System.out.println( System.getProperty("user.name") );
	}
	// to get the name of Operating system
		public void getOsName(){
			System.out.println(System.getProperty("os.name"));
		}
		// to get the user name of user Directory of  system
		public void getDirectoryName(){
			String currentDirectory = System.getProperty("user.dir");
		    System.out.println("user.dir: " + currentDirectory);
		}

}
