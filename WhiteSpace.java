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
				if(r== 32){ 
					System.out.println("Stack Manipulation");
				}

				else if(r==9){
					r=fis.read();
					if(r == 32){
						System.out.println("Arithmetic");
					} 
					else if(r == 9){
						System.out.println("Heap Access");
					} 
					else if(r == 10){
						System.out.println("I/O");
					} 
				}
				else if(r==10){
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

	public int convert(FileInputStream fis){
		int r;
		int i=0;
		boolean positive = true;
		StringBuilder sb = new StringBuilder(); 
		r=fis.read();

		if( r == 9){
			// negative
			positive = false;
		}

		while((r = fis.read())!= 10){
			if(r == 32){
				sb.append("0");
			}
			else if(r==9){
				sb.append("1");
			}
		}
		int temp = Integer.parseInt(sb.toString(),2);
		if(!positive){
			temp*= -1;
		}
		return temp;


	}

	public static void main(String[] args) {
		WhiteSpace obj = new WhiteSpace();
		obj.parsing();
		// Stack_manipulation st = new Stack_manipulation();
		// st.push(1);
		// st.push(2);
		// st.push(3);
		// st.push(4);
		// st.push(5);					//1,2,3,4,5 -top->5
		// System.out.println(st.s);
		
		// st.duplicateTop();			//1,2,3,4,5,5
		// System.out.println(st.s);
		
		// st.copy(1);					//1,2,3,4,5,5,2
		// System.out.println(st.s);
		
		// st.swap();					//1,2,3,4,5,2,5
		// System.out.println(st.s);

		// System.out.println('\n');
		// Arithmetic a = new Arithmetic();
		// a.s.push(1);
		// a.s.push(2);
		// a.s.push(3);
		// a.s.push(4);
		// a.s.push(5);
		// a.add();
		// System.out.println(a.s);
		// a.subtract();
		// System.out.println(a.s);
		// a.multiply();
		// System.out.println(a.s);
		// a.divide();
		// System.out.println(a.s);
	}
}