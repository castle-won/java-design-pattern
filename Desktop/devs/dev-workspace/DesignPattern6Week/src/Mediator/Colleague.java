package Mediator;

//회원을 나타내는 인터페이스
public interface Colleague {
	public abstract void setMediator(Mediator mediator); //중개인을 등록
	public abstract void setColleagueEnabled(boolean enabled); //중개인이 내리는 지시
}
