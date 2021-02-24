import random

RandomList = [random.randint(1,50) for i in range(7)]
print("생성된 집합 : ", end='')
print(RandomList)
print("집합에서 가장 큰 수 : " + str(max(RandomList)))
print("집합에서 가장 작은 수 : " + str(min(RandomList)))