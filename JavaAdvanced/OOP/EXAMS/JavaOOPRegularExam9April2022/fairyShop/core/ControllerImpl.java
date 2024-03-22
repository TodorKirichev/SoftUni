package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.models.*;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.repositories.HelperRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;
    private int countCraftedPresents;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
        shop = new ShopImpl();
        countCraftedPresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpers = helperRepository.getModels().stream().filter(h -> h.getEnergy() > 50).collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        Present present = presentRepository.findByName(presentName);
        int brokenInstruments = 0;
        for (Helper helper : helpers) {
            shop.craft(present, helper);
            brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (present.isDone()) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (present.isDone()) {
            countCraftedPresents++;
            sb.append(String.format(PRESENT_DONE,presentName, "done"));
        } else {
            sb.append(String.format(PRESENT_DONE,presentName, "not done"));
        }
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
        return sb.toString().trim();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", countCraftedPresents)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        helperRepository.getModels().forEach(h -> sb.append(h).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
