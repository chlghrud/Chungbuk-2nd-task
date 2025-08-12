package movie.util;

import java.util.Stack;

import javax.swing.JFrame;

public class NavigationManager {
	private static final Stack<JFrame> frameHistory = new Stack<>();
	
	public static void open(JFrame newFrame) {
		if(!frameHistory.isEmpty()) {
			frameHistory.peek().setVisible(false);
		}
		frameHistory.push(newFrame);
		newFrame.setVisible(true);
	}
	public static void back() {
		if(frameHistory.size() > 1) {
			frameHistory.pop().dispose();
			frameHistory.peek().setVisible(true);
		}
	}
	public static void goTo(JFrame frame) {
    	while(!frameHistory.isEmpty()) {
    		frameHistory.pop().dispose();
    	}
    	frameHistory.push(frame);
    	frame.setVisible(true);
    }
}
