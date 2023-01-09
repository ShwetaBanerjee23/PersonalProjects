"""
MAD LIBS GAME

Story taken from:
https://www.thepaintedturtle.org/sites/main/files/file-attachments/mad_libs.pdf
"""

# Take all noun inputs.
noun1 = input("Enter a person's name: ")
noun2 = input("Enter a noun: ")
noun3 = input("Enter another noun: ")
noun4 = input("Enter an animal: ")
noun5 = input("Enter another animal: ")
noun6 = input("Enter a color: ")
noun7 = input("Enter another color: ")

# Take all adjective inputs.
adjective1 = input("Enter a feeling: ")
adjective2 = input("Enter another feeling: ")

# Take all verb inputs.
verb1 = input("Enter a verb: ")
verb2 = input("Enter another verb: ")
verb3 = input("Enter another verb, ending in \"ing\": ")

# Take all number inputs.
number1 = input("Enter a number: ")
number2 = input("Enter another number: ")

# Take all adverb inputs.
adverb1 = input("Enter an adverb, ending in \"ly\": ")

# Take all time inputs.
time = input("Enter a measure of time, e.g. seconds: ")

# Take all silly word inputs.
sillyWord = input("Enter a silly word: ")

# Format output and print to user.
story = f"This weekend I am going camping with {noun1} \
I packed my lantern, sleeping bag, and {noun2}. \
I am so {adjective1} to {verb1} in a tent. I am \
{adjective2} we might see a {noun4}, they are kind. \
I have heard that the {noun6} lake is great for \
{verb3}. Then we will {adverb1} hike through the \
forest for {number1} {time}. If I see a {noun7} \
{noun5} while hiking, I am going to bring it home \
as a pet! At night we will tell {number2} {sillyWord} \
stories and roast {noun3} around the campfire!!"

print(story)
