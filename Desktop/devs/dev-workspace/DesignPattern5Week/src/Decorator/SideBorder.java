package Decorator;

public class SideBorder extends Border{

	char borderChar;	//장식이 되는 문자
	
	public SideBorder(Display display, char ch) {	//생성자에서 Display와 장식 문자를 지정
		super(display);
		borderChar = ch;
	}
	
	@Override
	public int getColumns() {				//문자는 내용물 양쪽에
		return 1+display.getColumns()+1;	//장식 문자수를 더하여 반환
	}
	@Override
	public int getRows() {					//행수는 내용물의 행수와 동일
		return display.getRows();			
	}
	@Override
	public String getRowText(int row) {		//지정된 행의 내용은 내용물의 지정된 행 양쪽에 장식문자를 붙인 것.
		return borderChar + display.getRowText(row) + borderChar;
	}
	
}
