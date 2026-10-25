import datetime
import math
import random


def main():

    activities = (
        prog1,
        prog2,
        prog3,
        prog4,
        prog5,
        prog6,
        prog7,
        prog8,
        prog9,
        prog10,
        prog11,
        prog12,
        prog13,
        prog14,
        prog15,
        prog16,
        prog17,
        prog18,
        prog19,
        prog20,
        prog21,
        prog22,
        prog23,
        prog24,
        prog25,
        prog26,
        prog27,
        prog28,
        prog29,
        prog30,
    )

    for task in activities:

        task()


def readNum(msg):

    while True:

        line = input(msg)

        try:
            num = float(line)
            if math.isfinite(num):
                return num
        except ValueError:
            pass

        print("That is not a valid number.")


def readInt(msg):

    while True:

        try:
            return int(input(msg))
        except ValueError:
            print("That is not a valid integer.")


def readNums(size, label="Number"):

    arr = []

    for x in range(size):

        arr.append(readNum("{} {}: ".format(label, x + 1)))

    return arr


def rectangle(a, b):

    return a * b, 2 * (a + b)


def showRange(first, last, step):

    print(*range(first, last, step), sep="\n")


def prog1():

    print("\nProgram 1")

    print("{} {}".format("Hello", "World"))

    return 0


def prog2():

    print("\nProgram 2")

    nme = input("What is your name? ")
    print("Hello, {}".format(nme.strip()))

    return 0


def prog3():

    print("\nProgram 3")

    arr = readNums(2)
    print("The sum is:", sum(arr))

    return 0


def prog4():

    print("\nProgram 4")

    arr = readNums(2)
    print("Average:", sum(arr) / len(arr))

    return 0


def prog5():

    print("\nProgram 5")

    arr = readNums(2, "Grade")
    weights = [.3, .7]
    avg = sum(x * y for x, y in zip(arr, weights))
    print("Average:", avg)

    return 0


def prog6():

    print("\nProgram 6")

    arr = readNums(3, "Exam")
    print("Average:", sum(arr) / 3)

    return 0


def prog7():

    print("\nProgram 7")

    avg = readNum("Enter average: ")
    rslt = ("Failed", "Passed")[avg >= 50]
    print(rslt)

    return 0


def prog8():

    print("\nProgram 8")

    num = readInt("Enter a number: ")
    print("{} is {}.".format(num, ("Even", "Odd")[num & 1]))

    return 0


def prog9():

    print("\nProgram 9")

    num = readNum("Enter a number: ")
    idx = (num > 0) - (num < 0)
    print({-1: "Negative Number", 0: "Zero", 1: "Positive Number"}[idx])

    return 0


def prog10():

    print("\nProgram 10")

    height = readNum("Height (m): ")
    while height <= 0:
        height = readNum("Enter a positive height (m): ")
    weight = readNum("Weight (kg): ")
    while weight <= 0:
        weight = readNum("Enter a positive weight (kg): ")
    idx = weight / height ** 2
    limits = [(18, "underweight"), (25, "normal weight"), (30, "obese"), (float("inf"), "severely obese")]
    for maxval, label in limits:
        if idx <= maxval:
            print("{} BMI: {:.2f}".format(label, idx))
            break

    return 0


def prog11():

    print("\nProgram 11")

    age = readInt("Enter age: ")
    eligible = "eligible" if age >= 18 else "not eligible"
    print("Your age is {} to get a driver's license".format(eligible))

    return 0


def prog12():

    print("\nProgram 12")

    showRange(1, 101, 1)

    return 0


def prog13():

    print("\nProgram 13")

    showRange(2, 101, 2)

    return 0


def prog14():

    print("\nProgram 14")

    showRange(1, 101, 2)

    return 0


def prog15():

    print("\nProgram 15")

    arr = sorted(set(range(3, 101, 3)) | set(range(5, 101, 5)))
    print(*arr, sep="\n")

    return 0


def prog16():

    print("\nProgram 16")

    num = readInt("Enter number: ")
    showRange(1, num + 1, 1)

    return 0


def prog17():

    print("\nProgram 17")

    a, b = readNums(2, "Side")
    area, perimeter = rectangle(a, b)
    print("Area: {}\nPerimeter: {}".format(area, perimeter))

    return 0


