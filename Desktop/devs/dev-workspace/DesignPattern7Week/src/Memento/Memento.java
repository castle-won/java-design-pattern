package Memento;
import java.util.ArrayList;
import java.util.List;

public class Memento {
	int money;							//소지금
	ArrayList fruits;					//과일
	Memento(int money){
		this.money = money;
		this.fruits = new ArrayList();
	}
	public int getMoney() {				//소지금을 얻음
		return money;
	}
	void addFruit(String fruit) {		//과일을 추가
		fruits.add(fruit);
	}
	List getFruits() {					//과일을 얻음
		return (List) fruits.clone();
	}
}