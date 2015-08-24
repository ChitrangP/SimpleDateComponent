package test.ui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class MyDateDocumentFilter extends DocumentFilter {
	private MyDateNavigationFilter navigationFilter;
	private Pattern pattern;
	
	public MyDateDocumentFilter(MyDateNavigationFilter navigationFilter) {
		this.navigationFilter = navigationFilter;
	}
	
	public void setPattern(String patternStr) {
		this.pattern = Pattern.compile(patternStr);
	}

	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		// User can not delete anything
	}

	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		super.insertString(fb, offset, string, attr);

		navigationFilter.setFlags(true, false);
	}

	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		Document document = fb.getDocument();
		if (validText(document.getText(0, document.getLength()), offset, length, text)) {
			navigationFilter.setFlags(false, true);
			super.replace(fb, offset, Math.max(1, length), text, attrs);
		}
	}

	private boolean validText(String existingText, int offset, int length, String text) {
		boolean isValidText = true;
		
		if (text != null && text.length() > 0) {
			String newText = existingText.substring(0, offset) + text + existingText.substring(Math.min(10, offset+Math.max(1, length)));
			Matcher matcher = pattern.matcher(newText);
			isValidText = matcher.matches();
		}
		
		return isValidText;
	}
}
