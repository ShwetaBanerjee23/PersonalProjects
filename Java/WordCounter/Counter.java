import java.util.*;

/* Use WordCounter.java to count the number of characters, words, and
 * sentences in some user-given text. */
public class Counter {
  public static void main(String[] args) {
    // Take text input.
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter text: ");
    String text = scanner.nextLine();
    scanner.close();

    // Count characters, words, sentences in text.
    WordCounter counter = new WordCounter(text);
    int charsNoSpace = counter.countCharsWithoutSpaces();
    int charsSpace = counter.countCharWithSpaces();
    int words = counter.countWords();
    int sentences = counter.countSentences();

    // Display counts.
    System.out.println("Characters, without spaces: " 
                       + String.valueOf(charsNoSpace));
    System.out.println("Characters, with spaces: " 
                       + String.valueOf(charsSpace));
    System.out.println("Words: " 
                       + String.valueOf(words));
    System.out.println("Sentences: " 
                       + String.valueOf(sentences));
    
  }
}
