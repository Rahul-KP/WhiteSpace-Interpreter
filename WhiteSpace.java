import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException;

// spaces -> (0) -> +ve
// tabs   -> (1) -> -ve

public class WhiteSpace{
	
	private FileInputStream fis;
	public StackOperations sop;
	public Arithmetic aop;
	public WhiteSpace(String fname){
		try{
			File f = new File(fname); // File containing whitespace source code
		fis = new FileInputStream(f);
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		
		sop = new StackOperations();

	}


	public void parsing() {
		try {

			int r = 0; // Variable to store every character read from the file (one at a time)

			while((r = fis.read()) != -1) {

				// System.out.print((char)r);
				if(r == 32) { 
					// first character = space
					System.out.println("Stack Manipulation");

					r= fis.read(); // reading 2nd charcter
					
					if(r==32){
						// second character = space
						System.out.println("Push item into stack");
							
							// here call convert function and pass the number ,
						int x = convert(fis);
						System.out.println("The number is: "+ x);

							// once u receive the a number -> x
							// call push(x)
						
						sop.push(x);
					}

					else if(r==9){
						// second character = tab
						// check for sp,LN
						r= fis.read(); // reading 3rd character
						if(r==32){
							// third character = space
							System.out.println("Copy nth item onto the stack");

							// here x is the index position , value at that index is copied at the top of stack
							int x = convert(fis);
							System.out.println("The number/ index position is: "+ x);

							// calling the stack operation
							sop.copy(x);

						}
						else if(r==10){
							// third character = linefeed
							System.out.println("Sliding n item off the stack exect top ele");

							// x -> no of times to be slided off the stack
							int x = convert(fis);

							System.out.println("The number of items popped are: "+ x);
							sop.slide(x);


						}
					}

					else if(r==10){
						// second character = linefeed
						r= fis.read(); // reading 3rd character
						if(r==32){
							// third character = space
							System.out.println("Duplicate top");

							sop.duplicateTop();
						}
						else if(r==10){
							// third character = linefeed
							System.out.println("Remove top");

							sop.discard();
						}
						else if(r==9){
							//third character = tab
							System.out.println("Swap 2 items");
							
							sop.swap();
						}

					}

					
				}

				else if(r == 9) {
					// first character = tab
					r = fis.read();
					if(r == 32) {
						// second character = space
						System.out.println("Arithmetic");

						//reading 3rd character
						r = fis.read();
						if(r == 32){
							// third character = space
							r= fis.read();
							if( r==32){
								// fourth character = space
								System.out.println("Addting");
								aop.add();
							}
							else if(r== 9){
								//fourth character = tab
								System.out.println("Subtraction");
								aop.subtract();
							}
							else if(r==10){
								// fourth character = linefeed
								System.out.println("Multiplication");
								aop.multiply();
							}

						}
						else if(r==9){
							// third character = tab
							r=fis.read();
							if(r==32){
								// fourth charcter = space
								System.out.println("Divide");
								aop.divide();
							}
							else if(r==9){
								// fourth character = tab
								System.out.println("Modulo");
								aop.modulo();
							}
						}

						// Code to perform arithmetic operations


					} 
					else if(r == 9) {
						// second character = tab
						System.out.println("Heap Access");
						r = fis.read();
						if(r == 32) {
							// third character = space
							System.out.println("Store in heap");
						}
						else if(r == 9) {
							// third character = tab
							System.out.println("Retrieve from heap");
						}
						// Code to perform heap operations
					} 
					else if(r == 10) {
						// second character = linefeed
						System.out.println("I/O");
						r = fis.read();
						if(r == 32) {
							// third character = space
							r = fis.read();
							if(r == 32) {
								// fourth character = space
								System.out.println("Output character at top of stack");
							}
							else if( r == 9) {
								// fourth character = tab
								System.out.println("Output number at top of stack");
							}
						}
						else if(r == 9) {
							// third character = tab
							r = fis.read();
							if( r == 32) {
								// fourth character = space
								System.out.println("Read character place location given by top");
							}
							else if( r == 9) {
								// fourth character = tab
								System.out.println("Read number placed location given by top"); 
							}
						}
						// Code to perform i/o operations
					} 
				}

				else if(r==10) {
					// first character = linefeed
					System.out.println("FLow Control");
					r = fis.read();
					if(r == 32) {
						// second character = space
						r = fis.read();
						if(r == 32) {
							// third character = space
							System.out.println("Mark location taking a label as a parameter");
						}
						else if(r == 9) {
							// third character = tab
							System.out.println("Call subroutine taking a label as a parameter");
						}
						else if(r == 10) {
							// third character = linefeed
							System.out.println("Jump to label taking a label as a parameter");
						}
					}
					else if(r == 9) {
						// second character = tab
						r = fis.read();
						if(r == 32) {
							// third character = space
							System.out.println("Jump to label if top of stack is zero taking a label as parameter");
						}
						else if(r == 9) {
							// third character = tab
							System.out.println("Jump to label if top of stack is negative taking a label as parameter");
						}
						else if(r == 10) {
							// third character = linefeed
							System.out.println("End subroutine and transfer control back to caller");
						}
					}
					else if(r == 10) {
						// second character = linefeed
						r = fis.read();
						if(r == 10) {
							// third character = linefeed
							System.out.println("End program");
						}
					}
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