package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitService implements CommandLineRunner {

    private final MoodRepository moodRepository;

    private final Map<MoodName, String> moods = Map.of(
            MoodName.HAPPY, "",
            MoodName.SAD, "",
            MoodName.INSPIRED, ""
    );

    public InitService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (moodRepository.count() > 0) {
            return;
        }

        moods.forEach((type, description) -> {
            moodRepository.save(new Mood(type, description));
        });
    }
}
