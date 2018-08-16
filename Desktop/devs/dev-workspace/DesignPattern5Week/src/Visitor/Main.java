package Visitor;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			rootdir.accept(new ListVisitor());
			
			System.out.println("");
			System.out.println("Making user entries...");
			Directory kim = new Directory("Kim");
			Directory lee = new Directory("Lee");
			Directory park = new Directory("Park");
			usrdir.add(kim);
			usrdir.add(lee);
			usrdir.add(park);
			kim.add(new File("diary.html", 100));
			kim.add(new File("Composite.java", 100));
			lee.add(new File("memo.txt", 100));
			park.add(new File("game.doc", 100));
			park.add(new File("junk.mail", 100));
			rootdir.accept(new ListVisitor());
		}catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
