package rocks.raja.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextPane;

public class Debug {

	JTextPane output;
	
	public Debug(JTextPane output) {
		this.output = output;
	}
	
	public void Log(String string, String from) {
		output.setText(output.getText() + "\n\r" + getTimeStamp() + " : [" + from + "]" + ' ' + string);
	}
	
	public void Error(String string) {
		output.setText(output.getText() + "\n\r" + getTimeStamp() + " : [" + "STDERR" + "]" + " " + string);
	}
	
	public void textRaw(String string) {
		output.setText(output.getText() + "\n\r" + string);
	}
	
	private String getTimeStamp() {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date dateobj = new Date();
		return "[" + df.format(dateobj) + "]";
	}
}
