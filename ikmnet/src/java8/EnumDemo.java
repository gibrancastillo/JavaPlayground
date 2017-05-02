package java8;

public class EnumDemo {

	public static void main(String[] args) {
		String report = args[0];
		if(report.equals(Report.EMPRPT.getName()))
			System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
		if(report.equals(Report.EMPRPT))
			System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
		if(report.equals(Report.MNGRPT.toString()))
			System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
		if(report.equals(Report.MNGRPT.name()))
			System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
	}
}