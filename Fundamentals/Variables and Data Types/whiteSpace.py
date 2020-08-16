# Greet the user
print("Hi!")

name = input("What is your name? ") # asks the user their name
print("It's nice to meet you, ", name)
answer = input("Are you enjoying the course? ").lower()

if answer == "yes":
    print("That's good to hear!")
else:
    print("Oh no! That makes me sad!")