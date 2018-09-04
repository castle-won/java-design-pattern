package Proxy;

public class Printer implements Printable{

	private String name;
	public Printer() {}
	
	public Printer(String name) { //생성자
		this.name = name;
		heavyJob("Printer의 인스턴스("+name+")을 생성 중");
	}
	
	public void setPrinterName(String name) {
		this.name = name;
	}

	public String getPrinterName() {
		return name;
	}

	public void print(String string) {
		System.out.println("==="+name+"===");
		System.out.println(string);
	}
	
	private void heavyJob(String msg) { //무거운 일(의 예정)
		System.out.println(msg);
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			System.out.println(".");
		}
		System.out.println("완료.");
	}
}
