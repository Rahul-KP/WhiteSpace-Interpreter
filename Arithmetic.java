

public class Arithmetic extends CreateStack{
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
	public void modulo() {
        s.push((Integer)s.pop()%(Integer)s.pop());
    }
}