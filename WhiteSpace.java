import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException;  

// spaces -> (0) -> +ve
// tabs   -> (1) -> -ve

public class WhiteSpace extends StackOperations {
	public void parsing() {
		try {
			File f = new File("./nums.ws"); // File containing whitespace source code
			FileInputStream fis = new FileInputStream(f);
			int r = 0; // Variable to store every character read from the file (one at a time)

			while((r = fis.read()) != -1) {

				// System.out.print((char)r);
				if(r == 32) { 
					System.out.println("Stack Manipulation");

					r= fis.read(); // reading 2nd charcter
					
					if(r==32){
						System.out.println("Push item into stack");
							
							// here call convert function and pass the number ,
						int x = convert(fis);
						System.out.println("The number is: "+ x);

							// once u receive the a number -> x
							// call push(x)
						
						sop.push(x);
					}

					else if(r==9){
						// check for sp,LN
						r= fis.read(); // reading 3rd character
						if(r==32){
							System.out.println("Copy nth item onto the stack");

							// here x is the index position , value at that index is copied at the top of stack
							int x = convert(fis);
							System.out.println("The number/ index position is: "+ x);

							// calling the stack operation
							sop.copy(x);

						}
						else if(r==10){
							System.out.println("Sliding n item off the stack exect top ele");

							// x -> no of times to be slided off the stack
							int x = convert(fis);

							System.out.println("The number of items popped are: "+ x);
							sop.slide(x);


						}
					}

					else if(r==10){
						r= fis.read(); // reading 3rd character
						if(r==32){
							System.out.println("Duplicate top");

							sop.duplicateTop();
						}
						else if(r==10){
							System.out.println("Remove top");

							sop.discard();
						}
						else if(r==9){
							System.out.println("Swap 2 items");
							
							sop.swap();
						}

					}

					
				}

				else if(r == 9) {
					r = fis.read();
					if(r == 32) {
						System.out.println("Arithmetic");

						//reading 3rd character
						r = fis.read();
						if(r == 32){

							r= fis.read()
							if( r==32){
								System.out.println("Addting");
								aop.add();
							}
							else if(r== 9){
								System.out.println("Subtraction");
								aop.subtract();
							}
							else if(r==10){
								System.out.println("Multiplication");
								aop.multiply();
							}

						}
						else if(r==9){

							r=fis.read();
							if(r==32){
								System.out.println("Divide");
								aop.divide();
							}
							else if(r==9){
								System.out.println("Modulo");
								aop.modulo();
							}
						}

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
		System.out.println("this is r : "+ r);

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