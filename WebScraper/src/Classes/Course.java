package Classes;

public class Course {
	public String College;
	public String Number;
	public Course[] Prereq;
	public boolean Required;
	public int Credits;
	
	/**
	 * Default constructor that assigns 3 credit hours to a course.
	 * @param name - the discipline of the course.
	 * @param number - the number associated with the course.
	 * @param prereq - the prerequisites associated with the course.
	 * @param required - whether the course is required of not.
	 */
	public Course(String name, String number, Course[] prereq, boolean required) 
	{
		College = name;
		Number = number;
		Prereq = prereq;
		Required = required;
		Credits = 3;
	}
	
	/**
	 * Default constructor that assigns 3 credit hours to a course.
	 * @param name - the discipline of the course.
	 * @param number - the number associated with the course.
	 * @param prereq - the prerequisites associated with the course.
	 * @param required - whether the course is required of not.
	 * @param creds - how many credit hours does a course require.
	 */
	public Course(String name, String number, Course[] prereq, boolean required, int creds) 
	{
		College = name;
		Number = number;
		Prereq = prereq;
		Required = required;
		Credits = creds;
	}
	
	/**
	 * Add a prerequisite to a course.
	 * 
	 * @param req - the prerequisite to add to the course array.
	 */
	public void addPreReq(Course req)
	{
		Course[] copy = Prereq.clone();
		Prereq = new Course[Prereq.length + 1];
		
		for (int i = 0; i < copy.length; i++)
		{
			Prereq[i] = copy[i];
		}
	}
	
	/**
	 * Prints out a class along with its prerequisites.
	 * 
	 * @param Outside dictates whether or not a course is outside.
	 * @return 
	 */
	public String toString(boolean Outside)
	{
		String output = "";
		
		if(Outside)
		{	
			if (College.equals("*"))
			{
				output = College + ",";
			}
			else
			{
				output = String.format("%s %s,%d,", College, Number, Credits);
			}
			
			output += "\"";
			
			for(Course course: Prereq)
			{
				output += String.format("%s,", course.toString(false));
			}
			output += "\"";
			output += "\n";
		}
		else
		{
			if (College.equals("*"))
			{
				output = College;
			}
			else
			{
				output = String.format("%s %s", College, Number);
			}
		}
		
		return output;
		
	}
	
}
