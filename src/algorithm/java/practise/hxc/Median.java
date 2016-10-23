package algorithm.java.practise.hxc;

import java.util.Objects;
import java.util.Random;

/**
 * Created by Kingxc on 2016/10/22 0022.
 * @author :黄鑫晨
 * 线性时间排序
 * 中位数算法
 */


public class Median {

    public  static void main(String args[]){
       // int[] arraylist = {3,2,5,6,10,12,4,7};
        Median median = new Median();
        double[] medianList = {0.05,0.15,0.4,0.3,0.01,0.09};
        //int result = median.RandomizedSelect(arraylist,0,7,4);
        double result = median.MedianRandomizedSelect(medianList,0,5,0.5);
        System.out.print(result);
    }

    /**
     * 线性时间选择，如果将这个n个元素依基线排列时，排在第k个位置的元素即为我们所找的元素
     * @param a:目标数组
     * @param p:左边界
     * @param r:右边界
     * @param k:目标位置
     * @return:
     */
    private double RandomizedSelect(double[] a, int p,  int r,  int k)
    {
        if (p==r) return a[p];
        //排序过了
        int i = RandomizedPartition(a,p,r),
                //i是基准的位置
                // j为下一次的左边界
        j=i-p+1;
        //j为下标为i的数在a[p:i]中的大小次序
        //如果(i-p+1 ≥k)，则a[p:r]第k小元素落在子数组a[p:i]中
        //k在左边界的左边，对左边进行处理
        if (k<=j) return RandomizedSelect(a,p,i,k);
            //除去左边的数（因为已经排过序）
        else return RandomizedSelect(a,i+1,r,k-j);
    }

    /**
     * 随机选择策略的快速排序算法
     * 在快速排序算法的每一步中，当数组还没有被划分时，可以在a[p: r]中随机选出一个元素作为划分基准，这样可以使划分基准的选择是随机的，从而可以期望划分是较对称的.
     * @param a：目标序列
     * @param p：左边界
     * @return: 右边界
     */
    private int RandomizedPartition (double a[], int p, int r)
    {
        int i = new Random().nextInt(r)%(p-r+1) + p;
        double temp = a[p];
        a[p] = a[i];
        a[i] = temp;
        //Swap(a[i], a[p]);
        return Partition (a, p, r);
    }

    private void Swap(double a, double b){
        double temp = a;
        a=b;
        b=temp;
    }


    /**
     * 快速排序
     * @param a：目标数组
     * @param p：左界
     * @param r：右界
     * @return ：右指针位置
     */
    private int Partition (double a[], int p, int r)
    {
        int i = p, j = r + 1;
        double x=a[p];
        // 将< x的元素交换到左边区域
        // 将> x的元素交换到右边区域
        while (true) {
            while (a[++i] <x);
            while (a[--j] >x);
            if (i >= j) break;
            //Swap(a[i], a[j]);
            double temp = a[j];
            a[j]=a[i];
            a[i]=temp;
        }
        a[p] = a[j];
        a[j] = x;
        return j;
    }

    private double getLeftSum(double[] a, int p ){
        double sumLeft = 0;
        for (int i = 0;i<p;i++){
            sumLeft+=a[p];
        }
        return sumLeft;
    }
    private double MedianRandomizedSelect(double[] a, int p,  int r,  double k)
    {
        double sumLeft=getLeftSum(a,p);
        double sumRight = sumLeft+a[p];
        if (sumLeft<=k && sumRight>k) return p;
        if (p==r) return p;
        int i = RandomizedPartition(a,p,r);
        double sumLefti = getLeftSum(a,i);
        if (sumLefti>k) return MedianRandomizedSelect(a,p,i,k);
        else return MedianRandomizedSelect(a,i+1,r,k);
    }
}
