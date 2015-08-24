# SimpleDateComponent

This is the simple date component in Swing. No date picker or spinner. It's a simple extention of JFormattedTextField. test.DateTextFieldTest.java is the test application to demonstrate use of MyDateTextField.

Main purpose of this date component:
- Let user just type the date in continuation of his other form fields. No use of mouse needed.
- Let user just enter numbers for day, month and year. No need to enter date separator For example, for the date '08-23-2015' (date format is MM-dd-yyyy) user just need to enter 08232015. He doesn't have to care about the separator (-).
- Skip the separator while user moves caret back and forth in text field.

  For example,<br>
    Initial caret position: |08-23-2015<br>
    User moves caret right: 0|8-23-2015<br>
    User moves caret right: 08-|23-2015<br>
    User moves caret left : 0|8-23-2015<br>

- Supports minimum date and maximum date constraint.

Date formats currently supported by the component. <br>
- MM-dd-yyyy
- MM-dd-yy
- dd-MM-yyyy
- dd-MM-yy
- yy-MM-dd

Of course, you can update it as per your need.

About Code:
- test.ui.MyDateTextField.java: The Date component extending JFormattedTextField. It uses test.ui.util.MyDateFormatter to format the date as well as performs Date validation. 

- test.ui.util.MyDateFormatter.java: It extends javax.swing.text.DefaultFormatter and overrides following methods. As mentioned earlier, it performs date validation.
    public String valueToString(Object value) throws ParseException
    public Object stringToValue(String str) throws ParseException
    protected DocumentFilter getDocumentFilter()
    protected NavigationFilter getNavigationFilter()

- test.ui.util.MyDateDocumentFilter.java: getDocumentFilter() of MyDateFormatter class returns instance of this class. It controlls user input. Note: it does not allow user to delete anything.

- test.ui.util.MyDateNavigationFilter.java: getNavigationFilter() of MyDateFormatter class returns instance of this class. It controlls the caret position.

- test.DateTextFieldTest.java: This is the test application to demonstrate use of MyDateTextField.

