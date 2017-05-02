package java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class SystemOutDemo {
	
	public void writeFile() {
		Path inputFile = Paths.get("input.txt");
		Path outputFile = Paths.get("output.txt");
		
		try {
			BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
			BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
			String lineFromFile = "";
			while((lineFromFile = reader.readLine()) != null)
				writer.append(lineFromFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile0() throws IOException {
		Path inputFile = Paths.get("input.txt");
		Path outputFile = Paths.get("output.txt");
		
		BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
		BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
		String lineFromFile = "";
		
		try {
			while((lineFromFile = reader.readLine()) != null)
				writer.append(lineFromFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
	}
	
	public void writeFile1() throws IOException {
		Path inputFile = Paths.get("input.txt");
		Path outputFile = Paths.get("output.txt");
		
		
			BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
			BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
			String lineFromFile = "";
			while((lineFromFile = reader.readLine()) != null)
				writer.append(lineFromFile);
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		
		/*int i = 2;
		int j = 3;
		String k = "";
		int answer = Integer.parseInt(k + i + j);
		System.out.println(answer);
		//evaluates to 23
		
		
		int i = 5;
		int answer = i--;
		System.out.println(answer);
		//evaluates to 5
		
		int i = 13;
		int answer = i%18;
		System.out.println(answer);
		//evaluates to 13
		
		int i = 5;
		int answer = ++i;
		System.out.println(answer);
		//evaluates to 6
		
		int i = 1;
		int answer = i = 5;
		System.out.println(answer);
		//evaluates to 5
		
		Long l = new Long(1234);
		Long ll = l;
		if(l == ll)
			System.out.println("Equal Objects");
		else
			System.out.println("Not Equal Objects");
		l++;
		if(l == ll)
			System.out.println("Equal Objects");
		else
			System.out.println("Not Equal Objects");
		
		
		System.out.println(String.format("**Local time: %tT", Calendar.getInstance()));
		System.out.println(String.format(">>Local time: %tH:%tM:%tS", Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance()));
		System.out.println(String.format("Local time: %tT", Calendar.getInstance().toString()));
		System.out.println(String.format("Local time: %1$tB", Calendar.getInstance()));
		System.out.println(String.format("Local time: %1$", Calendar.getInstance()));
		
		
		Calendar cal = Calendar.getInstance();
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.isLeapYear(2017));
		
		Integer i = Integer.parseUnsignedInt(4);
		Integer j = new Integer();
		Double d = new Double("17.46d");
		Character c = new Character("C");
		Boolean b = new Boolean("false");
		Float f = new Float(23.43);
		
		Integer number1 = new Integer(1);
		Integer number2 = number1;
		number1+=1;
		System.out.println(number1);
		System.out.println(number2);
		
		System.out.println(Stream.of("gree", "yellow", "blue")
				.max((s1, s2) -> s1.compareTo(s2))
					.filter(s -> s.endsWith("n"))
					.orElse("yellow"));
		
		int x = 5;
		System.out.println(x = ~x);
		//System.out.println(x.value());
		//System.out.println(x = !x);
		System.out.println(x = x >> 1);
		System.out.println(x += 3);
		
		Supplier<String> i = () -> "Car";
		Consumer<String> c = x -> System.out.print(x.toLowerCase());
		Consumer<String> d = x -> System.out.print(x.toUpperCase());
		c.andThen(d).accept(i.get());
		System.out.println();
		
		System.out.println("" + Runtime.getRuntime().totalMemory());
		System.out.println("" + Runtime.getRuntime().maxMemory());
		System.out.println("" + Runtime.getRuntime().freeMemory());
		
		String str1 = "My String";
		String str2 = new String("My String");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.matches(str2));
		System.out.println(str1.hashCode() == str2.hashCode());
		
			
		List<String> list = Arrays.asList("dog", "over", "good");
		
		System.out.println(list.stream().reduce(new String(), (s1, s2) -> s1 + s2.charAt(0), (c1, c2) -> c1 += c2));
		
		System.out.println(list.stream().reduce(new String(), (x1, x2) -> {if  (x1.equals("dog"))return x1;return x2;}));
		
		list.stream().reduce((x1, x2) -> x1.length() > x2.length()?x1:x2).ifPresent(System.out::println);
		
		list.stream().reduce((x1, x2) -> x1.length()==3? x1:x2).ifPresent(System.out::println);
		
		BufferedReader inputStream = new BufferedReader(new FileReader("input.dat"));
		
		FileReader inputStream1 = new FileReader("");
		
		
		YearMonth ym1 = YearMonth.now();
		YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
		
		System.out.println(ym2.until(ym1, ChronoUnit.MONTHS));
		System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));
		System.out.println(ym2.compareTo(ym1));
		System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());*/
	}
}