def prog18():

    print("\nProgram 18")

    print(*list("mrhuseyin"), sep="\n")

    return 0


def prog19():

    print("\nProgram 19")

    a = readInt("First number: ")
    b = readInt("Second number: ")
    print("Sum between {} and {}: {}".format(a, b, sum(range(a + 1, b))))

    return 0


def prog20():

    print("\nProgram 20")

    prices = {"1": 10, "2": 5}
    opt = input("1 Cinema | 2 Theater: ")
    while opt not in prices:
        opt = input("Choose 1 or 2: ")
    student = input("Student (Y/N): ").strip().casefold()
    price = prices[opt] * (.5 if student == "y" else 1)
    print("The fee you have to pay:", price)

    return 0


def prog21():

    print("\nProgram 21")

    num = readInt("Enter a number: ")
    divisor = 0
    for x in range(2, math.isqrt(max(0, num)) + 1):
        if num % x == 0:
            divisor = x
            break
    prime = num > 1 and divisor == 0
    print("{} is {}a prime number".format(num, "" if prime else "not "))
    if divisor:
        print(divisor, "times", num // divisor, "is", num)

    return 0


def prog22():

    print("\nProgram 22")

    size = readInt("Number of elements: ")
    while size < 0:
        size = readInt("Enter a non-negative size: ")
    sums = [0, 0]
    for x in range(size):
        num = readInt("Element {}: ".format(x + 1))
        sums[num % 2] += num
    print("Sum of even numbers:", sums[0])
    print("Sum of odd numbers:", sums[1])

    return 0


def prog23():

    print("\nProgram 23")

    salary = readNum("Current salary: ")
    sraise = readNum("Raise rate (%): ")
    print("Increased salary:", salary * (1 + sraise / 100))

    return 0


def prog24():

    print("\nProgram 24")

    r = readNum("Circle radius: ")
    while r < 0:
        r = readNum("Enter a non-negative radius: ")
    vals = {"Diameter": r * 2, "Circumference": math.tau * r, "Area": math.pi * r ** 2}
    for label, val in vals.items():
        print("{} of a circle: {:.2f}".format(label, val))

    return 0


def prog25():

    print("\nProgram 25")

    area, perimeter = rectangle(5, 6)
    print("Area:", area)
    print("Perimeter:", perimeter)

    return 0


def prog26():

    print("\nProgram 26")

    lower = readInt("Lower bound: ")
    upper = readInt("Upper bound: ")
    while upper < lower:
        upper = readInt("Upper bound must be at least {}: ".format(lower))
    num = random.randrange(lower, upper + 1)
    chances = (upper - lower + 1).bit_length()
    for x in range(1, chances + 1):
        guess = readInt("Guess a number: ")
        if guess == num:
            print("Congratulations, you did it in", x, "try")
            return 0
        print("Too small!" if guess < num else "Too high!")
    print("The number is", num)
    print("Better luck next time!")

    return 0


def prog27():

    print("\nProgram 27")

    dt = None
    while dt is None:
        try:
            line = input("Date (dd mm yyyy): ")
            dy, mnth, yr = map(int, line.split())
            dt = datetime.date(yr, mnth, dy)
        except ValueError:
            print("Enter a real date.")
    print(dt.strftime("%A"))

    return 0


def prog28():

    print("\nProgram 28")

    arr = [1, 2, 4, 6, 7, 9, 10]
    missing = set(range(min(arr), max(arr) + 1)) - set(arr)
    print("Missing Elements:", sorted(missing))

    return 0


def prog29():

    print("\nProgram 29")

    letters = set("abc")
    text = "abcd"
    matched = sorted(letters.intersection(text))
    print("Matched Elements:", matched)
    print("All characters matched:", set(text).issubset(letters))

    return 0


def prog30():

    print("\nProgram 30")

    counts = [0, 0]
    means = [0.0, 0.0]
    total = 0
    while True:
        line = input("Enter an integer or 'done': ").strip()
        if line.casefold() == "done":
            break
        try:
            num = int(line)
        except ValueError:
            print("That is not a valid integer.")
            continue
        idx = num % 2
        total += num
        counts[idx] += 1
        means[idx] += (num - means[idx]) / counts[idx]
    print("Total:", total)
    print("Even Average:", means[0])
    print("Odd Average:", means[1])

    return 0


if __name__ == "__main__":
    main()
