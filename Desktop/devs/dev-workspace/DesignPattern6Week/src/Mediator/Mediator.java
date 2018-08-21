package Mediator;

//'중개인'을 표현하는 인터페이스
public interface Mediator {
	public abstract void createColleagues(); //회원을 생성
	public abstract void colleagueChanged(); //회원인들에게서 호출되는 메소드
}
