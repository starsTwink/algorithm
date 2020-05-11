package com.ghx.math.study;

/**
 * @author：ghx
 * @date：2020/5/11 10:18
 * @describe：斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class FibonacciSeries {
    public static int Fibonacci(int n) {
        if (n <= 1)//第0项是0，第一项是1
            return n;
        int res = 0;
        int n1 = 0;
        int n2 = 1;
        for (int i=2; i<=n; i++){//从第2开始2还是1，所以初始化的时候把n1=0，n2=1
            //第三项开始是前两项的和,然后保留最新的两项，更新数据相加
            res = (n1 + n2);
            n1 = n2;
            n2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }
}
