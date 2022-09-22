/* 
 ChatBot program
 Write a chat bot procedural program that can have realistic conversations with people about a specific topic 
 Author name: Joseph Da Costa
 Student ID: 210295748
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Class created containing 3 fields that hold string later to be used in code
class TriggerResponse
{
	//2 String arrays initialised and declared which will hold the trigger responses
	String [] targetwords = {"Doing well", "Feeling good", "Everything is fine", "Not too bad", "Yeah, all right", 
			                 "Computers are awesome", "It is amazing", "It's annoying", "That is bewildering", "A waste of money", 
			                 "Horror", "Action", "Fiction", "Novel", "Drama"};
	
    String [] responses = {"Lovely to hear from you!", "I am also feeling good", "I'm fine too!", "I'm not too bad as well", "Cmon, be a bit more enthusiastic!",
    		               "Same here!", "Yep!", "I feel the opposite", "I am also astonished", "I don't think so..",
    		               "I never watch them as they terrify me",
                           "I'm a big fan of James Bond 007",
                           "I believe that Fiction is much better than non-Fiction",
                           "Novels narrate intimate human experiences",
                           "I'm not into drama unfortunately"};
    
    //An Int array initialised and declared which will hold the usefulness scores of the trigger responses
    int[] Usefulness_Score = {2,3,1,5,3,3,1,2,5,4,2,4,2,1,3};
    
}

//3 classes combined into a database class
class TriggerResponseIntroduce
{
	//2 String arrays initialised and declared which will hold the trigger responses
	String [] targetwords = {"Doing well", "Feeling good", "Everything is fine", "Not too bad", "Yeah, all right"};
	
	String [] responses = {"Lovely to hear from you!", "I am also feeling good", "I'm fine too!", "I'm not too bad as well", "Cmon, be a bit more enthusiastic!"};
	
	//An Int array initialised and declared which will hold the usefulness scores of the trigger responses
	int[] Usefulness_Score = {2,3,1,5,3};
}

class TriggerResponseInterest
{
	//2 String arrays initialised and declared which will hold the trigger responses
	String [] targetwords = {"Computers are awesome", "It is amazing", "It's annoying", "That is bewildering", "A waste of money"};
	
	String [] responses = {"Same here!", "Yep!", "I feel the opposite", "I am also astonished", "I don't think so.."};
	
	//An Int array initialised and declared which will hold the usefulness scores of the trigger responses
	int[] Usefulness_Score = {3,1,2,5,4};
	
}

class TriggerResponseFilm
{
	//2 String arrays initialised and declared which will hold the trigger responses
	String [] targetwords = {"Horror", "Action", "Fiction", "Novel", "Drama"};
	
	String [] responses = {"I never watch them as they terrify me",
                           "I'm a big fan of James Bond 007",
                           "I believe that Fiction is much better than non-Fiction",
                           "Novels narrate intimate human experiences",
                           "I'm not into drama unfortunately"};
	
	//An Int array initialised and declared which will hold the usefulness scores of the trigger responses
	int[] Usefulness_Score = {2,4,2,1,3};
}

//Database class which holds all the trigger Responses
class TriggerResponseDatabase
{
	TriggerResponse[] triggerResponses; 
}

//Questions class which will be used to print questions to the user
class Questions
{
	String[] questions = {"What type of movies do you watch?",
                          "What do you think about Cryptocurency?",
                          "What is your least favourite genre of movies?",
                          "What are your plans for tomorrow?",
                          "Are you busy the week?",
                          "How are you feeling today?",
                          "How are your family doing?",
                          "Did you hear about NASA implementing Quantum computing?",
                          "What do you think about the affect of Quantum computing on Technology?",
                          "What was the genre of the latest movie you watched",
                          "How is Covid affecting you?",
                          "Are you free tomorrow?",
                          "Are you into games?",
                          "What are your thoughts on the Avengers: Endgame movie?",
                          "Do you like reading books?",
                          "What is your favourite genre of movies?",
                          "What was your favourite subject in School?"};
}

public class MiniProject_lvl8 
{

	public static void main(String[] args) throws IOException
	{
		//Calling the main method that calls the other methods
		myChatBot();
	}
	
	//introduce method will ask the user a question and will output an answer from the class
    public static void introduce(TriggerResponseDatabase d, Questions q) throws IOException 
	{
    	//A line is printed to the screen and the output from it is saved in the variable ans
    	String ans = inputString("Hello, my name is ChatBot\nHow are you today?");
    	
    	//A method is called which takes in 3 arguments (2 classes and a variable)
    	AskTheQuestions(d, q, ans);
	}

    //interest method will ask the user a question and will output an answer from the class
	public static void interest(TriggerResponseDatabase d, Questions q) throws IOException
	{
		//A line is printed to the screen and the output from it is saved in the variable ans
		print("I am very interested in Quantum Computer science");
		String ans = inputString("What do you think about computers using quantum physics to store data and perform computations");
		
		//A method is called which takes in 3 arguments (2 classes and a variable)
		AskTheQuestions(d, q, ans);
	}
	
	//film method will ask the user a question and will output an answer from the class
    public static void film(TriggerResponseDatabase d, Questions q) throws IOException
    {
    	//A line is printed to the screen and the output from it is saved in the variable ans
        String ans = inputString("What is your favourite kind of film?");
        
        //A method is called which takes in 3 arguments (2 classes and a variable)
        AskTheQuestions(d, q, ans);
    }

    //Prints a line saying goodbye to the user
	public static void goodbyeMessage()
	{
		print("Oops, I have to go now. I've enjoyed talking with you. Goodbye\n");
	    return;
	}
	
	//Main Method	
	public static void myChatBot() throws IOException
	{
		//TWlength obtains the value of the length of the TargetWord array
		final int arraySize = 50;
		
		//A new TriggerResponseDatabase and Questions value is created storing it in a variable called d and q respectfully
		TriggerResponseDatabase d = createTriggerResponseDatabase(arraySize);
		Questions q = new Questions();
		
		//Creating the Questions record
		Questions q1 = initialQRecord(getQuestions(q));
		
		//This loop will infinitely depending on output of user
		while(true) 
		{
			introduce(d, q1);
			interest(d, q1);
			film(d, q1);
		    goodbyeMessage();
		}
	}
			
	//Will ask questions to the user
	public static void AskTheQuestions(TriggerResponseDatabase d, Questions q, String ans) throws IOException
	{
		//If the answers back with a Goodbye message the system terminates
        endProgram(ans);
        
        //Will print a line to the screen to the corresponding output from the user
        boolean wordFound = findTriggerResponseInDatabase(d, ans);
        if(!wordFound) wordNotFound(d, q, wordFound, ans);
        
        //Method called taking the questions class as an argument
        askMoreQuestions(q, d);
	}
    
	//Will ask extra questions to the user
    public static void askMoreQuestions(Questions q, TriggerResponseDatabase d) throws IOException
    {
    	//TRlength obtains the value of the length of the Questions array
    	final int QLength = getQuestions(q).length;
    	
    	// 2 questions from the class is printed to screen
    	for(int i=0; i<2; i++)
    	{
    		//A number is picked at random using Math.Random from 0 to the length of the question array and will print the question
    		int r = (int) (Math.random()*QLength);
         	String word = inputString(getQuestions(q)[r]);
         	
         	//If the answers back with a Goodbye message the system terminates
         	endProgram(word);
         	
         	//Will print a line to the screen to the corresponding output from the user
         	boolean wordFound = findTriggerResponseInDatabase(d, word);
            if(!wordFound) wordNotFound(d, q, wordFound, word);
         	
         	//Will print a line to the screen for the second question
         	if(i==1) print("That's interesting...");
    	}
    }
    
    //This method will ask the user a question from the question array if a word is not matched in the matchResponse method
    public static void wordNotFound(TriggerResponseDatabase d, Questions q, boolean wordFound, String word) throws IOException
    {
    	
    	//A new triggerResponse value is created storing it in a variable called t
    	TriggerResponse t = new TriggerResponse();
    	//Creating the triggerResponse record
		TriggerResponse t1 = initialTRRecord(getTargetWord(t), getResponses(t));
		
		//TWlength obtains the value of the length of the TargetWord array
		final int TWLength = getTargetWord(t1).length;
    	
		//Will loop infinitely until a word is found
    	while(!wordFound)
    	{
    		//A number is picked at random using Math.Random from 0 to the length of the question array and will print the question
    		int r = (int) (Math.random()*TWLength);
         	word = inputString(getQuestions(q)[r]);
         	
         	//If the answers back with a Goodbye message the system terminates
         	endProgram(word);
         	//if the answer doesn't match again, it will keep on looping until a match is found
         	wordFound = findTriggerResponseInDatabase(d, word);
    	}
    }
    
    // An initialise method that creates the TriggerResponseDatabase record
    public static TriggerResponseDatabase createTriggerResponseDatabase (int SIZE) throws IOException
    {
    	TriggerResponseDatabase d = new TriggerResponseDatabase();
    	TriggerResponse t = new TriggerResponse();
    	
    	//The values stored in the Usefulness_Score file will added into an array called scores
		int[] scores = ReadFromU_STxt();
		
    	//Sort array method called to so that more useful trigger words are checked first
    	sortArray(scores, getResponses(t), getTargetWord(t));

    	TriggerResponse[] a = new TriggerResponse[SIZE];
    	
    	//Database will hold the necessary classes
    	a = new TriggerResponse[] {t};
 
        d.triggerResponses = a;
        
        return d;
    }
    
    //Takes in 2 arguments to match a word to a String
    public static boolean findTriggerResponseInDatabase(TriggerResponseDatabase d, String word) throws IOException
    {
  		//TRlength obtains the value of the length of the TriggerResponse array
  		final int TRLength = getTriggerResponses(d).length;
  		
  		//Declare and initialise a variable called wordFound
      	boolean wordFound = false;
      	
      	//Will loop as many times as the length of the TriggerResponse array in the Database class
      	//This loop looks for the answer matching and print the linked response back
          for(int i=0; i < TRLength; i++)
          {
          	TriggerResponse t = getTriggerResponseFromDatabase(d, i);
          	
          	//TWlength obtains the value of the length of the TargetWord array
      		final int TWLength = getTargetWord(t).length;
          	
          	for(int j = 0; j<TWLength; j++)
          	{      		
          		if (word.equals(getTargetWord(t)[j]))       	
              	{
      	           System.out.println(getResponses(t)[j]);
      	           //If a word is found the increment method is called taking the word as an argument
      	           incrementScore(word);
      	           //If a word is matched then wordFound is set to true
      	           wordFound =  true;
      	        }
          		
          		if(wordFound) break;
          	
          	}
          	
          	
          }
          
          //If a word is not found this method is called
          if(!wordFound)
          {
          	PrintToN_WTxt(word);
          }

          return wordFound;
    }
	
    // An initialise method that creates the TriggerResponse record
	public static TriggerResponse initialTRRecord(String[] targetWords, String[] responses)
	{		
		TriggerResponse t = new TriggerResponse();
		
		t.targetwords = targetWords;
		t.responses = responses;

	    return t;
	}
	
	// An initialise method that creates the Questions record
	public static Questions initialQRecord(String[] questions)
	{		
		Questions q = new Questions();
		
		q.questions = questions;


	    return q;
	}
	
	//Sort method from Paul recurzon's bubble_sort2 program code
	//Method thats sorts an array from Largest to smallest score
	public static void sortArray(int[] scoreArray, String[] targetArray, String[] responseArray)
	{
		boolean sorted = false;
		
		//If array is not sorted while loop will carry on until sorted
		while(!sorted)
		{
			//Assume array is sorted but if the if statement is branched then array is not sorted
			sorted = true;
			
			//Will loop as many times as the length of the array
			for(int i=0; i < scoreArray.length-1; i++)
			{
				//traverse array switching ill-ordered pairs
				if(scoreArray[i+1] > scoreArray[i])
				{
					//Swaps the elements
					int temp1 = scoreArray[i+1];
					scoreArray[i+1] = scoreArray[i];
					scoreArray[i] = temp1;
					
					String temp2 = targetArray[i+1];
					targetArray[i+1] = targetArray[i];
					targetArray[i] = temp2;
					
					String temp3 = responseArray[i+1];
					responseArray[i+1] = responseArray[i];
					responseArray[i] = temp3;
					
					// array wasn't sorted
					sorted = false;
				}
			}
			
		}
	}
	
	//This method reads and stores the values in the Usefullness_Score file into an array called scores and is returned
	public static int[] ReadFromU_STxt() throws IOException
	{
		BufferedReader inputStream = new BufferedReader(new FileReader("Usefulness_Score.txt"));
		
		//An array is declared and initialised with a length of 15
		int [] scores = new int[15];
		
		for(int i=0; i<scores.length; i++)
		{
			//s holds the value of the nest line and saved in the corresponding element
			int s = Integer.parseInt(inputStream.readLine());
			scores[i] = s;
			
		}	
		
		inputStream.close();
		
		return scores;
	}
    
	//This method stores the values in an array back to the Usefullness_Score file
    public static void PrintToU_STxt(int[] scoreArray) throws IOException
	{
		PrintWriter outputStream = new PrintWriter(new FileWriter("Usefulness_Score.txt"));
			
		for(int i=0; i<scoreArray.length; i++)
		{
			outputStream.println(scoreArray[i]);
		}
		
		
		outputStream.close();
	}
    
    //This method adds the value of the argument in the next line of the New_Words file
    public static void PrintToN_WTxt(String word) throws IOException
	{
		PrintWriter outputStream = new PrintWriter(new FileWriter("New_Words.txt", true));
		
		//Append method stops overwriting
		outputStream.append(word);
		outputStream.println();
		
		outputStream.close();
	}
	
    //This method is called when a trigger word is found
    //When a trigger Word is found, the usefulness score increments by 1
	public static void incrementScore(String word) throws IOException
	{
    	TriggerResponse t = new TriggerResponse();
    	
    	//An array is declared and initialised which holds the values in the Usefullness_Score file as an array
    	int[] scores = ReadFromU_STxt();
    	
    	int num = 0;
    	
    	//For loop finds which element the trigger word is in the scores array
    	for(int i=0; i<scores.length; i++)
    	{
    		if(getTargetWord(t)[i].equals(word))
    		{
    			num = i;
    			break;
    		}
    	}
    	
    	scores[num] = scores[num] + 1;
    	PrintToU_STxt(scores);
	}
	
	//If user types Goodbye or Got to go at any time, the system will terminate
    public static void endProgram(String message) 
    {
    	if(message.equals("Goodbye") || message.equals("Got to go")) 
		{
			System.exit(0);
		}
    }
	
    //Getter methods are set
	public static String[] getTargetWord(TriggerResponse t)
	{
		return t.targetwords;
	}
	public static String[] getResponses(TriggerResponse t)
	{
		return t.responses;
	}
	public static int[] getUseful_Score(TriggerResponse t)
	{
		return t.Usefulness_Score;
	}
	public static String[] getQuestions(Questions q)
	{
		return q.questions;
	}
	
	public static TriggerResponse[] getTriggerResponses(TriggerResponseDatabase d)
    {
    	return d.triggerResponses;
    }
    
    public static TriggerResponse getTriggerResponseFromDatabase(TriggerResponseDatabase d, int position)
    {
    	TriggerResponse [] a = getTriggerResponses(d);
    	TriggerResponse t = a[position];

     return t;
    }
	
    //Instead of writing System.out.println, print can be used instead
	public static String print(String message) 
	{
		System.out.println(message);
		return message;
	}
	
	//Method that prints a string and saves the response all in 1 line
    public static String inputString(String message)
    {
       Scanner scanner = new Scanner(System.in);
       System.out.println(message);
       String answer = scanner.nextLine();
   
       return answer;
    }
}

