package Command.drawer;

import java.awt.Point;

import Command.command.Command;

public class DrawCommand implements Command {

	// 그림 그리는 대상
	protected Drawable drawable;
	// 그림 그리는 위치
	protected Point position;
	
	// 생성자
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	
	public void execute() {
		drawable.draw(position.x, position.y);
	}

}
