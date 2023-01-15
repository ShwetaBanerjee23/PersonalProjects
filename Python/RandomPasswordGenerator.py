import random

class RandomPasswordGenerator:
  SYMBOLS = "!@£$%^&*()-+"
  
  # Choose 12 letters, 6 lowercase and 6 uppercase.
  def choose_characters(self):
    chosen_chars = list()
    
    # Choose 6 lowercase letters.
    for i in range(0, 6):
      rnd_no = random.randint(0, 25)
      chosen_lower_char = chr(ord('a') + rnd_no)
      chosen_chars.append(chosen_lower_char)

    # Choose 6 uppercase letters.
    for i in range(0, 6):
      rnd_no = random.randint(0, 25)
      chosen_upper_char = chr(ord('A') + rnd_no)
      chosen_chars.append(chosen_upper_char)

    return chosen_chars

  # Choose 3 integers between 0 and 9 (inclusive).
  def choose_numbers(self):
    chosen_ints = list()
    
    for i in range(0, 3):
      rnd_no = random.randint(0, 9)
      chosen_ints.append(rnd_no)

    return chosen_ints

  # Choose 3 non-alphanumeric characters from self.SYMBOLS.
  def choose_symbols(self):
    chosen_symbols = list()

    for i in range(0, 3):
      rnd_no = random.randint(0, len(self.SYMBOLS) - 1)
      chosen_symbols.append(self.SYMBOLS[rnd_no])

    return chosen_symbols

  # Generate a random password.
  def generate_password(self):
    # Randomly generate 12 random letters 
    # (6 lowercase, 6 uppercase).
    characters = self.choose_characters()
    # Randomly generate 3 random numbers.
    numbers = self.choose_numbers()
    # Randomly choose 3 random symbols from 
    # self.SYMBOLS.
    symbols = self.choose_symbols()

    # Store randomly generated password.
    password = ""

    # Generate password with characters, numbers, 
    # symbols arranged in a random order.
    while not (len(characters) == 0 \
               and len(numbers) == 0 \
               and len(symbols) == 0):
      rnd_no = random.randint(1, 3)

      if ((rnd_no == 1) \
          and not (len(characters) == 0)):
            rnd_char = random.randint(0, len(characters) - 1)
            chosen_char = characters[rnd_char]
            
            password += chosen_char
            characters.remove(chosen_char)
      elif ((rnd_no == 2) \
            and not (len(numbers) == 0)):
              rnd_num = random.randint(0, len(numbers) - 1)
              chosen_no = numbers[rnd_num]
              
              password += str(chosen_no)
              numbers.remove(chosen_no)
      elif ((rnd_no == 3) \
            and not (len(symbols) == 0)):
              rnd_sym = random.randint(0, len(symbols) - 1)
              chosen_sym = symbols[rnd_sym]
              
              password += chosen_sym
              symbols.remove(chosen_sym)

    # Display the randomly generated password.
    print("The randomly generated password is ", password)

rpg = RandomPasswordGenerator()
rpg.generate_password()
