import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.*;  
import java.io.IOException; 

class Test {

	public static void testStack(StackOperations st){
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);					//1,2,3,4,5 -top->5
		System.out.println(st.s);

		st.duplicateTop();			//1,2,3,4,5,5
		System.out.println(st.s);

		st.copy(1);					//1,2,3,4,5,5,2
		System.out.println(st.s);

		st.swap();					//1,2,3,4,5,2,5
		System.out.println(st.s);
	}

	public static void main(String[] args)throws Exception {
		WhiteSpace obj = new WhiteSpace(args[0]);
		obj.parsing();
	}
}