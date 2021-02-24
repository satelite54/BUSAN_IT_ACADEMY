
def printRighttriangle(num):
    while num != 0:
        i = num;
        while i != 0:
            print("*", end='')
            i -= 1
        print()
        num -= 1

num = int(input("input number:"))
printRighttriangle(num)

