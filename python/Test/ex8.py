import modul

num1 = int(input("첫 번째 숫자: "))
num2 = int(input("두 번째 숫자: "))
num3 = int(input("세 번째 숫자: "))

print("가장 큰 수" + str(modul.findMax(num1, num2, num3)))
print("가장 작은 수" + str(modul.findMin(num1, num2, num3)))
print("숫자의 합" + str(modul.findSum(num1, num2, num3)))