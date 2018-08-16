package Visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor{

	private String currentdir = "";	//현재 주목하고 있는 디렉터리 이름
	@Override
	public void visit(File file) {  //파일을 방문시 호출
		System.out.println(currentdir + "/" + file);
	}
	@Override
	public void visit(Directory dir) { //디렉터리 방문시 호출
		System.out.println(currentdir + "/" + dir);
		String savedir = currentdir;
		currentdir = currentdir + "/" + dir.getName();
		Iterator it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}
}
