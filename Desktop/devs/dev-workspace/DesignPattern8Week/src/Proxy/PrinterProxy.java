package Proxy;

public class PrinterProxy implements Printable {

	private String name;				//이름
	private Printer real;				//'본인'
	
	public PrinterProxy() {}
	public PrinterProxy(String name) {  //생성자
		this.name = name;
	}
	
	public String getPrinterName() {	//getter
		return name;
	}
	
	public synchronized void setPrinterName(String name) { // setter
		if(real != null) // '본인'에게도 이름설정
			real.setPrinterName(name);
		
		this.name = name;
	}

	public void print(String string) {
		realize();
		real.print(string);
	}

	private synchronized void realize() { // '본인'을 생성
		if (real == null)
			real = new Printer(name);
	}
}
