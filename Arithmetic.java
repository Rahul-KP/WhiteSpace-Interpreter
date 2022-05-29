
public class Arithmetic {

	private StackOperations s;
	public Arithmetic(StackOperations s){

		this.s = s;
	}

	public void add() {
		s.push(s.pop()+s.pop());
	}
	public void subtract() {
		s.push(s.pop()-s.pop());
	}
	public void multiply() {
		s.push(s.pop()*s.pop());
	}
	public void divide() {
		s.push(s.pop()/s.pop());
	}
	public void modulo() {
        s.push(s.pop()%s.pop());
    }
}