import math


def main():

    activities = (prog1, prog2, prog3, prog4, prog5, prog6)

    for task in activities:

        task()


def readNum(msg, whole=False):

    convert = int if whole else float

    while True:

        try:

            num = convert(input(msg))

            if whole or math.isfinite(num):
                return num

        except ValueError:
            pass

        print("That is not a valid number.")


def readArray(size=None):

    while True:

        line = input("Enter array elements separated by spaces: ")

        try:
            arr = list(map(int, line.split()))
        except ValueError:
            print("Use whole numbers only.")
            continue

        if size is None or len(arr) == size:
            return arr

        print("Enter exactly {} elements.".format(size))


def summarize(arr):

    sepr = 0
    nadr = 0
    xnth = 0
    lowest = math.inf

    for num in arr:

        lowest = min(lowest, num)

        if num > 0:
            sepr += num
            nadr += 1
        elif num < 0:
            xnth += 1

    return sepr, sepr / nadr if nadr else 0, xnth, lowest


def prog1():

    print("\nProgram 1")
    arr = []

    for x in range(10):

        arr.append(readNum("Enter number {}: ".format(x + 1)))

    labels = (
        "Sum of positive values",
        "Average of positive values",
        "Count of negative values",
        "Minimum value",
    )

    for label, val in zip(labels, summarize(arr)):

        print(label + ":", val)

    return 0


def prog2():

    print("\nProgram 2")
    arr = readArray(8)
    dupl = list(dict.fromkeys(arr))

    print("Array without duplicates:", dupl)

    if len(dupl) > 1:

        ranked = sorted(dupl)
        ends = (("Second smallest", ranked[1]), ("Second largest", ranked[-2]))

        for label, val in ends:

            print(label + " element:", val)

    else:
        print("There is no second largest or second smallest element.")

    return 0


def prog3():

    print("\nProgram 3")
    arr = readArray()
    print("Stored data:", arr)
    poss = readNum("Position to delete [starting at 0]: ", whole=True)

    if poss < 0 or poss >= len(arr):

        print("Invalid position.")
        return 0

    nwar = arr[:poss] + arr[poss + 1:]
    print("New data:", nwar)

    return 0


def prog4():

    print("\nProgram 4")
    size = readNum("Array size: ", whole=True)

    while size < 0:

        size = readNum("Enter a non-negative size: ", whole=True)

    parts = [[], []]

    for num in readArray(size):

        parts[num % 2].append(num)

    for label, arr in zip(("Even Elements", "Odd Elements"), parts):

        print(label + ":", " ".join(map(str, arr)))

    return 0


def prog5():

    print("\nProgram 5")
    row = "*"

    for x in range(4):

        print(row)
        row += "A*"

    return 0


def prog6():

    print("\nProgram 6")
    bsl = 12000
    entries = {"Basic salary": bsl, "HRA": 150, "TA": 120, "Others": 450}
    rates = {"DA": .12, "PF": -.14, "IT": -.15}

    for label, rate in rates.items():

        entries[label] = bsl * rate

    for label, amt in entries.items():

        print("{}: {:.2f}".format(label, amt))

    print("Net Salary: {:.2f}".format(sum(entries.values())))

    return 0


if __name__ == "__main__":
    main()
