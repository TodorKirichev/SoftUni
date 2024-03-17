package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.tool;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool {
    private int power;

    public ToolImpl(int power) {
        setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        setPower(getPower() - 5);
        if (getPower() < 0) {
            setPower(0);
        }
    }

    @Override
    public boolean isUnfit() {
        return getPower() == 0;
    }
}
