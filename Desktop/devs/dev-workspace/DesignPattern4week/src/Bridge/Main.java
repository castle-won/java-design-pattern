package Bridge;

public class Main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello, world"));
		Display d2 = new CountDisplay(new StringDisplayImpl("Hi, It's a goodDay"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(3);
	}
}
