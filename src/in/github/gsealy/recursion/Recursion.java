package in.github.gsealy.recursion;

/**
 * 递归
 *
 * @author Gsealy
 * @date 2019/2/28 17:04
 */
public class Recursion {

  /**
   * 正常递归
   */
  private int fibonacciRecursive(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2));
  }

  /**
   * 尾递归
   */
  private int fibonacciTailRecursive(int n, int ret1, int ret2) {
    if (n == 0) {
      return ret1;
    }
    return fibonacciTailRecursive(n - 1, ret2, ret1 + ret2);
  }

  public static void main(String[] args) {
    Recursion recursion = new Recursion();
    for (int counter = 0; counter <= 10; counter++) {
      System.out.printf("Fibonacci of %d is: %d\n",
          counter, recursion.fibonacciRecursive(counter));
    }
  }
}
