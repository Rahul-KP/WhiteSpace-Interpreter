import java.util.Stack;
class CreateStack {
	public Stack<Integer> s;
	public CreateStack() {
		s = new Stack<Integer>();
	}
}
class Stack_manipulation extends CreateStack{
	public void push(int num) {
		s.push(num);
	}
	public void duplicateTop() {
		s.push((Integer)s.peek());
	}
	public void copy(int index) {
		s.push((Integer)s.get(index));
	}
	public void swap() {
		// Integer t = s.get(s.size()-2);//returns the 2nd element from top
		Integer t1 = (Integer)s.pop();
		Integer t2 = (Integer)s.pop();
		s.push(t1);
		s.push(t2);
	}
	public void discard() {
		s.pop();
	}
	public void slide(int n) {
		Integer top = (Integer)s.pop();
		for(int i=0;i<n;i++) 
			this.discard();
		s.push(top);
	}
}
class Arithmetic extends CreateStack{
	public void add() {
		s.push((Integer)s.pop()+(Integer)s.pop());
	}
	public void subtract() {
		s.push((Integer)s.pop()-(Integer)s.pop());
	}
	public void multiply() {
		s.push((Integer)s.pop()*(Integer)s.pop());
	}
	public void divide() {
		s.push((Integer)s.pop()/(Integer)s.pop());
	}
}
public class WhiteSpace {
	public static void main(String[] args) {
		Stack_manipulation st = new Stack_manipulation();
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

		System.out.println('\n');
		Arithmetic a = new Arithmetic();
		a.s.push(1);
		a.s.push(2);
		a.s.push(3);
		a.s.push(4);
		a.s.push(5);
		a.add();
		System.out.println(a.s);
		a.subtract();
		System.out.println(a.s);
		a.multiply();
		System.out.println(a.s);
		a.divide();
		System.out.println(a.s);

	}
}