

public class StackOperations extends CreateStack{
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
		//corner cases yet to covered if n>= size of stack
		if(n < s.size()) {
		Integer top = (Integer)s.pop();

		for(int i=0;i<n;i++) 
			this.discard();
		s.push(top);
		}
	}
}