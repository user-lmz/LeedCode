// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.LongStream;

import static java.util.stream.LongStream.iterate;
import static java.util.stream.LongStream.rangeClosed;

public class Prime {
  private static long num;
  public Prime(long num) {
    Prime.num = num;
  }
  public static boolean isPrime(long n) {
    return rangeClosed(2, (long)Math.sqrt(n))
      .noneMatch(i -> n % i == 0);
  }
  public LongStream numbers() {
    return iterate(2, i -> i + 1)
      .filter(Prime::isPrime);
  }
  public static void main(String[] args) {
    new Prime(230309768827L).numbers()
      .limit(40000)
      // .filter(i -> num % i == 0 && isPrime(num/i)).
      .filter(i -> num % i == 0)
      .map(i -> num / i)
      .filter(Prime::isPrime)
      .filter(i -> i > num / i)
      .forEach(n -> System.out.format("%d = %d * %d\n", num, num/n, n));
    // System.out.println();
    // new Prime().numbers()
    //   .skip(90)
    //   .limit(10)
    //   .forEach(n -> System.out.format("%d ", n));
  }
}
/* Output:
2 3 5 7 11 13 17 19 23 29
467 479 487 491 499 503 509 521 523 541
*/
