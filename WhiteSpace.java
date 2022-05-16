import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException;  


public class WhiteSpace {
	public void parsing() {
		try {
			File f = new File("./sample.ws");
			FileInputStream fis = new FileInputStream(f);
			int r = 0;
			while((r = fis.read()) != -1) {
				// System.out.print((char)r);
				if(r== 32) { 
					System.out.println("Stack Manipulation");
				}

				else if(r==9) {
					r=fis.read();
					if(r == 32) {
						System.out.println("Arithmetic");
					} 
					else if(r == 9) {
						System.out.println("Heap Access");
					} 
					else if(r == 10) {
						System.out.println("I/O");
					} 
				}
				else if(r==10) {
					System.out.println("FLow Control");
				}

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("The file specified was not found");
		}
		catch (IOException e) {
			System.out.println("Could not read the file");
		}
	}

	// 32 -> space
	// 9 -> tab
	// 10 -> line feed

	public int convert(FileInputStream fis) throws IOException {
		int r;
		int i=0;
		boolean positive = true;
		StringBuilder sb = new StringBuilder(); 
		r=fis.read();

		if(r == 9) {
			// negative
			positive = false;
		}

		while((r = fis.read())!= 10) {
			if(r == 32) {
				sb.append("0");
			}
			else if(r==9) {
				sb.append("1");
			}
		}
		int temp = Integer.parseInt(sb.toString(),2);
		if(!positive) {
			temp*= -1;
		}
		return temp;
	}
}