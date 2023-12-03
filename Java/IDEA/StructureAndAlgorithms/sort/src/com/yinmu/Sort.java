package com.yinmu;


import java.lang.reflect.Array;

/**
 * @author 饮木
 * 排序算法
 */
public class Sort {
    private Sort() {
    }

    /**
     * 冒泡排序
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int length = array.length;
        //标识
        boolean flag = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    //array[j]-array[j+1]>0
                    flag = true;
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            //如果在一轮中没有进行排序，就说明改数组已经是排好序的了
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
    }

    /**
     * 选择排序
     */
    public static <T extends Comparable<T>> void selectSort(T[] array) {
        T min = null;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            //每开启新的一轮，假定一个最小的值，以及它的下标
            //第一轮假设min=array[0] minIndex=0
            //第二轮假设min==array[1] minIndex=1
            //......
            min = array[i];
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    //若果存在比假设的min值小的话
                    //记录它的值和下标
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //当值和假定的值不一样的时候，说明改轮循环中存在更小的值。
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

    /**
     * 插入排序
     */
    public static <T extends Comparable<T>> void insertSort(T[] array) {
        int length = array.length;
        // 插入的值和下标
        T insert = null;
        int insertIndex = 0;
        for (int i = 1; i < length; i++) {
            //无序组的第一个，从1开始
            insert = array[i];
            //跟有序组的最后一个元素比较，也就是自己的前一位
            insertIndex = i - 1;
//            //while循环也可以
//            while (insertIndex>=0&&insert.compareTo(array[insertIndex])<0){
//                array[insertIndex+1]=array[insertIndex];
//                insertIndex--;
//            }
            for (int j = insertIndex; j >= 0; j--) {
                if (insert.compareTo(array[insertIndex]) < 0) {
                    //如果比有序组的最后一个值小的话
                    //有序组就往后移一位
                    //并且insetIndex往前移一位
                    //与下一位无序数组比较，直到找到适合自己插入的位置
                    //insert已经保存了被覆盖的值，不用担心
                    array[insertIndex + 1] = array[insertIndex];
                    insertIndex--;
                }
            }
            //退出while循环就找到插入的位置了insertIndex+1
            //因为最后一次是与退出循环条件的insertIndex的值比较的，多往前移了一位
            array[insertIndex + 1] = insert;
        }
    }

    /**
     * 希尔排序（交换式）
     * 三层for循环
     */
    public static <T extends Comparable<T>> void shellSortSwap(T[] array) {
        int length = array.length;
        //这个值在交换的时候用的比较多，所以在循环外面声明
        T temp = null;
        //gap有间隙的意思
        //控制分组的循环
        for (int gap = length / 2; gap >= 1; gap /= 2) {
            //分成的组越小，每组的元素就越多,步长就越小
            for (int i = gap; i < length; i++) {
                //对每组进行排序
                for (int j = i - gap; j >= 0; j -= gap) {
                    //前一个值比后一个值大就交换值
                    //然后被交换的值再更其前面排好序的值进行比较，这就是j-=gap的作用
                    if (array[j].compareTo(array[j + gap]) > 0) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    } else {
                        //如果当前的值小于后面的值的话，不用交换数据
                        //前面的数据没有动，所以就就直接退出当前的循环
                        break;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序（插入法）
     */
    public static <T extends Comparable<T>> void shellSortInsert(T[] array) {
        int length = array.length;
        T insert = null;
        int insertIndex = 0;
        //控制分组次数
        for (int gap = length / 2; gap >= 1; gap /= 2) {
            //对每组进行排序
            for (int i = gap; i < length; i++) {
                insert = array[i];
                insertIndex = i - gap;
                //insertIndex>=0这个条件要放在前面，防止下标越界
                while (insertIndex >= 0 && insert.compareTo(array[insertIndex]) < 0) {
                    array[insertIndex + gap] = array[insertIndex];
                    insertIndex -= gap;
                }
                array[insertIndex + gap] = insert;
            }
        }
    }

    /**
     * 快速排序
     * 采用递归的方式
     */
    public static <T extends Comparable<T>> void quickSort(T[] array, int start, int end) {
        if (start >= end) {
            //退出条件
            //就是递归的时候被分组的元素只有一个的时候
            return;
        }
        //基准，默认都是左边第一个元素
        T pivot = array[start];
        //左右下标
        int left = start;
        int right = end;
        while (left < right) {
            //采用挖坑法
            //从右边开始，找比pivot小的数
            while (array[right].compareTo(pivot) >= 0 && left < right) {
                //如果是大于等于的数，就一直循环下去，直到找到小于pivot的数
                //或者left>=right
                right--;
            }
            //填坑和挖坑
            //array[left]的值事先被保存到pivot中了，所以不需要担心
            array[left] = array[right];
            //从左边开始寻找比pivot大的值
            while (array[left].compareTo(pivot) <= 0 && left < right) {
                left++;
            }
            //填坑和挖坑
            array[right] = array[left];
        }
        //退出循环一定是left==right
        array[right] = pivot;
        //开始递归
        //先开始左边的递归
        quickSort(array, start, right - 1);
        //左边递归完了，在开始右边的递归
        quickSort(array, right + 1, end);
    }

    /**
     * 合并两个有序的数组
     *
     * @param array  做排序的原始数组
     * @param left   左边有序序列的初始索引
     * @param right  右边最后的索引
     * @param middle 中间的索引，即左边有序序列的最后一个索引
     * @param temp   做中转的数组
     */
    private static <T extends Comparable<T>> void merge(T[] array, int left, int right, int middle, T[] temp) {
        //初始化l,左边开始索引
        int l = left;
        //初始化r，右边开始索引
        //为什么要mid+1?
        //因为假设数组arr{1,3,5,6,2,4} mid=(left+right)/2 = 2
        //奇数和偶数都是一样的
        //此时左边i=left mid左边的就是 0 - mid 即是{1,3,5}
        //此时右边就是mid+1 - right 即是{6,2,4}
        int r = middle + 1;
        //指向temp当前的索引
        int index = 0;
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        //l <= mid 代表左边有序序列有值
        //r <= right 代表右边有序序列有值
        while (l <= middle && r <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            //假设数组arr{1,3,5,6,2,4}
            //左边 0 - mid 即是{1,3,5}
            //右边 mid+1 -right 即是{6,2,4}
            //若arr[l]<= arr[r] 即是1 <= 6
            if (array[l].compareTo(array[r]) <= 0) {
                //把小于右边数组的值存储到中转数组中
                temp[index] = array[l];
                //左边索引向右移一位
                l++;
            } else {
                //反之就是左边的值大于右边的值
                //把右边的值存储到中转数组中
                temp[index] = array[r];
                //右边索引向右移一位
                r++;
            }
            //中转数组的索引的值向后移一位
            //不管怎么样，在一轮中肯定有数放到中转数组中
            //因为，左右都是有序的序列
            index++;
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        //左边的有序序列还有剩余的元素，就全部填充到temp
        while (l <= middle) {
            temp[index] = array[l];
            l++;
            index++;
        }
        //右边的有序序列还有剩余的元素，就全部填充到temp
        while (r <= right) {
            temp[index] = array[r];
            r++;
            index++;
        }
        //将temp数组的元素拷贝到arr
        //因为合并的时候按图所示数组：{8,4,5,7,1,3,6,2}
        //最先进入的是84 left=0 right = 1
        //经过上面的左边与右边比较，得出temp数组：4,8
        //将temp数组中的4,8赋值给array数组
        // 此时清空指向temp数组的下标指针index 重新回到0
        //重置中转数组的索引，使它指向一开始
        index = 0;
        while (left <= right) {
            array[left] = temp[index];
            left++;
            index++;
        }
    }

    /**
     * 分，把数组分开来
     *
     * @param array 排序的原始数组
     * @param left  左边开始索引
     * @param right 右边的索引
     * @param temp  做中转的数组
     */
    private static <T extends Comparable<T>> void divide(T[] array, int left, int right, T[] temp) {
        if (left >= right) {
            //分的不能再分了就直接退出
            return;
        }
        //计算出中间的索引
        int middle = (left + right) / 2;
        //向左边递归进行递归分解
        divide(array, left, middle, temp);
        //向右边开始进行递归分解
        divide(array, middle + 1, right, temp);
        //合并
        merge(array, left, right, middle, temp);
    }

    /**
     * 归并排序,封装了合并和分两个函数
     *
     * @param array 排序的初始数组
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        T[] temp = (T[]) Array.newInstance(array.getClass().componentType(), array.length);
        divide(array, 0, array.length - 1, temp);
    }

    /**
     * 基数排序
     * 基数排序是使用空间换时间的算法
     * 而且基数排序是对整数，进行排序
     */
    public static void radixSort(int[] array) {
        //定义一个队列数组，表示10个桶，每一个桶就是一个一维数组
        //每个数组的第一个元素用来存放数组存储的元素个数
        int[][] buckets = new int[10][array.length + 1];
        //记录每个桶的索引
        int[] bucketElementCount = new int[10];
        //最小值和最大值
        int max = array[0];
        int min = array[0];
        //计算出该数组中的最大值和最小值
        for (Integer item : array) {
            if (item > max) {
                max = item;
            } else if (item < min) {
                min = item;
            }
        }
        //如果最小值小于0，那么每个数减去最小值，这就保证了最小数等于0
        if (min < 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] -= min;
            }
            //最大值也要减去一个最小值
            max -= min;
        }

        //余数
        int remainder = 0;
        //算出该最大数的位数
        int length = String.valueOf(max).length();
        //控制次数
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                //计算各个位的余数
                remainder = array[j] / n % 10;
                //放到对应的桶中
                buckets[remainder][bucketElementCount[remainder]] = array[j];
                bucketElementCount[remainder]++;
            }
            //按照这个桶的顺序，依次取出放入桶中的数据
            //标记原来数组的索引
            int index = 0;
            //依次遍历每个桶
            for (int j = 0; j < 10; j++) {
                if (bucketElementCount[j] != 0) {
                    //桶中有数据，就把数据取出
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        array[index] = buckets[j][k];
                        index++;
                    }
                    //清零
                    bucketElementCount[j] = 0;
                }
            }
        }
        //排好序号，如果最小值小于0，那么所有的数字都要加上最小值
        if (min < 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] += min;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param array 待排序数组
     */
    public static <T extends Comparable<T>> void heapSort(T[] array) {
        if (array == null || array.length == 0) {
            //数组为空或者数组的长度为0
            return;
        }
        int length = array.length;
        //构建大顶堆
        buildMaxHeap(array, length);
        //把根节点和最后一个叶结点交换
        for (int i = length - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            length--;
            //重新构建大顶堆
            heap(array, 0, length);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param array  待构建数组
     * @param length 待构建的长度
     */
    private static <T extends Comparable<T>> void buildMaxHeap(T[] array, int length) {
        //从最后一个非叶节点开始往前遍历
        for (int i = (length / 2) - 1; i >= 0; i--) {
            heap(array, i, length);
        }
    }

    /**
     * @param array  待构建数组
     * @param i      非叶节点的下标
     * @param length 需要构建大顶堆数组的长度
     */
    private static <T extends Comparable<T>> void heap(T[] array, int i, int length) {
        //左节点下标
        int left = i * 2 + 1;
        //右节点
        int right = i * 2 + 2;
        //假设array[i]最大
        int maxIndex = i;
        //比较左节点的大小
        if (left < length && array[left].compareTo(array[maxIndex]) > 0) {
            maxIndex = left;
        }
        //比较右节点的大小
        if (right < length && array[right].compareTo(array[maxIndex]) > 0) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            //如果最大值不是自己，就交换
            T temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
            //调整子节点
            heap(array, maxIndex, length);
        }
    }

    /**
     * 打印数组
     */
    public static <T> void print(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * 打印数组
     */
    public static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

