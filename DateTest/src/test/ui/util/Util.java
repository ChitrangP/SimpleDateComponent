package test.ui.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
	public final static SimpleDateFormat DATE_FORMAT_MM_DD_YY = new SimpleDateFormat("MM-dd-yy");
	public final static SimpleDateFormat DATE_FORMAT_MM_DD_YYYY = new SimpleDateFormat("MM-dd-yyyy");
	public final static SimpleDateFormat DATE_FORMAT_DD_MM_YY = new SimpleDateFormat("dd-MM-yy");
	public final static SimpleDateFormat DATE_FORMAT_DD_MM_YYYY = new SimpleDateFormat("dd-MM-yyyy");
	public final static SimpleDateFormat DATE_FORMAT_YY_MM_DD = new SimpleDateFormat("yy-MM-dd");

	public final static String DATE_FORMAT_NN_NN_NN_PATTERN = "\\d\\d-\\d\\d-\\d\\d";
	public final static String DATE_FORMAT_NN_NN_NNNN_PATTERN = "\\d\\d-\\d\\d-\\d\\d\\d\\d";

	public static Date getMinDate() {
		GregorianCalendar minGC = new GregorianCalendar(1970, 0, 1);
		return minGC.getTime();
	}

	public static Date getMaxDate() {
		GregorianCalendar maxGC = new GregorianCalendar(2500, 0, 1);
		return maxGC.getTime();
	}
}
