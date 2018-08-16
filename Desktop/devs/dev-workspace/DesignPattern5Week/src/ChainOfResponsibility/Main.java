package ChainOfResponsibility;

public class Main {
	public static void main(String[] args) {
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("elmo");
		Support fred = new LimitSupport("Fred", 300);
		
		//사슬의 형성
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);	
		//트러블 발생
		for(int i=0; i<500; i+=33) {
			alice.support(new Trouble(i));
		}
	}
	
}