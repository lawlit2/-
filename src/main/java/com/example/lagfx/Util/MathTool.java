package com.example.lagfx.Util;

import java.util.List;

public class MathTool {
    //拉格朗日插值法
    public double LinearInterpolation(List<Double> value,List<Double> function,double x){
        double y = 0;
        double sum = 0;
        double sum1 = 0;
        for (int i = 0; i <function.size(); i++) {
            for (int j = 0; j < value.size(); j++) {
                if(i!=j) {
                    sum = sum + (x - value.get(j));//计算分子
                    sum1 = sum1 + (value.get(i)-value.get(j));//计算分母
                }
            }
            y = y +sum/sum1*function.get(i);
        }
        return y;
    }

}
