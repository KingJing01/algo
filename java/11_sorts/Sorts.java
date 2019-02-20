package sorts;

/**
 * 冒泡排序、插入排序、选择排序
 *
 * Author: Zheng
 */
public class Sorts {

  // 冒泡排序，a是数组，n表示数组大小
  public static void bubbleSort(int[] a, int n) {
    if (n <= 1) return;

    for (int i = 0; i < n; ++i) {
      // 提前退出标志位
      boolean flag = false;
      for (int j = 0; j < n - i - 1; ++j) {
        if (a[j] > a[j+1]) { // 交换
          int tmp = a[j];
          a[j] = a[j+1];
          a[j+1] = tmp;
          // 此次冒泡有数据交换
          flag = true;
        }
      }
      if (!flag) break;  // 没有数据交换，提前退出
    }
  }

  // 插入排序，a表示数组，n表示数组大小
  public static void insertionSort(int[] a, int n) {
    if (n <= 1) return;

    for (int i = 1; i < n; ++i) {  //注：首元素不动，以后的依次比较（i表示的是未排序区间的开始索引；j表示的是已排序区间的开始索引）
      int value = a[i];  //注：取需要移动的值
      int j = i - 1;  //注：找到之前已排序区间的元素个数
      // 查找要插入的位置并移动数据
      for (; j >= 0; --j) {  //注：这相当于是倒着遍历已排序区间
        if (a[j] > value) {
          a[j+1] = a[j]; //数据移动。注：如果数值较小 每次都进行后移（不是交换，只有移动），将较大值移到后面 ；如果无需移动，则跳出循环
        } else {
          break;  //注：比较符合，跳出循环
        }
      }
      a[j+1] = value; // 注：插入数据（要排序的数）
    }
  }

  // 选择排序，a表示数组，n表示数组大小
  public static void selectionSort(int[] a, int n) {
    if (n <= 1) return;

    for (int i = 0; i < n - 1; ++i) {
      // 查找最小值
      int minIndex = i;
      for (int j = i + 1; j < n; ++j) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }
      
      // 交换
      int tmp = a[i];
      a[i] = a[minIndex];
      a[minIndex] = tmp;
    }
  }

}
