import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException; 

class Test {
	public static void main(String[] args)throws Exception {
		WhiteSpace obj = new WhiteSpace();
		// obj.parsing();

		File fn = new File("./nums.ws");
		FileInputStream fb = new FileInputStream(fn);

		int x = obj.convert(fb);
		System.out.println("the number is: "+x);
	}
}