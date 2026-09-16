import sys
def checkInt(msg):
    fetcher = input(msg)
    try:
        return int(fetcher)
    except ValueError:
        print('Error: NaN')
        sys.exit()

def mul5():

    num = checkInt('Enter a number between 1-100: ')

    if num > 100 or num < 0:
        print('Not a valid number. Try again.')
        return
    else:
        if num % 5 == 0:
            print('This number is a valid multiple of 5')
        else:
            print('This number is not a valid multiple of 5')
            return
        
while True:
    mul5()