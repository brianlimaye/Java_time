public class DateInfo
{
	private int month;
	private int day;
	private int year;
	private int doW;
	private int maxDays;

	public DateInfo(int month, int day, int year, int doW, int maxDays)
	{
		this.month = month;
		this.day = day;
		this.year = year;
		this.doW = doW;
		this.maxDays = maxDays;
	}

	public DateInfo(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}

	public int getYear()
	{
		return year;
	}

	public int getDOW()
	{
		return doW;
	}

	public int getMaxDays()
	{
		return maxDays;
	}
}