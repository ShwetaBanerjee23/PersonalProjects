import random
import sys

print("Welcome to the Rock, Paper, Scissors game! Enter rock, "
      "paper, or scissors to play. Enter q or Q to exit the game."
      "\n-------------------------------------------------------------")

options = ["rock", "paper", "scissors"]

def cmpOption():
  r = random.randint(0, 2)
  return options[r]


def playerInput():
  guess = (input("Enter rock, paper, or scissors: ")).lower()
  while not formatChecker(guess):
    if guess == "q":
      sys.exit("\nSee you later!")
    guess = (input("Enter rock, paper, or scissors: ")).lower()
  return guess


def formatChecker(guess):
  if not guess == "q":
    if not guess.isalpha() or not guess in options:
      if not guess.isalpha():
        print("Invalid input: Input must contain only alphabets\n")
        return False
      print("Invalid input: Enter rock, paper, or scissors\n")
      return False
    return True


def playGame(cmpOption, playerOption):
  print("\n***\nComputer chose " + cmpOption + " and you chose " + playerOption)
  if (cmpOption == playerOption):
    print("It's a draw!")
  elif (cmpOption == "rock" and playerOption == "paper") \
    or (cmpOption == "paper" and playerOption == "scissors") \
    or (cmpOption == "scissors" and playerOption == "rock"):
    print("You win")
  else:
    print("The computer wins!")
  print("***\n")

  
while True:
  playGame(cmpOption(), playerInput())
