package algorithm.pinduoduo.automn20170801;
/*
 * [编程题] 六一儿童节
时间限制：1秒
空间限制：32768K
六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
输入描述:
第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素

输出描述:
上台表演学生人数

输入例子1:
3 
 2 2 3
 2
 3 1 

输出例子1:
1
 */
import java.util.*;
public class ChildrensDay {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int i = 0 ; i < n ; i++){
            h[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] w = new int[m];
        for(int i = 0 ; i < m ; i++){
            w[i] = in.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        n--;
        m--;
        int count = 0;
        while(m >= 0 && n >= 0){
            if(w[m]>=h[n]){
                m--;
                n--;
                count++;
            }else{
                n--;
            }
        }
        System.out.println(count);
    }
}
