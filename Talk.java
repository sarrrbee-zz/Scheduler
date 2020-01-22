/* 
 * Sara Bernstein
 * sgb2137
 * 11/20/17
 * 
 * Talk.java - used to model a talk, provide the title 
 * and/or speaker for a talk along with the start 
 * and stop times of the talk. 
 */

public class Talk implements Comparable<Talk>
{
    private int startTime;
    private int endTime;
    private String speaker;

    public Talk(int st, int et, String name) // constructor 
    {
        startTime = st;
        endTime = et;
        speaker = name;
    }
    
    // method that compares end times of two talks
    public int compareTo(Talk other) 
    {
        if (this.endTime > other.endTime) // this talk ends after other
        {
            return 1; // overlap
        }
        else if (this.endTime < other.endTime) // this talk ends before other 
        {
            return -1; // don't overlap
        }
        else
        {
            return 0; // match up perfectly 
        }
    }
    
    // method that prints talk info 
    public String toString()
    {
        // to account for first digit as 0
        String startTimeInString = Integer.toString(startTime); 
        String endTimeInString = Integer.toString(endTime);
        
        while (startTimeInString.length() < 4)
        {
            String temp = "0" + startTimeInString;
            startTimeInString = temp;
            
        }
        
        while (endTimeInString.length() < 4)
        {
            String temp = "0" + endTimeInString;
            endTimeInString = temp;
        }
        
        String description = speaker + " is from " + startTimeInString + " to " + endTimeInString;
        return description;
    }
    
    // accessor method to get start time
    public int getStartTime()
    {
        return startTime;
    }
    
    // accessor method to get end time
    public int getEndTime()
    {
        return endTime;
    }

}