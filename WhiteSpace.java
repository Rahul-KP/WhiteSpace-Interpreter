import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException;

// spaces -> (0) -> +ve
// tabs   -> (1) -> -ve

public class WhiteSpace{
	
	private FileInputStream fis;
	public IO io;
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
		aop = new Arithmetic(this.sop);
		io = new IO(this.sop);
	}


	public void parsing() {
		int r = 0, tmp; // Variable to store every character read from the file (one at a time)
		try {
			while((r = fis.read()) != -1) {
				switch(r) {
					case 9: //tab
						r = fis.read();
						switch(r) {
							case 9: //tab - Heap operation
							case 32: //space - Arithmetic operations
								r = fis.read();
								switch(r) {
									case 32:
										r = fis.read();
										switch(r) {
											case 9: //tab - Subtraction
												System.out.println("Subtraction of first two elements of the stack"); aop.subtract();  break;
											case 10: //LF - Multiplication
												System.out.println("Multiplication of first two elements of the stack"); aop.multiply(); break;
											case 32: //space - Addition
												System.out.println("Addition of first two elements of the stack"); aop.add(); break;
										}
										break;
									case 9:
										r = fis.read();
										switch(r) {
											case 32: //Division
												System.out.println("Division of first two elements of the stack"); aop.divide(); break;
											case 9: //Modulus
												System.out.println("Modulus of first two elements of the stack"); aop.modulo(); break;
										}
								}
								break;
							case 10: //LF - I/O operations
								r = fis.read();
								System.out.println("I/O");
								switch(r) {
									case 32: //Output
										r = fis.read();
										if(r == 32) 
											io.outputChar();
										else
											io.outputInt();
										break;
									case 9: //Input
										r = fis.read();
										io.input();
										break;
								}
								break;
						}
						break;
					case 10: //LF
					case 32: //space - Stack Manipulation
						r = fis.read();
						switch(r) {
							case 32: //push
								
								tmp = this.convert(fis);
								sop.push(tmp);
								System.out.println("Pushing : "+ tmp);
								break;
							case 10:
								r = fis.read();
								switch(r) {
									case 9: //swap top
										System.out.println("Swap top two  elements"); sop.swap(); break;
									case 10: //discard top item
										System.out.println("Discard top item"); sop.discard(); break;
									case 32: //duplicate
										System.out.println("Duplicate the top item on the stack"); sop.duplicateTop(); break;
								}
								break;
							case 9:
								r = fis.read();
								switch(r) {
									case 32: //copy nth item to top
										tmp = this.convert(fis); sop.copy(tmp);System.out.println("Copying the element at index "+tmp +"on to top of the stack"); break;
									case 10: //slide n items
										 tmp = this.convert(fis); sop.slide(tmp);System.out.println("Slide " + tmp+" numbers of the stack"); break;
								}
						}
						break;
				}
			}
		}
		catch (IOException e) {
			System.out.println(e);
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
		// System.out.println("this is r : "+ r);

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