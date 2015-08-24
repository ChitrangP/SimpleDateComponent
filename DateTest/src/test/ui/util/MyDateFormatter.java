package test.ui.util;

import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DefaultFormatter;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NavigationFilter;

public class MyDateFormatter extends DefaultFormatter {
	private static final long serialVersionUID = -3753932053968782571L;
	
	private SimpleDateFormat df;
	private Date minDate;
	private Date maxDate;
	private MyDateNavigationFilter navigationFilter = new MyDateNavigationFilter();
	private MyDateDocumentFilter documentFilter = new MyDateDocumentFilter(navigationFilter);
	
	public MyDateFormatter(SimpleDateFormat format, String pattern, Date minDate, Date maxDate) {
		super();
		
		documentFilter.setPattern(pattern);
		
		this.df = format;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		String strVal = null;
		try {
			if (value == null) throw new ParseException("Null Value", 0);
			if (! (value instanceof java.util.Date)) throw new ParseException("Not java.util.Date instance. Value is instance of "+value.getClass().getName(), 0);
			
			Date objVal = (Date) value;
			if (objVal != null && (objVal.before(minDate) || objVal.after(maxDate))) throw new ParseException("Invalid Date Range.", 0);
		   
			strVal = df.format(value);
		}
		catch(ParseException e) {
		   	throw e;
	   	}
		catch(IllegalArgumentException ae) {
		   	throw new ParseException(ae.getMessage(), 0);
	   	}

	   	return strVal;
	}

	@Override
	public Object stringToValue(String str) throws ParseException {
		Date objVal = null;
	   
		try {
			objVal = df.parse(str);

			if (objVal != null && (objVal.before(minDate) || objVal.after(maxDate))) throw new ParseException("Invalid Date Range.", 0);
		}
		catch(ParseException e) {
		   	Toolkit.getDefaultToolkit().beep();
			throw e;
		}

		return objVal;
	}

	@Override
	protected DocumentFilter getDocumentFilter() {
		return documentFilter;
	}

	@Override
    protected NavigationFilter getNavigationFilter() {
		return navigationFilter;
    }
}
