package java8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class FileClass {

	public static void main(String[] args) {
		//String f="file1.java";
		//File f1 = new File(f);
		
		//InputStream iout = FileInputStream(f1);
		//--Reader iout = new FileReader(f1);
		//InputStream iout = InputStream(f1);
		//--FileOutputStream iout1 = new FileOutputStream(f1);
		//RandomAccessFile rf = RandomAccessFile(f1);
		
		
		File file = new File("test.txt");
		File backup = new File("test.txt.bak");
		backup.delete();
		file.renameTo(backup);  // Location 1
	}
}