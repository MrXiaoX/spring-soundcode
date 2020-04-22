package com.cardlan.spring.aop;

public class MathCalculator {

    public int div(int i,int k){
        System.out.println( String.format("被除数 %s / 除数 %s", i , k));
        return i/k;
    }
}
