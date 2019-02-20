package sorts;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

  // 归并排序算法, a是数组，n表示数组大小
  public static void mergeSort(int[] a, int n) {
    //注：内部是初始的第一次调用
    mergeSortInternally(a, 0, n-1);
  }

  // 递归调用函数
  //注：p和r表示下标（数组大小-1的那个）
  private static void mergeSortInternally(int[] a, int p, int r) {
    // 递归终止条件
    if (p >= r) return;

    // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
    int q = p + (r - p)/2;
    // 分治递归：（注：不断分不断分）
    mergeSortInternally(a, p, q);  //注：前半部分归并为有序数组
    mergeSortInternally(a, q+1, r);//注：后半部分归并为有序数组

    // 将A[p...q]和A[q+1...r]合并为A[p...r]
    merge(a, p, q, r); //注：合并为新的数组
  }

  private static void merge(int[] a, int p, int q, int r) { //注：返回的结果说明：将分别归并的两部分合到一起，一个整体有序的数组
    int i = p;  //注：i表示前半部分的开始位置
    int j = q+1; //注：j表示后半部分的开始位置

    int k = 0; // 初始化变量i, j, k（注：k用于缓存数组tmp）
    int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
    while (i<=q && j<=r) { //注：即两边都没排完？
      if (a[i] <= a[j]) {
        tmp[k++] = a[i++]; // i++等于i:=i+1 （注：将小的放入tmp中）
      } else {
        tmp[k++] = a[j++];
      }
    }

    // 判断哪个子数组中有剩余的数据
    int start = i;  //注：start不断往后移动呢，默认前面的没完
    int end = q;
    if (j <= r) { //注：表示后面的没完？则修改
      start = j;
      end = r;
    }

    // 将剩余的数据拷贝到临时数组tmp
    while (start <= end) {
      tmp[k++] = a[start++];
    }

    // 将tmp中的数组拷贝回a[p...r]  （注：a就是开始时一直没变的那个数组，所以需要从p开始；tmp是缓存数组，所以每次都从0开始）
    for (i = 0; i <= r-p; ++i) {
      a[p+i] = tmp[i];
    }
  }

}
