# Scheduler - Class Project Instructions:

Imagine you are a conference organizer and you are tasked with scheduling the largest possible subset from a set of talks all in the same room. Each talk in the set has a given start time and end time. These times cannot change. No talks that have times that overlap can be scheduled in the same room. For the sake of this assignment assume that one talk can begin instantly upon completion of the previous talk. Consider the example below with three talks in the set:

**Talks:**

1. Fred Flinstone 9:00AM-11AM
2. Barney Rubble 10:30AM-4PM
3. Bam Bam Rubble 1PM-1:15PM

The optimal schedule (the one that schedules the most talks) in this example would be to schedule Fred's talk and Bam Bam's talk. **Note:** Optimal does *NOT* mean the room is used for the longest time, it means the greatest possible number of talks are scheduled.

***This Assignment***  
*Step 1:* Come up with an algorithm that will lead to scheduling the greatest number of talks.  
*Step 2:* Implement your algorithm in Java using the design outline below.  

Included on Codio is a file containing a list of 50 talks along with their start and end times. I used a 24 hour time format to make this a little easier. Your application must read a file in this format and schedule the maximium number of talks that can be scheduled in a single room. To do this write the following two classes:

1. Talk.java- This class is used to model a talk and may be used to provide the title and/or speaker for a talk along with the start and stop times of the talk. This class should implement the Comparable interface.

2. Scheduler.java - This class will serve as a repository for static methods that you will use to schedule the talks. 

Included on Codio is a test class, ScheduleTest.java. Your code *must* work with our tester. 
