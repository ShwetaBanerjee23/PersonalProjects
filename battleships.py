"""This program mainly uses the concept of functions and loops (for and while)"""

print("""Hi, welcome to this version of Battleships!

This is your map:
    A   B   C   D   E   F
 1 [ ] [ ] [ ] [ ] [ ] [ ]
 2 [ ] [ ] [ ] [ ] [ ] [ ]
 3 [ ] [ ] [ ] [ ] [ ] [ ]
 4 [ ] [ ] [ ] [ ] [ ] [ ]
 5 [ ] [ ] [ ] [ ] [ ] [ ]
 6 [ ] [ ] [ ] [ ] [ ] [ ]
 
 You must declare where you would like to place your 6 
 ships, declare your ship positions in the format, letter 
 followed by number - e.g. A1 or E6. Enter your guesses 
 in a similar format. Good luck!""")
print("Please enter your 5 ship positions:")

import random

playerShips = []
computerShips = []
playerGuesses = []
computerGuesses = []


def format_checker(position):
    """
    This function checks whether the user has entered a grid value in the correct
    format
    """
    alpha = "ABCDEF"
    numeric = "123456"
    if len(position) == 2 and position[0] in alpha and position[1] in numeric:
        return True
    else:
        return False


def list_checker(position):
    """
    This function checks whether a position entered already exists in the list
    playerShips
    """
    if position in playerShips:
        return True
    else:
        return False


def computer_checker(position):
    """
    This function checks whether a position entered already exists in the list
    computerShips
    """
    if position in computerShips:
        return True
    else:
        return False


# creates a list of user's battleship positions
for i in range(1, 6):
    successful = False
    while not successful:
        position = input("Position " + str(i) + ": ")
        tmp = position.upper()
        if format_checker(tmp) is True and list_checker(tmp) is False:
            playerShips.append(tmp)
            successful = True
        elif format_checker(tmp) is True and list_checker(tmp) is True:
            print("Value already chosen. Please choose a different square.")
        else:
            print("Invalid input. Please check your format.")

# prints positions of player's battleships
tmp = ""
removeChars = "'[]"

for item in playerShips:
    if item not in removeChars:
        tmp = tmp + item + " "

print("Your battleships are positioned at: " + tmp)

# creates a list of computer's battleship positions
alpha = "ABCDEF"

successful = False
while not successful or len(computerShips) < 5:
    randAlpha = alpha[random.randint(0, 5)]
    randNum = random.randint(1, 6)
    position = randAlpha + str(randNum)
    if position not in computerShips:
        computerShips.append(position)
        successful = True

# making guesses
print("Make a guess!")
while True:
    # repeatedly asks for guesses until the format is correct and they haven't been entered before
    if len(computerShips) != 0 and len(playerShips) != 0:
        valid = False
        while not valid:
            guess = input("Guess: ")
            tmp = guess.upper()
            # checks whether the player's guesses are correct or incorrect
            if format_checker(tmp) is True and computer_checker(tmp) is False and tmp not in playerGuesses:
                print("Oops, try again!")
                playerGuesses.append(tmp)
                valid = True
            elif format_checker(tmp) is True and computer_checker(tmp) is True and tmp not in playerGuesses:
                print("Yay, that is correct!")
                computerShips.remove(tmp)
                playerGuesses.append(tmp)
                valid = True
            # avoid player guessing the same square over and over again
            elif tmp in playerGuesses:
                print("Already guessed this, try another one.")
            elif guess != "" and tmp not in playerGuesses:
                print("Invalid input. Please check your format.")
            # avoids player making blank wasted guesses
            else:
                print("Make a guess!")

        alpha = "ABCDEF"

        flag = False
        while not flag:
            # generates a computer guess
            randAlpha = alpha[random.randint(0, 5)]
            randNum = random.randint(1, 6)
            compGuess = randAlpha + str(randNum)
            # avoids computer guessing the same square over and over again
            if compGuess not in computerGuesses:
                print("\nThe computer thinks you have a battleship at " + compGuess)
                # checks whether the computer's guess is correct or incorrect
                if list_checker(compGuess) is True:
                    print("Yay, the computer guessed a correct one!\n")
                    playerShips.remove(compGuess)
                    computerGuesses.append(compGuess)
                    flag = True
                else:
                    print("Oops, wrong guess!\n")
                    computerGuesses.append(compGuess)
                    flag = True
    else:
        break

# determines the winner
if len(computerShips) != 0 and len(playerShips) == 0:
    print("\n***Computer wins!***")
else:
    print("\n***You win!***")
