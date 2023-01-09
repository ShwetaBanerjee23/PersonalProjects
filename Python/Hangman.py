import random
import sys
from pynput import keyboard as kb

class Hangman:
  # Store hangman words.
  WORDS = ["hangman", "multiply", 
           "tangent", "rose", 
           "table", "kitchen", 
           "piano", "angel", 
           "laptop", "happiness"]
  # Store number of wrong turns.
  wrongs = 0
  
  # Display welcome message.
  def welcome(self):
    name = input("Enter a player name: ")
    print(f"\n***\nHello {name}, welcome to this Hangman game!\n***")
  
  # Display the instructions.
  def instructions(self):
    print("The computer will choose a random word. \
The aim of the game is for you to guess the word \
by guessing characters before the drawing is \
complete.\
\n\t* To exit the game at any time, press the up arrow.\
\n\t* To restart the game at any time, press the left arrow.\
\n\t* To view instructions at any time, press the right arrow.\
\nHope you enjoy the game!\n***\n")
  
  # Choose a random word.
  def choose_word(self):
    choice = random.randint(1, len(self.WORDS))
    return self.WORDS[choice - 1]
  
  # Display the word for player to guess.
  def display(self, word, guessed):
    to_display = ""
    for letter in word:
      if letter in guessed:
        to_display += letter.upper() + " "
      else:
        to_display += "_ "
    print(to_display)
  
  # Draw hangman based on number of incorrect guesses.
  def draw_hangman(self):
    if self.wrongs == 1:
      print("              ")
      print("             |")
      print("             |")
      print("             |")
      print("             |")
      print("             |")
    elif self.wrongs == 2:
      print("      --------")
      print("             |")
      print("             |")
      print("             |")
      print("             |")
      print("             |")
    elif self.wrongs == 3:
      print("      --------")
      print("      |      |")
      print("             |")
      print("             |")
      print("             |")
      print("             |")
    elif self.wrongs == 4:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("             |")
      print("             |")
      print("             |")
    elif self.wrongs == 5:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("      |      |")
      print("             |")
      print("             |")
    elif self.wrongs == 6:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("     /|      |")
      print("             |")
      print("             |")
    elif self.wrongs == 7:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("     /|\     |")
      print("             |")
      print("             |")
    elif self.wrongs == 8:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("     /|\     |")
      print("     /       |")
      print("             |")
    elif self.wrongs == 9:
      print("      --------")
      print("      |      |")
      print("      O      |")
      print("     /|\     |")
      print("     / \     |")
      print("             |")
  
  # Return true iff it is the end of the game.
  def is_end_game(self, word, guessed):
    self.draw_hangman()
    for letter in word:
      if letter not in guessed \
      and self.wrongs != 9:
        return False

    if self.wrongs == 9:
      print("Game over...")
    else:
      print("Well done! You guessed it :)")
      self.display(word, guessed)
      
    self.play_again()
    return True
  
  # Check if the player wants to play again.
  def play_again(self):
    answer = input("Would you like to play again? ")
    if answer.lower().startswith("y"):
      self.restart_game()
    else:
      self.quit_game()
  
  # Listen for keyboard inputs, and take necessary action.
  def take_action(self, key):
      if key == kb.Key.up:
        self.quit_game()
      elif key == kb.Key.left:
        self.restart_game()
      elif key == kb.Key.right:
        self.instructions()

  listener = kb.Listener(on_press = take_action)
  listener.start()
  listener.join()
  
  # Listen for Q to quit game.
  def quit_game(self):
    print("Thanks for playing!\n")
    sys.exit()
    
  # Listen for R to restart game.
  def restart_game(self):
    print("Starting again...")
    self.wrongs = 0
    self.play()
  
  # Play the game.
  def play(self):
    word = self.choose_word()
    guessed = list()
  
    while not self.is_end_game(word, guessed):
      self.display(word, guessed)
  
      guess = (input("Enter a guess: ")).lower()
    
      if guess in word:
        guessed.append(guess)
      else:
        self.wrongs += 1

hangman = Hangman()
hangman.welcome()
hangman.instructions()
hangman.play()
