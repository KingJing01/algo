package sorts;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

  // 快速排序，a是数组，n表示数组的大小
  public static void quickSort(int[] a, int n) {
    quickSortInternally(a, 0, n-1);
  }

  // 快速排序递归函数，p,r为下标
  private static void quickSortInternally(int[] a, int p, int r) {
    if (p >= r) return;

    int q = partition(a, p, r); // 获取分区点
    quickSortInternally(a, p, q-1);  //注：q-1和q+1，之间没有q么？
    quickSortInternally(a, q+1, r);
  }

  private static int partition(int[] a, int p, int r) {  //注：返回的结果说明：返回了pivot的索引i，而且i之前的都是数组中比pivot小的数，但不保证顺序
    int pivot = a[r];  //注：取分区点为数组的最后一个值...
    int i = p;  //注：p表示数组开始，r表示数组结束。所以i和j也表示数组开始
    for(int j = p; j < r; ++j) {
      if (a[j] < pivot) {  //注：从头开始，如果小于分界点才处理
        if (i == j) {  //注：因为只有a[j] < pivot时，i才会自增；否则，只有j每次自增。只要有一个a[j] >= pivot，i和j就不会相等；
          ++i; //注：相等，i后移无需其他操作
        } else {
          int tmp = a[i];  //注：i和j交换位置，交换后，i和j都后移
          a[i++] = a[j];
          a[j] = tmp;
        }
      }
    }

    int tmp = a[i];  //注：最后的交换：i和r的值
    a[i] = a[r];
    a[r] = tmp;

    System.out.println("i=" + i);
    return i; //注：然后返回i（到此时，不仅返回了pivot的索引i，而且i之前的都是数组中比pivot小的数，但不保证顺序）
  }
}
