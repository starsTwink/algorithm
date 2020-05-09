package com.ghx.math.study;

import java.util.Stack;

/**
 * @author：ghx
 * @date：2020/5/7 14:33
 * @describe：用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 栈是先进后出
 * 队是先进先出
 */
public class StacksAndQueues {

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        public int pop() {
            return stack2.pop();
        }
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            StacksAndQueues s = new StacksAndQueues();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            int pop = s.pop();
            System.out.println(pop);
        }

}
