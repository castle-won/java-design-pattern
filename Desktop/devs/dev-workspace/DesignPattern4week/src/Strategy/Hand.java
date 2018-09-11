package Strategy;

public class Hand {
	public static final int HANDVALUE_GUU = 0; //주먹
	public static final int HANDVALUE_CHO = 1; //가위
	public static final int HANDVALUE_PAA = 2; //보
	public static final Hand[] hand = {new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA)};
	private static final String[] name = {"주먹","가위","보"};
	int handvalue;
	public Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	public static Hand getHand(int handvalue) { //값에서 인스턴스 얻음
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}
	private int fight(Hand h) {
		if(this == h) {
			return 0;
		}else if((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		}else {
			return -1;
		}
	}
	public String toString() {
		return name[handvalue];
	}
}
