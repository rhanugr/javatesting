package test;
import java.text.SimpleDateFormat;
import java.util.Date;



public class RanomNum
{
	
	public static long random(long RN)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());		
		RN = Long.parseLong(timeStamp);
		return RN;		
	}
	
}
