def findMax(a, b, c):
    if a > b:
        if b > c:
            return a
    if b > a:
        if b > c:
            return b
    if c > a:
        if c > b:
            return c
    return -1

def findMin(a, b, c):
    if a < b:
        if b < c:
            return a
    if b < a:
        if b < c:
            return b
    if c < a:
        if c < b:
            return c
    return -1

def findSum(a, b, c):
    return a + b + c
