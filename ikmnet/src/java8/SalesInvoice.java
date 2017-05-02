package java8;

public class SalesInvoice extends Invoice {
	public static String formatId(String oldId) {
		return oldId + "_SalesInvoice";
	}
	
	public static void main(String[] argList) {
		Invoice invoice = new Invoice();
		System.out.println(invoice.formatId("1234"));
		
		SalesInvoice invoice0 = new SalesInvoice();
		System.out.println(invoice0.formatId("1234"));
		
		Invoice invoice1 = new SalesInvoice();
		System.out.println(invoice1.formatId("1234"));
		
	}
}