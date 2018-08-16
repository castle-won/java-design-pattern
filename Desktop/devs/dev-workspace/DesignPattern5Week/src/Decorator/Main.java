package Decorator;

public class Main {
	public static void main(String[] args) {
		Display b1 = new StringDisplay("Hello, World");
		Display b2 = new SideBorder(b1, '#');
		Display b3 = new FullBorder(b2);
		b1.show();
		b2.show();
		b3.show();
		Display b4 = new SideBorder(
						 new FullBorder(
							 new FullBorder(
								 new SideBorder(
									 new FullBorder(
										 new StringDisplay("HELLO!!")
									 )
								 , '*')
							 )
						 )
					 , '/');
		b4.show();
	}
}
