def say_hello():
    print("Hello, friends!")

say_hello()

def wash_car(amount_paid):
    if (amount_paid == 12):
        print("Wash with tri-color foam")
        print("Rinse twice")
        print("Dry with large blow dryer")
    if (amount_paid == 6):
        print("Wash with white foam")
        print("Rinse once")
        print("Air dry")
    
wash_car(amount_paid=6)

def withdraw_money(current_balance, amount):
    if (current_balance >= amount):
        current_balance -= amount
        return current_balance

balance = withdraw_money(100, 90)

if (balance <= 20):
    print("We need to make a deposit. The balance is:", balance)
else:
    print("Don't need to do anything")


"""
Java
    void hello() {
        System.out.println("Hi friends!");
    }

Kotlin
    fun checkGrade(grade: String) {
        if (grade == "A")
            println("You aced the class!")
    }

Ruby
    puts "Paycheck Calculator"

    def calculate_check(hourly_rate)
        hourly_rate * 40
    end

    puts "You made #{calculate_check(32)} this week."
"""