/********************************************************
*                         TIME                          *
*-------------------------------------------------------*
* -hour: long                                           *
* -minute: long                                         *
* -second: long                                         *
* +Time()                                               *
* +Time(elapseTime: long)                               *
* +Time(hour: long, minute: long, second: long)         *
* +getHour(): long                                      *
* +getMinute(): long                                    *
* +getSecond(): long                                    *
* +setTime(elapseTime: long)                            *
********************************************************/

public class Time {
	
	private long hour;
	private long minute;
	private long second;
	
	// Constructs a Time object for the current time
	public Time(){
		long totalSeconds = System.currentTimeMillis() / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        this.hour = totalHours % 24;
        this.minute = totalMinutes % 60;
        this.second = totalSeconds % 60;
	}
	
	// Constructs a Time object with a specified elapsed time
	public Time(long elapseTime){
		setTime(elapseTime); 
	}
	
	// Constructs a Time object with the specified hour, minute, and second.
	public Time(long hour, long minute, long second){
			this.hour = hour;
			this.minute = minute;
			this.second = second;
	}
	
	// Return Hour
	public long getHour(){
		return hour;
	}
	
	// Return Minute
	public long getMinute(){
		return minute;
	}
	
	// Return Second
	public long getSecond(){
		return second;
	}
	
	// Sets a new time for the object using the elapsed time
	public void setTime(long elapseTime){
		{
			long totalMilliseconds = System.currentTimeMillis();
			
			long totalSeconds = totalMilliseconds / 1000;
			second = totalSeconds % 60;
			
			long totalMinutes = totalSeconds / 60;
			minute = totalMinutes % 60;
			
			long totalHours = totalMinutes / 60;
			hour = totalHours % 24;

			if (elapseTime > 0) {
				totalSeconds = elapseTime / 1000;
				second += totalSeconds % 60;
				
				totalMinutes = totalSeconds / 60;
				minute += totalMinutes % 60;
				
				totalHours = totalMinutes / 60;
				hour += totalHours % 24;
			}
		}
	
	}

}
