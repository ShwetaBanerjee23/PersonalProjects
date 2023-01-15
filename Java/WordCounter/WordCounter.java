class WordCounter {
  private final String text; /* The text to process. */

  public WordCounter(String text) {
    this.text = text;
  }

  /* Split the text into words. */
  private String[] breakIntoWords() {
    return text.split(" ");
  }

  /* Count the number of characters in the text, 
   * excluding spaces. */
  public int countCharsWithoutSpaces() {
    int chars = 0;
    
    for (String word : this.breakIntoWords()) {
      chars += word.length();
    }

    return chars;
  }

  /* Count the number of characters in the text, 
   * including spaces. */
  public int countCharWithSpaces() {
    return text.length();
  }

  /* Count the number of words in the text. */
  public int countWords() {
    return this.breakIntoWords().length;
  }

  /* Count the number of sentences in the text. */
  public int countSentences() {
    return text.split("\\.").length;
  }
}
