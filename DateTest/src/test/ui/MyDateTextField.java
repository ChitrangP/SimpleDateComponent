package test.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;

import test.ui.util.MyDateFormatter;
import test.ui.util.Util;

public class MyDateTextField extends JFormattedTextField {
	private SimpleDateFormat dateFormat;
	private String dateFormatPattern;
	private Date minDate;
	private Date maxDate;

	public MyDateTextField() {
		super();
	}
	
	public MyDateTextField(Date initialDateValue) {
		super();
		setDateFormat(Util.DATE_FORMAT_MM_DD_YYYY, Util.DATE_FORMAT_NN_NN_NNNN_PATTERN);
		setDate(initialDateValue);
	}

	public MyDateTextField(Date initialDateValue, Date minDate, Date maxDate) {
		super();
		setDateFormat(Util.DATE_FORMAT_MM_DD_YYYY, Util.DATE_FORMAT_NN_NN_NNNN_PATTERN);
		setDate(initialDateValue, minDate, maxDate);
	}

	public void setDate(Date initialDateValue) {
		setDate(initialDateValue, Util.getMinDate(), Util.getMaxDate());
	}
	
	public void setDate(Date initialDateValue, Date minDate, Date maxDate) {
		this.minDate = minDate;
		this.maxDate = maxDate;
		
		resetFormatterFactory();

		setValue(initialDateValue);
	}

	public Date getDate() {
		return (Date) getValue();
	}
	
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat, String dateFormatPattern) {
		this.dateFormat = dateFormat;
		this.dateFormatPattern = dateFormatPattern;
		
		resetFormatterFactory();
	}
	
	private void resetFormatterFactory() {
		dateFormat.setLenient(false);
		JFormattedTextField.AbstractFormatter editDateFormatter = new MyDateFormatter(dateFormat, dateFormatPattern, minDate, maxDate);
		JFormattedTextField.AbstractFormatter displayDateFormatter = new MyDateFormatter(dateFormat, dateFormatPattern, minDate, maxDate);

		DefaultFormatterFactory factory = new DefaultFormatterFactory(displayDateFormatter, displayDateFormatter, editDateFormatter);		
		setFormatterFactory(factory);
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
}
