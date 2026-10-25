

def words():

    w1 = input("Insert first word: ")
    w2 = input("Insert second word: ")
    w3 = input("Insert third word: ")

    words = [w1, w2, w3]

    words.sort()

    for x in words:
        print(x, end=' ')

words()