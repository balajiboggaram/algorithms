package me.learn.personal.month7;
import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// Main class should be named 'Solution'
class UberSolution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        UberSolution solution = new UberSolution();
        
        solution.doTest("NULL MESSAGE", null, 20);
 
        solution.doTest("EMPTY MESSAGE", "", 20);
        solution.doTest("length limit not reached", "This is uber interview going for security position", 1000);
        solution.doTest("initial example", "Hey     Joe, your Uber is arriving now!", 20);

        solution.doTest("silly message", "a1 b2 c3 d4 e5", 3); // works
        solution.doTest("silly message", "a1 b2 c3 d4 e5", 2); // times out
    }

    public  void doTest(String testName, String input, int limit) {
        System.out.println("***** " + testName + " with limit = " + limit);
        
        List<String> result = splitMessage(input, limit);
        printResult(result);
    }
    
    public static void printResult(List<String> result) {
        for (String s: result) {           
          System.out.println(s.length() + " >" + s +"<"); 
       }
    }

/*
Intro: Pick any language you want. Compile/run as many times as you want, no penalty for syntax errors.
Share your screen, or, ask me any questions you would normally lookup up, I'm happy to search Internet for you. I don't expect you've memorized entire standard library, for example. :)

Part 1: Given a string of arbitrary length and a constant character limit, break the string into an iterable such that words are preserved but no string is greater than the character limit. For example, CHAR_LIMIT = 20 and 

Example 1 : "Hey Joe, your Uber is arriving now!" should become
-01234567890123456789012345678901234
["Hey Joe, your Uber", "is arriving now!"] // represents the desired output
--012345678901234567----0123456789012345 // not part of the desired output
Example 2 : "Restaurant has received your order and is preparing your food now."

Return an "iterable" meaning whatever data type is appropriate for multiple strings in your language of choice e.g. array, list, vector, or slice. 
*/

public List<String> splitMessage(String text, int limit) {
  
  List<String> result = new ArrayList<String>();
  
  if(text == null) return result;
  
  String[] words = text.split("\\s+");
  int currentLength = -1;
  int start = 0;
  int count = -1;
  for(int i =0;i<words.length;i++) {
    if(currentLength + words[i].length() +1 < limit) {
        // can add more words
        currentLength = currentLength + words[i].length() + 1;
        count++;
    } else {
        // limit reached
        process(words, start, i-1, currentLength, count, result, limit, false);
        start = i;
        i--;
        currentLength  = -1;
        count =-1;
    }
  }  
  process(words, start, words.length -1, currentLength, count, result, limit, true);
  return result;   
} 

// count -> number of words to add
// start -> word start to append
// end -> word end to append until

void process(String[] words, int start, int end, int currentLength, int count, List<String> result, int limit, boolean isLast) {
    
    int spaces = limit - currentLength;
    spaces += count;
    int same = isLast || count == 0 ? 0 : spaces/count;
    StringBuilder curResult = new StringBuilder();
    same =1;

    while(start <= end) {
        
        curResult.append(words[start]);
                
        // treat with spaces
        for(int k = 0; k< same && start != end ;k++) {
            curResult.append(' ');
        }
        start++;
    }   
    result.add(curResult.toString());
}

}