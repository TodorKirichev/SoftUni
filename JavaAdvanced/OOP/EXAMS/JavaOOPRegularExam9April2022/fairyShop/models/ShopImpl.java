package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.models;

import java.util.Iterator;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        Iterator<Instrument> instruments = helper.getInstruments().iterator();
        Instrument instrument = instruments.next();
        while (true) {
            if (!instrument.isBroken()) {
                helper.work();
                present.getCrafted();
                instrument.use();
                if (!helper.canWork()) {
                    return;
                }
                if (present.isDone()) {
                    return;
                }
            } else {
                if (instruments.hasNext()) {
                    instrument = instruments.next();
                } else {
                    return;
                }
            }
        }
    }
}
