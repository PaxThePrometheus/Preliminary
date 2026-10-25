
import time

def checkInt(msg):
    fetcher = input(msg)
    try:
        return int(fetcher)
    except ValueError:
        print('Error: NaN')
        sys.exit()

def purchase():

    P1 = checkInt('Enter the price of the first item: ')
    P2 = checkInt('Enter the price of the second item: ')

    time.sleep(.5)

    PM1 = checkInt('Enter the payment for the first item: ')
    PM2 = checkInt('Enter the payment for the second item: ')

    op1 = PM1 - P1
    op2 = PM2 - P2

    if op1 < 0 and op2 < 0:
        print(f'You still owe {(op1 + op2) * -1}')
    else:
        print(f"Thank you for purchasing! Your total change is {op1 + op2}")


purchase()