package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam25June2022.Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();

    }

    public String getType() {
        return type;
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name,String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }
    public Exercise getExercise(String name,String muscle) {
        return exercises.stream().filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }
    public int getExerciseCount() {
        return exercises.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Workout type: %s\n",getType()));
        exercises.forEach(exercise -> sb.append(exercise).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
