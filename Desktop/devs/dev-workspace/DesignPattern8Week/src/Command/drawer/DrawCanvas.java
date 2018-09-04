package Command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import Command.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {

	// 그림 그리는 색
	private Color color;
	// 그림 그리는 점의 반경
	private int radius = 6;
	// 이력
	private MacroCommand history;
	// 생성자
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}
	
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}

}
