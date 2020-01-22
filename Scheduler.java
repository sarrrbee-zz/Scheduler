/* 
 * Sara Bernstein
 * sgb2137
 * 11/20/17
 * 
 * Scheduler.java - has static methods used to 
 * make and schedule talks 
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;

public class Scheduler
{
    // takes input from file and creates Talk objects 
    // makes and returns ArrayList of Talk objects
    public static ArrayList<Talk> makeTalks(String file) 
        throws IOException
    {
        ArrayList<Talk> talks = new ArrayList<Talk>(); // make empty list 
        File inFile = new File(file); 
        Scanner input = new Scanner(inFile);
        
        try
        {
                while (input.hasNextLine())
                {
                    String name = input.next(); // get name from line
                    String start = input.next(); // get start time from line
                    int startTime = Integer.parseInt(start); // convert to int
                    String end = input.next(); // get end time from line
                    int endTime = Integer.parseInt(end); // convert to int
                
                    // account for invalid times
                    if (endTime < startTime || endTime > 2359 || startTime > 2359
                       || startTime % 100 > 59 || endTime % 100 > 59)
                    {
                        System.out.println("Sorry, there was an error of an invalid time.");
                    }
                    else
                    {
                        Talk oneTalk = new Talk(startTime, endTime, name);
                        talks.add(oneTalk);
                    } 
                }
        }
        
        catch (NumberFormatException nf)
        {
            System.out.println("Sorry, your times are not formatted correctly.");
            talks = new ArrayList<Talk>();
            return talks;
        }
        catch (NoSuchElementException ns)
        {
            System.out.println("Sorry, there was an issue when calling an element");
            talks = new ArrayList<Talk>();
            return talks;
        }
        finally
        {
            input.close();
            return talks;
        }
    }
    
    // schedules the maximum amount of non-overlapping 
    // Talks from the list 
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks)
    {
        // sort list in ascending order
        // according to end time 
        Collections.sort(talks);
        
        ArrayList<Talk> scheduled = new ArrayList<Talk>();
        int index = 0;
        if (talks.size() > 0) // make sure list is not empty 
        {
            scheduled.add(talks.get(0)); // add first
            
            for (int i = 1; i < talks.size(); i++)
            {
                Talk current = talks.get(i);
                Talk compare = scheduled.get(index);
                
                // check for overlap
                if (compare.getEndTime() <= current.getStartTime()) 
                {
                    scheduled.add(current);
                    index++;
                }
            }
        }
        
        return scheduled;   
    }
  
}
