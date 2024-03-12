package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climbing;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber.Climber;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
