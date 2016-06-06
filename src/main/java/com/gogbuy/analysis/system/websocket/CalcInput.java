package com.gogbuy.analysis.system.websocket;

/**
 * Created by Mr.Yangxiufeng on 2016/6/2.
 * Time:14:45
 * ProjectName:SpringWebApp
 */
public class CalcInput {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "CalcInput{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
