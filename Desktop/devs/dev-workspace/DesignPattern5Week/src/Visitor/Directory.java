package Visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry{

	private String name;						//디렉터리 명
	private ArrayList dir = new ArrayList();	//디렉터리 엔트리 집합
	public Directory(String name) {				//생성자
		this.name = name;
	}
	
	@Override
	public String getName() {					//이름을 얻는다
		return name;
	}
	@Override
	public int getSize() {						//사이즈를 얻는다
		int size = 0;
		Iterator it = dir.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			size += entry.getSize();
		}
		return size;
	}
	public Entry add(Entry entry) {				//엔트리 추가
		dir.add(entry);
		return this;
	}
	public Iterator iterator() {				//Iterator 생성
		return dir.iterator();
	}
	@Override
	public void accept(Visitor v) {				//방문자 승낙
		v.visit(this);
	}
}
