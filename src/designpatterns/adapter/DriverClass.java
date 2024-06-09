package designpatterns.adapter;

import designpatterns.adapter.Adaptor.WeightInKg;
import designpatterns.adapter.Adaptor.WeightInKgImpl;
public class DriverClass {
    public static void main (String[] args) {
        WeightInKg weightInKg = new WeightInKgImpl();
        System.out.println(weightInKg.getWeightInKg());
    }
}
