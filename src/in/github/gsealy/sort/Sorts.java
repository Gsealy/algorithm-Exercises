package in.github.gsealy.sort;

/**
 * O(n2)基本排序算法
 *
 * @author Gsealy
 * @date 2019/3/21 11:43
 */
public class Sorts {

  /**
   * [冒泡排序]，a是数组，n表示数组大小
   */
  public void bubbleSort(int[] a, int n) {
    // 当只存在1个数据的时候，直接返回
    if (n < 2) {
      return;
    }
    for (int i = 0; i < n; ++i) {
      // 是否有交换操作
      boolean flag = false;
      // 只需要比对到(n - i - 1)位置即可
      for (int j = 0; j < n - i - 1; ++j) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          // 当前存在交换操作
          flag = true;
        }
      }
      // 此次内循环没有冒泡操作，提前退出，减少比对次数
      if (!flag) {
        break;
      }
    }
  }

  /**
   * [插入排序]，a 表示数组，n 表示数组大小 <br/>
   * 先缓存第二个位置的数据，和它前一个值做比对，如果前一个值比后一个值要大<br/>
   * 就把前一个值向后移动一位，然后将缓存的数据插到前面<br/>
   * 这样可以降低空间复杂度，不需要再开辟新的数组空间
   */
  public void insertionSort(int[] a, int n) {
    if (n < 2) {
      return;
    }
    for (int i = 1; i < n; ++i) {
      int value = a[i];
      int j = i - 1;
      for (; j >= 0; --j) {
        if (a[j] > value) {
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      a[j + 1] = value;
    }
  }


  public static void main(String[] args) {
    int[] original = new int[]{4, 5, 6, 3, 2, 1};
    // int[] original = new int[]{3, 2, 1};
    Sorts sorts = new Sorts();
    // sorts.bubbleSort(original, original.length);
    sorts.insertionSort(original, original.length);
    for (int i1 : original) {
      System.out.println(i1);
    }
  }

}
