package ChainOfResponsibility;

public class OddSupport extends Support {

	public OddSupport(String name) { //생성자
		super(name);
	}
	
	@Override
	protected boolean resolve(Trouble trouble) { //해결용 메소드
		if(trouble.getNumber() % 2 == 1)
			return true;
		
		return false;
	}
	
}
