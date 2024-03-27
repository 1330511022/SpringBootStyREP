package org.example.propertest;

/**
 * @Project: SpringDemo
 * @Package: org.example.propertest
 * @author: maZhuo
 * @Email:17320080198@163.com
 * @date: 2024年03月20日 20:02
 */

public class test {
    public static void main(String[] args) {


        int a;
        int b;
        for (a = 1; a <= 9; a++) {
            System.out.println("\t");
            for (b = 1; b <= a; b++) {
                System.out.print(b + "*" + a + "=" + a * b + "  ");
            }
        }


    }


}
