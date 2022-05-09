import java.io.File;
import java.io.FileInputStream;

public class WhiteSpace {
	public void parsing() {
		try {
			File f = new File("./sample.ws");
			FileInputStream fis = new FileInputStream(f);
			int r = 0;
			while((r = fis.read()) != -1) {
				System.out.println((int)r);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("The file specified was not found");
		}
		catch (IOException e) {
			System.out.println("Could not read the file");
		}
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