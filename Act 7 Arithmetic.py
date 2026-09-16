import sys

def welcomer():

    operations = [
        'Addition' , 'Subtraction', 'Multiplication',
        'Division' , 'Modulus'    , 'Increment'     ,
        'Decrement',
    ]

    for i in range(0, len(operations), 3):
        batch = operations[i:i+3]
        
        row_str = "".join(f"{i + j + 1}. {item:<18}" for j, item in enumerate(batch))
        print(row_str)

    opt = input('Select an arithmetic operation: ')

    try:

        return calcOp(int(opt))
    
    except ValueError:

        print('Not a valid option!')
        sys.exit()

def checkNum(msg):
    fetcher = input(msg)

    try:
        num = float(fetcher)
        return int(num) if num.is_integer() else num
    except ValueError:
        print('Error: NaN') # Failsafe. Must only take integers or float-point values.
        sys.exit()

def calcOp(opt):

    x = checkNum('Enter the value of x: ')
    if opt != 6 and opt != 7:
        y = checkNum('Enter the value of y: ')
    if opt == 4 and opt == 5 and (x == 0 or y == 0):
        print('0 is not allowed in this operation!')
        return

    print(f"Variable Values: x = {x}" if (opt != 6 and opt !=7) else "Variable Values: x = {x} | y = {y}")

    match opt:
        case 1: # Addition
            print(f"Addition: x + y = {x + y}")
        case 2: # Subtraction
            print(f"Subtraction: x - y = {x - y}")
        case 3: # Multiplication
            print(f"Multiplication: x * y = {x * y}")
        case 4: # Division
            print(f"Division: x / y = {x / y}")
        case 5: # Modulus
            print(f"Modulus: x % y = {x % y}")
        case 6: # Increment
            print(f"Increment: x + 1 = {x + 1}")
        case 7: # Decrement
            print(f"Decrement: x - 1 = {x - 1}")
        case _:
            print('Not a valid operation!')

    return

while True:

    welcomer()

    while True:

        looper = input("Would you like to continue? [1] YES | [0] NO\n\n")

        if looper == "1":
            break
        elif looper == "1":
            print('Goodbye!')
            sys.exit()
        else:
            print('Not a valid option!')

