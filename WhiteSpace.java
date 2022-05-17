import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException;  

// spaces -> (0) 
// tabs   -> (1)

public class WhiteSpace {
	public void parsing() {
		try {
			File f = new File("./sample.ws"); // File containing whitespace source code
			FileInputStream fis = new FileInputStream(f);
			int r = 0; // Variable to store every character read from the file (one at a time)

			while((r = fis.read()) != -1) {
				// System.out.print((char)r);
				if(r == 32) { 
					System.out.println("Stack Manipulation");
					// Code to perform stack manipulation operations
				}

				else if(r == 9) {
					r = fis.read();
					if(r == 32) {
						System.out.println("Arithmetic");
						// Code to perform arithmetic operations
					} 
					else if(r == 9) {
						System.out.println("Heap Access");
						// Code to perform heap operations
					} 
					else if(r == 10) {
						System.out.println("I/O");
						// Code to perform i/o operations
					} 
				}

				else if(r==10) {
					System.out.println("FLow Control");
					// Code to perform flow control operations
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

	// Function to convert a number in whitespace to integer
	public int convert(FileInputStream fis) throws IOException {
		int r, i = 0, res;
		boolean positive = true; // Assuming the number to be positive by default
		StringBuilder sb = new StringBuilder(); 
		r = fis.read();

		if(r == 9) {
			// negative
			positive = false;
		}

		// Read each character and store it as a binary string
		while((r = fis.read())!= 10) {
			if(r == 32) {
				sb.append("0");
			}
			else if(r == 9) {
				sb.append("1");
			}
		}

		// Convert the binary string to a final integer
		res = Integer.parseInt(sb.toString(), 2);
		if(!positive) {
			res *= -1;
		}
		return res;
	}
}