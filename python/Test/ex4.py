print("구구단을 출력합니다.\n")
for x in range(2, 10):
    print("== " + str(x) + "단==")
    if(x % 2 == 1):
        for y in range(1, 10):
            print(x, "*", y, "=", x*y)
print("---------------------")