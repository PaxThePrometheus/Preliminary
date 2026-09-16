import time, sys

def listener(msg):

    fetcher = input(msg)

    try:

        return checkValid(int(fetcher))

    except ValueError:
        
        print('That is not a valid character!')
        sys.exit()

def checkValid(score):
    if score < 0 or score > 100:
        print("Your score is not real!")
        sys.exit()
    else:
        return score

def fetchAvg():

    jScr  = listener("Insert your Java Programming score: ")
    cScr  = listener("Insert your C Programming score: ")
    dbScr = listener("Insert your Database Handling score: ")

    time.sleep(.5)

    avgScr = (jScr + cScr + dbScr) / 3

    print(f"\nYour GA (general average) score is {avgScr:.2f}\n")

    return fetchGrade(avgScr)

def fetchGrade(grade):

    threshold = [90 ,  80,  75]
    gAlpha    = ['A', 'B', 'C']

    for x, y in enumerate(threshold):
        if int(grade) >= y:
            print("Your grade is {}.\n".format(gAlpha[x]))
            return gAlpha[x]

while True:
    fetchAvg()
    while True:
        contd = input("Would you like to continue? [1] YES | [0] NO\n")
        if contd == 1:
            break
        elif contd == 0:
            sys.exit()
        else:
            print("Not a valid option!")
