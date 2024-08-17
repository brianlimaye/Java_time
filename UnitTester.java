import java.util.Calendar;
import java.util.Date;

public class UnitTester
{
	public static void main(String[] args)
	{
		final DateCalculator cc = new DateCalculator();

		//Chris is good at golf
		final Calendar cal = Calendar.getInstance();
		Date d;
		int month = 0;
		int day = 0;
		int year = 0;
		int doW = 0;
		int myDOW = 0;
		cal.add(Calendar.YEAR, -435);

		for(int i=0; i< 159506; i++)
		{
			cal.add(Calendar.YEAR, 1);
			d = cal.getTime();
			day = cal.get(Calendar.DAY_OF_MONTH);
			month = cal.get(Calendar.MONTH) + 1;
			year = cal.get(Calendar.YEAR);
			doW = cal.get(Calendar.DAY_OF_WEEK);

			myDOW = cc.computeDOW(month, day, year, cc.matchCorresponding(month));

			if(myDOW != doW - 1 && Math.abs(myDOW - doW) != 6)
			{
				System.out.println("ERROR, DAY OF WEEKS DO NOT MATCH UP....");
				System.out.println(month + "/" + day + "/" + year + " does not work");
				System.exit(1);
			}
			cal.add(Calendar.DATE, 1);
		}
	}
}
