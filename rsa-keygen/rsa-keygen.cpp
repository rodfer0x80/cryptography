#include <iostream>
#include <ctime>
#include <vector>
#include <cmath>
using namespace std;

/*
 * -- Euclidean Algorithm for GCD
 * ----
 * :: Resolves the greatest common divider of two numbers a and b
 * @params int a; int b
*/
int gcd(int a, int b){
  if (b == 0){
    return a;
  }
  return gcd(b, a % b);
}

/*
 * -- Prime Calculator Algorithm
 * ----
 * :: Resolve prime numbers and return them
*/
// Use unsigned ints for modular arithmetic for compile time predicted behaviour
unsigned int prime_finder(){
  unsigned int test_number = rand() % 100 + 10;
  for (unsigned int i = 2; i < test_number; i++){
    if (test_number % i == 0) {
      return prime_finder();
    }
  }
  return test_number;
}

int main() {
  // Make rand available
  srand(time(0));

  // Find p and q which are two large prime numbers at random
  unsigned int p = prime_finder();
  unsigned int q = prime_finder();
  // Find n which is p*q
  // Find phi which is the number of integers between 1 and n
  // that are coprime to n
  // phi can be obtained with the mathematical expression phi = (p-1) * (q -1 )
  unsigned long int n = p*q;
  unsigned long int phi = (p-1)*(q-1);

  vector <int> pub_keys;
  // Store possible keys in pub_keys
  // Find public keys
  // A valid key is a number that is coprime to phi and n
  for (unsigned int i = 2; i < phi; i++){
    if (gcd(i, phi) == 1 && gcd(i,n) == 1){
      pub_keys.push_back(i);
    }
    // We dont a large amount of keys
    if (pub_keys.size() >= 100){
      break;
    }
  }
  // Select a public key at random
  unsigned int e = pub_keys[rand() % pub_keys.size()];
  // Free space
  pub_keys.clear();

  vector <unsigned int> priv_keys;
  // Find private key
  // A valid key is a number bigger than phi that is coprime to phi
  unsigned int i = phi + 1;
  while (priv_keys.size() < 5){
    if(i * e % phi == 1){
      priv_keys.push_back(i);
    }
    i++;
  }
  // Select a private key at random
  unsigned int d = priv_keys[rand() % priv_keys.size()];
  // Free space
  priv_keys.clear();
  // Return keys to the user
  cout << "Public Key: (" << e << "," << n <<")\n";
  cout << "Private Key: (" << d << "," << n <<")\n\n";
}

