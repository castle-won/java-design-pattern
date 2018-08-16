package ChainOfResponsibility;

public abstract class Support {
	private String name;	//트러블 해결자
	private Support next;	//떠넘길 Support
	
	public Support(String name) { //생성자
		this.name = name;
	}
	
	public Support setNext(Support next) { //떠넘길 Support 설정
		this.next = next;
		return next;
	}
	
	public final void support(Trouble trouble) { //트러블 해결 수순
		if(resolve(trouble)) {
			done(trouble);
		} else if(next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}
	
	public String toString() { //문자열 표현
		return "[" + name + "]";
	}
	protected abstract boolean resolve(Trouble trouble); //해결 메소드
	protected void done(Trouble trouble) { //해결시
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	protected void fail(Trouble trouble) { //미해결시
		System.out.println(trouble + " cannot be resolved.");
	}
}
