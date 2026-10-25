def main():

    activities = (
        prog1,
        prog2,
    )

    for task in activities:

        task()


def readName(msg):

    nme = input(msg).strip()

    while not nme or any(not (x.isalpha() or x == " ") for x in nme):

        print("Use letters and spaces for the name.")
        nme = input(msg).strip()

    return nme


def byteForms(msg):

    byts = bytes(msg, "utf-8")
    bcnv = bytearray(byts)

    if msg:
        bcnv[:len(msg[0].encode("utf-8"))] = bytes([ord("h")])

    return (
        ("Bytes object", byts),
        ("Bytes to string", str(byts, "utf-8")),
        ("Bytes to hex", byts.hex()),
        ("Hex to bytes", bytes.fromhex(byts.hex())),
        ("New bytearray", bytearray(msg, "utf-8")),
        ("Bytes to bytearray", bytearray(byts)),
        ("Sliced bytes", byts[6:]),
        ("Modified message", bcnv.decode("utf-8")),
    )


def prog1():

    print("\nProgram 1")
    msg = "Hello Python"

    for x, (label, val) in enumerate(byteForms(msg), 1):

        print("{}. {}: {}".format(x, label, val))

    return 0


def nameForms(fnme, lnme):

    fllnm = " ".join((fnme, lnme))
    split = len(fnme)

    return fllnm, (
        ("First name", fnme),
        ("Last name", lnme),
        ("Full name", fllnm),
        ("First character", fllnm[:1]),
        ("Last character", fllnm[-1:]),
        ("Sliced first name", fllnm[:split]),
        ("Sliced last name", fllnm[split + 1:]),
    )


def prog2():

    print("\nProgram 2")
    fnme = readName("Enter first name: ")
    lnme = readName("Enter last name: ")
    fllnm, details = nameForms(fnme, lnme)

    for label, val in details:

        print(label + ":", val)

    chars = list(fnme)
    chars[0] = "D"
    nwnm = "".join(chars)
    print("New name:", nwnm)
    print("Original name:", fnme)
    print("Strings stay unchanged; a new string is built from the edited character list.")
    print("Characters in the full name:", *fllnm, sep="\n")

    srch = input("Enter one character to search: ")

    while len(srch) != 1:

        srch = input("Enter exactly one character: ")

    idxs = []

    for x, ltr in enumerate(fllnm):

        if ltr == srch:
            idxs.append(str(x))

    if idxs:
        print("Character found at index:", ", ".join(idxs))
    else:
        print("Character not found")

    print("Occurrences:", len(idxs))

    return 0


if __name__ == "__main__":
    main()
