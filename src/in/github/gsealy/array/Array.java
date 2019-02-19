package in.github.gsealy.array;

/**
 * 定义：数组（Array）是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据。
 *
 * <pre>
 * 数组的插入和删除
 * </pre>
 *
 * @author Gsealy
 * @date 2019/2/19 9:17
 */
public class Array {

  /**
   * 数组定义
   */
  private int[] data;

  /**
   * 默认初始大小
   */
  private static final int INIT_CAPACICY = 10;

  /**
   * 数组大小
   */
  private int capacity;

  /**
   * 数组中元素个数
   */
  private int count = 0;

  public Array(int initCapacity) {
    this.data = new int[initCapacity];
    this.capacity = initCapacity;
  }

  public Array() {
    this(INIT_CAPACICY);
  }

  /**
   * 在指定位置添加数据
   *
   * @param index 指定位置
   * @param num 所需要添加的值
   * @return true: 插入成功，false: 插入失败
   */
  public boolean add(int index, int num) {
    // 优先判断数组有无可分配空间
    // <1> 数组无可分配空间, 当
    if (count == capacity) {
      System.out.println("数组已满，无可插入空间");
      return false;
    }
    // <2> 数组有可分配空间
    // <2.1> 当前index值大于count, 插入位置不合法
    if (index < 0 || index > count) {
      System.out.println("插入位置不合法");
      return false;
    }
    // <2.2> 插入位置合法
    for (int i = count; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = num;
    count++;
    return true;
  }

  /**
   * 插入数据，默认是尾插入
   *
   * @return true: 插入成功，false: 插入失败
   */
  public boolean add(int num) {
    return add(count, num);
  }

  /**
   * 删除当前索引数据
   */
  public boolean remove(int index) {
    // 判断是否存在
    if (index < 0 || index >= count) {
      System.out.println("索引位置有误");
      return false;
    }
    // 存在当前索引, 后一位覆盖索引位
    for (int i = index + 1; i < count; i++) {
      data[i - 1] = data[i];
    }
    count--;
    return true;
  }

  public void printAll() {
    StringBuilder sb = new StringBuilder(count).append("[");
    for (int i = 0; i < count; i++) {
      if (i != 0) {
        sb.append(", ");
      }
      sb.append(data[i]);
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    Array array = new Array();
    array.printAll();
    array.add(0, 1);
    array.add(5);
    array.printAll();
    array.remove(1);
    array.printAll();
  }

}
