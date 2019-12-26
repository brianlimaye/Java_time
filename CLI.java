import java.util.Scanner;
public class CLI
{
	public static void main(String[] args) throws Throwable
	{
		DateCalculator cc = new DateCalculator();
		String s = "";
		Scanner sc = new Scanner(System.in);
		int month = 0;
		int day = 0;
		int year = 0;
		DateInfo ref = null;
		int doW = 0;

			while(!cc.isValidMonth(month))
			{
				loop:
				System.out.println("Please enter a valid month(ex. 3 for March) or q to quit.");
				s = sc.nextLine();

				if(s.equalsIgnoreCase("q"))
				{
					System.exit(1);
				}

				try
				{
					month = Integer.parseInt(s);
					ref = cc.matchCorresponding(month);
				}
				catch(NumberFormatException nfe)
				{
					month = 0;
				}
			}

			
			while(!cc.isValidYear(year))
			{
				System.out.println("Please enter a valid year(AFTER 2018) or q to quit.");
				s = sc.nextLine();

				if(s.equalsIgnoreCase("q"))
				{
					System.exit(1);
				}

				try
				{
					year = Integer.parseInt(s);
				}
				catch(NumberFormatException nfe)
				{
					year = 0;
				}
			}

			while(!cc.isValidDay(month, day, year))
			{
				System.out.println("Please enter a valid day(ex. 25 for twenty-five) or q to quit.");
				s = sc.nextLine();

				if(s.equalsIgnoreCase("q"))
				{
					System.exit(1);
				}

				try
				{
					day = Integer.parseInt(s);
				}
				catch(NumberFormatException nfe)
				{
					day = 0;
				}
			}

		System.out.println();
		System.out.println(month + "/" + day + "/" + year + " is/was on a: " + cc.dowToString(cc.computeDOW(month, day, year, ref)));
		sc.close();
	}
}