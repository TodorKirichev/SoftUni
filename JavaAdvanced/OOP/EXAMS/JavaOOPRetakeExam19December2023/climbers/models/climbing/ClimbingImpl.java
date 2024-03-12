package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climbing;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber.Climber;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        for (Climber climber : climbers) {
            while (climber.canClimb() && !mountain.getPeaksList().isEmpty()) {
                climber.climb();

                String currentPeak = mountain.getPeaksList().iterator().next();
                climber.getRoster().getPeaks().add(currentPeak);
                mountain.getPeaksList().remove(currentPeak);
            }
        }
    }
}
