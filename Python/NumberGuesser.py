import random

class NumberGuesser:
  # The range to choose a random number from.
  max_value = 100

  # Ensure the maximum value chosen is of the correct form.
  def format_max_value(self, value):
    # Should not be empty.
    if value == "":
      print("EmptyInputError: Expected an input.\n")
    # Should be a whole number.
    elif not value.isdigit():
      print("InputError: Expected integers only, \
found non-integer value.\n")
    # Should be between 0 and 1000 (inclusive).
    elif int(value) < 0 or int(value) > 1000:
      print("RangeError: Expected a value between 0 and ", 
            1000, ".\n")
    else:
      return True
    return False

  # Ask the player for maximum value.
  def determine_max_value(self):
    print("You can choose the range of values to generate \
a random number from, the default is 100. Enter a value \
greater than 10 to change the default.\n")
    max_value = input("Enter the maximumg value: ")

    while not self.format_max_value(max_value):
      max_value = input("Enter the maximum value: ")

    if int(max_value) > 10:
      self.max_value = int(max_value)

  # Display instructions to play the game.
  def instruction(self):
    print(f"Hello and welcome to the Number Guessing game! \
\nThe computer will randomly generate a number between 0 and \
{self.max_value} (inclusive), and you have to guess the number. \
You will have 5 tries and the computer will tell you whether \
your guess is too low or too high or on point.\n")

  # Choose a random number between 0 and the max_value chosen.
  def choose_number(self):
    return random.randint(0, self.max_value)

  # Ensure guess entered is in correct format.
  def format_input(self, guess):
    # Should not be empty.
    if guess == "":
      print("EmptyInputError: Expected an input.\n")
    # Should be an integer.
    elif not guess.isdigit():
      print("InputError: Expected integers only, \
found non-integer value.\n")
    # Should be between 0 and the maximum value chosen.
    elif int(guess) < 0 \
      or int(guess) > self.max_value:
      print("RangeError: Expected a value between 0 and ", 
            self.max_value, ".\n")
    else:
      return True
    return False

  # Determine whether the player wants to play again.
  def play_again(self):
    answer = input("\nWould you like to play again?")
    if answer.lower().startswith("y"):
      # Indicate that the player is playing again.
      self.play(True)
    else:
      print("Thanks for playing!")

  # The main function - determines order of operations,
  # asks for a guess, checks if the player has guessed
  # correctly or not, and provides hints.
  def play(self, again):
    # Only display instructions at the start of the game,
    # not if the player wants to play again.
    if not again:
      self.instruction()
    
    self.determine_max_value()
    
    rnd_no = self.choose_number()
    for i in range(1, 6):
      guess = input("Enter a guess: ")

      while not self.format_input(guess):
        guess = input("Enter a guess: ")

      if int(guess) == rnd_no:
        print("\nCongratulation! You win :)")
        break;
      elif int(guess) < rnd_no:
        print("\tYour guess is too low.")
      else:
        print("\tYour guess is too high.")

    self.play_again()

# Playing the game.
ng = NumberGuesser()
ng.play(False)
