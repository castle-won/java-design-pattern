package ChainOfResponsibility;

public class SpecialSupport extends Support{

	private int number;	//이 번호만 해결 가능
	public SpecialSupport(String name, int number) { //생성자
		super(name);
		this.number = number;
	}
	
	@Override
	protected boolean resolve(Trouble trouble) { //해결용 메소드
		if(trouble.getNumber() == number)
			return true;
		
		return false;
	}
	
}
