package test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import test.ui.MyDateTextField;
import test.ui.util.Util;

public class DateTextFieldTest {
   private static void createAndShowGUI() {
	   GregorianCalendar currDate = new GregorianCalendar();

	   GregorianCalendar gcMin = new GregorianCalendar(currDate.get(Calendar.YEAR), currDate.get(Calendar.MONTH), 1);
	   GregorianCalendar gcMax = new GregorianCalendar(currDate.get(Calendar.YEAR), currDate.get(Calendar.MONTH), currDate.getMaximum(GregorianCalendar.DAY_OF_MONTH));
	   
//	   MyDateTextField field1 = new MyDateTextField(new Date(), gcMin.getTime(), gcMax.getTime());

	   MyDateTextField field1 = new MyDateTextField();
	   field1.setDateFormat(Util.DATE_FORMAT_MM_DD_YYYY, Util.DATE_FORMAT_NN_NN_NNNN_PATTERN);
	   field1.setDate(new Date(), gcMin.getTime(), gcMax.getTime());
	   
      JPanel panel = new JPanel();
      panel.add(field1);
      panel.add(new JButton("Dummy"));

      JFrame frame = new JFrame("MyDocFilter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}
