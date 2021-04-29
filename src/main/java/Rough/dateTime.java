package Rough;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTime {

	
public static void main(String[] args) {
	
	DateFormat date= new SimpleDateFormat("dd/mm/yyyy hh.mm aa");
	String fileName=date.format(new Date()).toString().replace("/", ".");
	
	System.out.println(fileName);
	
	
	}
}

