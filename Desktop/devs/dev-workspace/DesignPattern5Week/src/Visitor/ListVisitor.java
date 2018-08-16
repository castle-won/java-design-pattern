package Visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor{

	private String currentdir = "";
	
	@Override
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	@Override
	public void visit(Directory dir) {
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
