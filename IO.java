import java.util.Scanner;

public class IO {
    private StackOperations s;
    private Scanner sc;
    public IO(StackOperations s) {
        this.s = s;
        sc = new Scanner(System.in);
    }
    public void outputChar() {
        char c = (char)s.peek();
        System.out.println("Output: " + c);
    }
    public void outputInt() {
        int c = (int)s.peek();
       System.out.println("Output: " + c);
    }
    public void input() {
        int c = sc.nextInt();
        s.push(c);
    }
}