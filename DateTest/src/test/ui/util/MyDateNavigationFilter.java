package test.ui.util;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.NavigationFilter;
import javax.swing.text.Position;

public class MyDateNavigationFilter extends NavigationFilter {
	private int direction = 3;

	private boolean isCursorMovedByNavigationKey  = false;

	private boolean isInsert  = false;
	private boolean isReplace = false;

	public boolean isInsert() {
		return isInsert;
	}

	public boolean isReplace() {
		return isReplace;
	}
	
	public void setDot(FilterBypass fb, int dot, Position.Bias bias) {
		if ((dot == 2 || dot == 5) && direction == 3) {
			dot++;
		}
		else if ((dot == 2 || dot == 5) && direction == 7) {
			if (! isCursorMovedByNavigationKey && (isReplace || isInsert)) {
				dot++;
			}
			else {
				dot--;
			}
		}
		super.setDot(fb, dot, bias);
	}

	public void moveDot(FilterBypass fb, int dot, Position.Bias bias) {
		super.moveDot(fb, dot, bias);
	}

	public int getNextVisualPositionFrom(JTextComponent text, int pos, Position.Bias bias, int direction, Position.Bias[] biasRet) throws BadLocationException {
		this.direction = direction;
		this.isCursorMovedByNavigationKey = true;

		return super.getNextVisualPositionFrom(text, pos, bias, direction, biasRet);
	}
	
	public void setFlags(boolean isInsert, boolean isReplace) {
		this.isInsert = isInsert;
		this.isReplace = isReplace;
		
		this.isCursorMovedByNavigationKey = false;
	}
}
