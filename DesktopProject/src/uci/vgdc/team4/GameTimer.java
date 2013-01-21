package uci.vgdc.team4.timer;


public class GameTimer
{
	private float time; //Time in seconds.
	private TimerStates state = TimerStates.STOPPED; //The current state of the timer.
	
	/* Constructor */
	
	/**
	 * A timer that will count down will started stop once all the time given to it has elapsed.
	 * <p>
	 * Can give indication of whether it is paused or finished.
	 * 
	 * @param time the time (in seconds) that the timer will start at.
	 */
	public GameTimer(float time)
	{
		this.setTime(time);
	}//END Timer
	
	/* Time */
	// Set	
	/**
	 * Sets the time of the timer and then sets the state to paused.
	 * 
	 * @param time the time (in seconds) to set the timer at.
	 */
	public void setTime(float time)
	{
		this.time = time;
		this.pause();
	}//END setTime
	
	// Math	
	/**
	 * Adds time to the current time of the timer.
	 * 
	 * @param time the time (in seconds) to add to the current time of the timer.
	 */
	public void addTime(float time)
	{
		this.time += time;
	}//END addTime
	
	/**
	 * Subtracts time of the current time of the timer.
	 * 
	 * @param time the time (in seconds) to subtract with the current time of the time.
	 */
	public void subTime(float time)
	{
		this.time -= time;
		
		//Timer should not go below zero.
		if(this.time <= 0)
		{
			this.time = 0;
			this.state = TimerStates.FINISHED;
		}//fi
	}//END subTime
	
	/* Get */
	/**
	 * Gets The current time as a string.
	 * 
	 * @returns current time.
	 */
	public String time()
	{
		int seconds = this.time_seconds();
		return (seconds / 60 + ":" + seconds % 60 / 10 + seconds % 60 % 10);
	}//END time
		
	/**
	 * Returns the current time of the timer in seconds.
	 */
	public int time_seconds()
	{
		return (int)this.time;
	}//END time_seconds
	
	/* State */
	// Start and Stop	
	/**
	 * Starts the timer.
	 */
	public void start()
	{
		this.state = TimerStates.RUNNING;
	}//END start
	
	/**
	 * Pauses the timer.
	 */
	public void pause()
	{
		this.state = TimerStates.STOPPED;
	}//END pause
	
	// Check
	/**
	 * Checks to see whether the timer is paused or not.
	 * 
	 * @return true if timer is paused, false if it is not.
	 */
	public boolean isPaused()
	{
		if(this.state == TimerStates.STOPPED)
		{
			return true;
		}//fi
		//else...
		return false;
	}//END isPaused
	
	/**
	 * Checks to see whether the timer is finished or not.
	 * 
	 * @return true if timer is finished, false if it is not.
	 */
	public boolean hasFinished()
	{
		if(this.state == TimerStates.FINISHED)
		{
			return true;
		}//fi
		//else...
		return false;
	}//END hasFinished
	
	/* Update */
	/**
	 * Updates the timer by taking the difference of the current time and the time that has passed.
	 * 
	 * @param dt the difference in time.
	 */
	public void update(float dt) //DT in seconds.
	{
		if (this.state == TimerStates.RUNNING)
		{
			this.subTime(dt);
		}//fi
	}//END update
}//END class Timer

//EOF
