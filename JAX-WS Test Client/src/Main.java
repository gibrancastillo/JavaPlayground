import employeemanagement.services.Employee;
import employeemanagement.services.EmployeeServiceImpl;
import employeemanagement.services.EmployeeServiceImplService;

public class Main {

	public static void main(String[] args) {
		// call the webservice
		// WSDL URL (endpoint):  http://localhost:8080/anyurl/employeeservice?wsdl
		// wsimport -keep -verbose -s ./src/ -d ./bin/ <WSDL URL>
		EmployeeServiceImpl webservice = new EmployeeServiceImplService().getEmployeeServiceImplPort();
		Employee employee = webservice.getEmployeeById("1");
		
		System.out.println(employee.getName());
	}
}