import java.util.Scanner;

public class DateCalculator
{
	final private DateInfo jan = new DateInfo(1, 17, 2019, 4, 31);
	final private DateInfo feb = new DateInfo(2, 28, 2019, 4, 28);
	final private DateInfo mar = new DateInfo(3, 16, 2019, 6, 31);
	final private DateInfo apr = new DateInfo(4, 1, 2019, 1, 30);
	final private DateInfo may = new DateInfo(5, 28, 2019, 2, 31);
	final private DateInfo jun = new DateInfo(6, 8, 2019, 6, 30);
	final private DateInfo jul = new DateInfo(7, 13, 2019, 6, 31);
	final private DateInfo aug = new DateInfo(8, 1, 2019, 4, 31);
	final private DateInfo sep = new DateInfo(9, 11, 2019, 3, 30);
	final private DateInfo oct = new DateInfo(10, 17, 2019, 4, 31);
	final private DateInfo nov = new DateInfo(11, 3, 2019, 7, 30);
	final private DateInfo dec = new DateInfo(12, 25, 2019, 3, 31);


	public boolean isLeapYear(int year)
	{
		if(year % 4 == 0)
		{
			if(year % 100 == 0)
			{
				if(year % 400 == 0)
				{
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public boolean isValidMonth(int month)
	{
	
		return ((month <= 12) && (month > 0)); 
	}

	public boolean isValidYear(int year)
	{
		return (year > 1582);
	}

	public boolean isValidDay(int month, int day, int year)
	{
		if(month == 2)
		{
			if(isLeapYear(year))
			{
				return ((day > 0) && (day < 30));
			}
			return ((day > 0) && (day < 29));
		}
		return((day > 0) && (day < matchCorresponding(month).getMaxDays()));
	}

	public DateInfo matchCorresponding(int month)
	{
		DateInfo tmp = null;
		
		switch(month)
		{
			case 1:
				tmp = jan;
				break;
			case 2:
				tmp = feb;
				break;
			case 3:
				tmp = mar;
				break;
			case 4:
				tmp = apr;
				break;
			case 5:
				tmp = may;
				break;
			case 6:
				tmp = jun;
				break;
			case 7:
				tmp = jul;
				break;
			case 8:
				tmp = aug;
				break;
			case 9:
				tmp = sep;
				break;
			case 10:
				tmp = oct;
				break;
			case 11:
				tmp = nov;
				break;
			case 12:
				tmp = dec;
				break;
		}
		return tmp;
	}

	public String dowToString(int dOW)
	{

			String s = "";
			switch(dOW)
			{
				case 1:
					s = "Monday";
					break;
				case 2:
					s = "Tuesday";
					break;
				case 3:
					s = "Wednesday";
					break;
				case 4:
					s = "Thursday";
					break;
				case 5:
					s = "Friday";
					break;
				case 6:
					s = "Saturday";
					break;
				case 7:
					s = "Sunday";
					break;
			}
			
			return s;
	}

	//Code works going in the future and past, starting December 25th, 2019.
	public int computeDOW(int month, int day, int year, DateInfo mile)
	{
		int specialCase = -1;
		int currentDay = mile.getDay();
		int currentYear = mile.getYear();
		int targetDay = day;
		int targetYear = year;
		int doW = mile.getDOW();

			
		if(currentYear < targetYear)
		{
			for(int i= currentYear + 1; i <= targetYear; i++)
			{
				if((month != 1) && (month != 2))
				{
					if(isLeapYear(i))
					{
						doW += 2;
					}
					else
				    {
						++doW;
					}
								
					if(doW != 7 && doW > 7)
					{
						doW %= 7;
					}
				}
				else
				{
					if(isLeapYear(i))
					{
						++doW;
						specialCase = 0;
						continue;
					}
					if(specialCase == 0)
					{
						doW += 2;
					    specialCase = -1;
					}	
					else
					{
						++doW;
					}
						
					if(doW != 7 && doW > 7)
					{
						doW %= 7;
					}
				}
			}
		}
		else
		{
			for(int i = currentYear - 1; i >= targetYear; i--)
			{
				
				if(month != 1 && month != 2)
				{
					if(isLeapYear(i+1))
					{
						doW-=2;
					}
					else
					{
						doW--;
					}

					if(doW <= 0)
					{
						doW += 7;
					}
				}
				else
				{
					if(isLeapYear(i))
					{
						doW -=2;
					}
					else
					{
						doW--;
					}

					if(doW <= 0)
					{
						doW += 7;
					}
				}
			}
		}

			
		if(currentDay < targetDay)
		{
			for(int k= currentDay + 1; k<= targetDay; k++)
			{
				++doW;
				if(doW != 7 && doW > 7)
				{
					doW %= 7;
				}
			}
		}
		else
		{
			for(int q=currentDay - 1; q>= targetDay; q--)
			{
				--doW;
				if(doW == 0)
				{
					doW = 7;
				}
			}
		}

		return doW;
	}
}