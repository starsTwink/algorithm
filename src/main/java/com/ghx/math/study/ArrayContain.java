package com.ghx.math.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author：ghx
 * @date：2020/5/2 0:51
 * @describe：二维数组中的查找
 */
public class ArrayContain {

    public static Logger logger = LoggerFactory.getLogger(ArrayContain.class);
//    public static boolean Find(int target, int [][] array) {
//        for (int[]m:array){
//            for(int n:m){
//                if(target==n){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static boolean Find(int target, int [][] array) {
        /*
        思路：
        根据数组的特点可以发现,如果从左下角开始查找更为方便
        左下角的数比同一列的数大，同时比同一行的数小
        也就是从左下角开始比，如果target传入的数大于它则列数加一继续比较
        如果小于它则行数减一继续比较
        */
        //定义行数
        int rows=array.length;
        //定义列数
        int lies=array[0].length;
        //定义i用来技计数
        int i=0;
        //while里的条件是极限情况，不满足条件的时候则停止
        while((rows>0)&&(i<lies))
        {
            //目标大于左下角，让列数自增
            if(target>array[rows-1][i])
            {
                logger.info(""+array[rows-1][i]);
                i++;
                //目标小于左下角，让行数自减
            }else if(target<array[rows-1][i])
            {
                rows--;
            }else
            {
                //除了上述两种情况就是相等了，说明已经找到了
                return true;
            }
        }
        //遍历完还没有找到，说明不存在
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={{12,58},{56,78,},{0,41}};
        boolean find = Find(40, arr);
        logger.info("Find:"+find);
       }
}