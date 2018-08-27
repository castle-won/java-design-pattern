package State;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {

	private TextField textClock = new TextField(60);	//현재시간 표시
	private TextArea textScreen = new TextArea(10, 60);	//경비센터 출력
	private Button buttonUse = new Button("금고사용");		//금고사용 버튼
	private Button buttonAlarm = new Button("비상벨");	//비상벨 버튼
	private Button buttonPhone = new Button("일반통화");	//일반통화 버튼
	private Button buttonExit = new Button("종료");		//종료 버튼
	
	private State state = DayState.getInstance();
	
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// textClock을 배치
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		// textScreen을 배치
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		// 패널에 버튼을 저장
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		//그 패널을 배치
		add(panel, BorderLayout.SOUTH);
		//표시
		pack();
		show();
		//listener 설정
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	@Override
	public void setClock(int hour) {
		String clockString = "현재 시각은";
		if(hour < 10)
			clockString += "0"+hour+":00";
		else
			clockString += hour+":00";
		
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		System.out.println(this.state+"에서"+state+"로 상태가 변화했습니다.");
		this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call! "+msg+"\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record... "+msg+"\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if(e.getSource() == buttonUse) { //금고 사용 버튼
			state.doUse(this);
		}else if(e.getSource() == buttonAlarm) { //비상벨 버튼
			state.doAlarm(this);
		}else if(e.getSource() == buttonPhone) { //일반통화 버튼
			state.doPhone(this);
		}else if(e.getSource() == buttonExit) { // 종료 버튼
			System.exit(0);
		}else {
			System.out.println("?");
		}
	}

	
}
