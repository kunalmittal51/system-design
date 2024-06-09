package designpatterns.adapter.Adaptor;

import designpatterns.adapter.Adaptee.WeightMachine;
import designpatterns.adapter.Adaptee.WeightMachineImpl;

public class WeightInKgImpl implements WeightInKg {
    WeightMachine weightMachine;
    private final static double CONVERSION_FACTOR = 0.4;

    public WeightInKgImpl() {
        weightMachine = new WeightMachineImpl();
    }
    @Override
    public int getWeightInKg() {
        return (int) (weightMachine.getWeightInPounds() * CONVERSION_FACTOR);
    }
}
