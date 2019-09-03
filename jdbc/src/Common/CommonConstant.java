package Common;

// day1 assignments
public class CommonConstant {
	public static final String QUERY = "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees";
	public static final String QUERYASS3= "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees";
	public static final String QUERY_ASS2 = "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,"
			+ "Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees WHERE EmployeeId=";
	public static final String DaythreeQueryOne = "select EmployeeID, LastName, FirstName, Title, BirthDate from Employees";

	public static final String QUERYDAY2="SELECT EmployeeID, concat(FirstName,' ', LastName) as "
			+ "EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees  ";

	// Address,HomePhone FROMemployees";
	public static final String QUERY2 = "Select FirstName from employees";
	public static final String USERID = "kailas";
	public static final String PASSWORD = "kailas@523";
	public static final String DB_URL = "jdbc:mysql://172.16.1.15:3306/northwind_kailas?autoReconnect=true&useSSL=false";

	public static final String DB_URL_TYPE1 = "jdbc:odbc:data1";

	public static final String ClassNotFoundException = "ClassNotFoundException";
	public static final String SQLException = "SQLException";
	public static final String Exception = "OPPPS !!!!!\n\t There is some error pls contact admin";

	public static final String CLASSNAME = "com.mysql.jdbc.Driver";
	public static final String TYPE1_CLASSNAME = "sun.jdbc.odbc.JdbcOdbcDriver";

	// jdbc:odbc:data1
	// day3 assignments
	public static final String DaythreeQuerytwo = "SELECT * FROM northwind_kailas.Suppliers";


	// headers
	public static final String HEADERFIRST ="%5s %15s %30s %40s %45s \n, EmployeeID, EmployeeName, Title, FullAddress,HomePhone";
	public static final String HEADERFORMAT="%-20s %-30s %-30s %-50s %-25s \n";

	public static final String HEADERFORMATSTARTING="%5s %15s %30s %40s %35s \n";

	public static final String SUPPLIERS="%5s %25s %35s %30s %40s %20s \n";

	public static final String SUPPLIERSHEADERFORMAT="%-20s %-30s %-30s %-40s %-30s %-25s \n";

	public static final String HEADERF="%5s %30s \n";
	public static final String HEADERFO="%-20s %15s \n";

	public static final String HEADERASS1="%-20s %-20s %-20s %-20s %-40s\n";
	public static final String HEADERASS1O="%-20s %-20s %-20s %-20s %20s\n";
	public static final String INVALIDCHOICE="Invalid choise here";

	public static final String NEXT="Enter N : for Next page";
	public static final String EXIT="Enter X : for exit";
	public static final String CLOSE="Enter C : for closing Connection";
	public static final String BACKMENU="Press B to go back ";
	public static final String CHOICE="Enter your choice : ";
	public static final String BACK="Enter P : for Previous page";
	public static final String NOFOUND=" No Record Found";
	public static final String ZERO=" Zero page number not present ";
	public static final String PAGENO="\nEnetr 1 : for entering page number to see result  \nEnetr 2 : display all data using  next and previous command ";
	public static final String ENETRPAGE="Eneter page number";
	public static final String TOTALPAGE="Total Page : ";
	public static final String QUERYASS2="{call northwind_kailas.SalesByCategory(?,?)}";


	// ass3
	public static final String SELECTCATE="Select any one Catagary Name and Year ";
	public static final String SEAFOOD="1. Catagary name=Seafood,Year=1996 ";
	public static final String PRODUCE="2. Catagary name=Produce,Year=1996";
	public static final String PATH="D:\\jvs_ws\\jdbc\\src\\com\\uks\\jdbc\\Day3\\ass1\\xmlfile.xml";
	public static final String WRITETOFILE="Writing database table data to xml file: ";

	public static final String ROWSETTYPE="\nPlease Enter The Type of RowSet you want:\n";
	public static final String CACHE=" 1 -> CachedRowSet";
	public static final String WEBROW=" 2 -> WebRowSet";
	public static final String ROW_INSERT="Row inserted ......";

	public static final String COMPANY_NAME="CompanyName";
	public static final String CONTACTNAME="ContactName";
	public static final String CONTACTTITLE="ContactTitle";
	public static final String ADDRESS="Address";
	public static final String CITY="City";

	public static final String INSERT="\nEnter Data To Insert\n";
	public static final String BEFORE="Before Inserting Total Table Data";
	public static final String AFTER="After Inserting Total Table Data";

	public static final String IP_COMPANY_NAME="Enter Company Name :";
	public static final String IP_CONTACT_NAME="Enter Contact Name :";
	public static final String IP_CONTACT_TITLE="Enter Contact Title :";
	public static final String IP_ADDRESS="Enter Address :";
	public static final String IP_CITY="Enter City :";

	// day 4 ass1
	public static final String ROW_UPDATE="\nRow Updated......\n";
	public static final String QUERYFORID="select * from suppliers where supplierid=";
	public static final String GETID="\nEnter id which you want to update records  :\n";
	public static final String UPDATE="\nEnter Data To Update \n";
	public static final String BEFORE_Update="Before Updating Total Table Data";
	public static final String AFTER_Update="Before Updating Total Table Data";

	// day 4 ass2
	  public static final String  DaythreeQueryfour= "select * from employees";
		public static final String DRIVERNAME = "Driver Name :";
		public static final String DRIVERVERSION ="Driver Version: ";
		public static final String USERNAME = "UserName: " ;
		public static final String DATABASENAME = "Database Product Name: ";
		public static final String DATABASEVERSION ="Database Product Version: ";
	  public static final String COL_NAME="Column Name :";
	  public static final String TABLE_NAME="Table Name :";
	  public static final String DATA_TYPE="Data Type :";
	  public static final String CASE="Is Case Sensitive :";
	  public static final String WRITABLE="Writable  :";












}
