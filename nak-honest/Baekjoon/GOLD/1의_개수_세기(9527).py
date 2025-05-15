# 2^p <= num < 2^(p+1) 일 때 p를 반환
def get_power(num):
    if num == 1:
        return 0
    i = 0
    while 1 << (i + 1) <= num:
        i += 1

    return i

# 0 ~ 2^(power) - 1 까지의 1의 개수를 반환
def get_total_one_by_pow(power):
    return power * (1 << (power - 1))

def get_total_one(num):
    if num <= 1:
        return num
    total = 0
    cur_num = num

    while cur_num > 1:
        power = get_power(cur_num)
        total += get_total_one_by_pow(power)
        cur_num -= (1 << power)
        total += cur_num + 1

    total += cur_num

    return total

A, B = map(int, input().split())

print(get_total_one(B) - get_total_one(A - 1))


'''
1 ~ k 까지의 수를 2진수로 나타냈을 때의 개수를 알면 좋을듯?
1000 ~ 1111
-> 2^3 <= a < 2^4 -> 2^3
0 ~ 2^0 : 1
2^0 ~ 2^1 :
   1
  10
  11
 100
 101
 110
 111
1000
1001
1010
1011
1100
1101
1110
1111

0 ~ 11101 까지의 1의 개수는 먼저 0 ~ 01111 까지의 개수는 금방 구한다.

그후 10000 ~ 11101 까지의 1의 개수를 구해야 한다.
-> 1 ~ 1101 까지의 1 개수 + (1101)2 개의 1

1 ~ 1101 까지의 1의 개수는 또다시 다음과 같이 구한다.
0 ~ 111 까지의 1의 개수를 구하고
1000 ~ 1101 까지의 개수..!


이때 1 ~1
2^10 = 10^3
2^50
'''
