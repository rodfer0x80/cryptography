import random
# -- The Euclidean Algorithm
# ----
# :: Used to find the Greatest Common Divisor between 2 integers.
# ----
# 1 :: Assign the values of the numbers your want to find the gcd
# 2 :: Shift the values of the numbers:
# 2.1 :: a is now the value of b
# 2.2 :: b is now the value of the reminder of a/b
# 3 :: Repeat until the reminder of a/b is 0 , the value of b is therefore 0
# 4 :: Return a as this is the largest number that divides the initial a and b
# with a reminder of 0 as proved my the algorithm
def gcd(a, b):
    if b == 0:
      return a
    return gcd(b, a%b)

# Prime Finder
# ----
# :: Used to find a random prime number
# ----
# 1. Choose a number at random
# 2. Check if it is prime
# 3.1 If it is return number
# 3.2 Else call function again
# 4. Eventually we will have a prime number between 10 and 100
def prime_finder():
    test_number = random.randrange(10,100)
    for i in range(2, test_number):
      if test_number % i == 0:
        return prime_finder()
    return test_number

# p and q are 2 random prime numbers
p = prime_finder()
q = prime_finder()
# n is the product of p and q
n = p*q
# phi is the number of integers between 1 and n that are coprime to n
# as in how many numbers between 1 and n are prime  to n
# the equation for this is (p-1)*(q-1)
phi = (p-1)*(q-1)

#  we can find a public key by finding coprime numbers to both phi and n
pub_keys = []
for i in range(2, phi):
  if gcd(i, phi) == 1 and gcd(1, n) == 1:
    pub_keys.append(i)
  if len(pub_keys) >= 100:
    break
e = random.choice(pub_keys)
del(pub_keys)

# we can find a private key by finding numbers
# that multiplied by the public key are coprime to phi
priv_keys = []
i = 2
while len(priv_keys) < 5:
  if i * e % phi == 1:
    priv_keys.append(i)
  i += 1
d = random.choice(priv_keys)
del(priv_keys)

# keys are a combination of the key itself and n like the example:
# Public Key: (7, 143)
# Private Key: (223, 143)
# to encrypt and decrypt data both there are needed
# to encrypt data we take the ASCII codes of each character in a message
# and put it through this equation:
# character^e % n
# to decrypt we use
# character^d % n
# prime numbers are number whom their greatest common divisor is 1 (divided by
# themselves or 1 only)
# coprimes are integers that do not share a gcd as in the only number you can
# divide them both by is 1
print(f"Public Key: ({e}, {n})\nPrivate Key: ({d}. {n})")
