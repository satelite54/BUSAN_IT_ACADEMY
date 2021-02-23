def sum_digit(a):
    return sum ([int(i) for i in str(a)])

a = int(input("정수 각자리의 합 구하기 정수를 입력해 주세요. :"))
print(sum_digit(a))