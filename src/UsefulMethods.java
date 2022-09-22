import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UsefulMethods 
{

	public static void main(String[] args) 
	{

	}
	
	public static void databasecode()
	{
		/*
		
		In main method:
		
		final int MAX_DAYS = 31;
		patient[] patientDatabase = new patient[MAX_DAYS];
		int numberEntered = inputPatients(patientDatabase);
		printdetails(patientDatabase, numberEntered);
		
		Creating a Database which holds 31 patient arrays
		
		
		createPatient()
		Consist of creating an array adding the values to the variables stored in array
		
		inputPatients()
		
		printdetails()
		Print the details of the patient by calling the getter methods
		
		*/
	}
	
	public static int randomNumber(int upto)
	{
		int rand = (int)(Math.random() * upto);
		return rand;
	}
	
	public static String print(String message) 
	{
		System.out.print(message);
		return message;
	}
	
	public static String println(String message) 
	{
		System.out.println(message);
		return message;
	}
	   
	public static String inputString(String message) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		String answer = scanner.nextLine();
		return answer;
	}
	   
	public static int inputInt(String message) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		int answer = Integer.parseInt(scanner.nextLine());
		return answer;
	}
	
	public static double inputDouble(String message) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		double answer = Double.parseDouble(scanner.nextLine());
		return answer;
	}
	
	//Read a file in, displaying it line by line on the screen.
	public static void readFile() throws IOException 
	{
		BufferedReader inStream = new BufferedReader(new FileReader("in.txt"));
	 
	    String nextword = inStream.readLine();

	    // Repeatedly check the current word and write it to the output file if not null
	    while (nextword != null)
	    {
	        System.out.println(nextword);
	        nextword = inStream.readLine();
	    }

	    inStream.close();
	}
	
	//Print the elements in an array into a file
	public static void printFile() throws IOException 
    {
        PrintWriter outputStream = new PrintWriter(new FileWriter("mydata2.txt"));

        int NumberofNames = 3;
        outputStream.println(NumberofNames);
        
        String [] names = {"Paul", "Jo", "Mo"};
            
        for (int i = 0; i < names.length; i++)
        {
                outputStream.println(names[i]);
        }
        
        outputStream.close();
    }
	
	//It copies a line from one file to another
	public static void copyFile() throws IOException 
	{
		BufferedReader inStream = new BufferedReader(new FileReader("myindata2.txt"));
	    PrintWriter outStream = new PrintWriter(new FileWriter("myoutdata2.txt"));
	        
	    String line = inStream.readLine();
	    while(line != null)
	    {
	        System.out.println(line); //echo to screen too
	        outStream.println(line);
	        line = inStream.readLine();
	    }
	    
	    inStream.close();
	    outStream.close();	   
	}
	
	public static void bubblesort (int[] array)
    {
        boolean sorted=false;

        while (!sorted)
        {
	       // array potentially sorted 
            sorted = true;
            
	       //traverse array to end switching ill-ordered pairs
	       for (int i=0; i < array.length-1; i++)
	       {
                if (array[i] > array [i+1])
                {
		          // swap them
		          int tmp = array[i+1];
		          array[i+1] = array[i];
		          array[i] = tmp;
		          // array wasn't sorted
		          sorted = false;
		         }
	       }
	    }
    }
	
	//Goes with quicksort
	public static String printarray (int[] array) 
    {
       String txt = "";
       for (int i=0; i < array.length-1; i++) 
       {
         txt = txt+array[i]+" ";
	   }
	   if (array.length > 0) txt = txt+array[array.length - 1];

	   return txt;
    }
	
	static void quicksort (int[] array, int from, int upto) 
    {
        // print details of call
        print("calling qs ("+printarray(array)+", "+from+", "+upto+")");

        if (from < upto)
        {
          // make the pivot value middle of array
          int pivot = array[(from+upto)/2];

          // set up two pointers into the array
          int lower = from, upper = upto;
        
          while (lower <= upper) 
          {
            // first move lower up over small elements
	 	    while ((array[lower] < pivot) && (lower < upto)) { lower++; }
	 	  
            // otherwise move upper down over large elements
		    while ((array[upper] > pivot) && (upper > from)) { upper--; }
		
            // if pointers haven't crossed
            if (lower <= upper) 
            {
		      int tmp = array[upper];
		      array[upper] = array[lower];
		      array[lower] = tmp;
		      lower++;
		      upper--;
		    }
	      }

          print("doing qs(..,., "+from+", "+upto+") with current "+printarray(array));

	     if (from < upper) quicksort(array,from,upper);
	     if (lower < upto) quicksort(array,lower,upto);

	    }
	    print("leaving qs (..., "+from+", "+upto+") with result "+printarray(array));

    }
	
	 public static void recursion(int n) 
	    {
	       print("Entering.." + n);
	       if (n==0)
	       {
	         print("Leaving .." + n);
	         return; // base case
	       }
	       else
	       {
	         print("Do some work .." + n);
	         recursion(n-1); // step case
	       }
	       
	       print("Leaving .." + n);
	    }
	
	
	
	

}
