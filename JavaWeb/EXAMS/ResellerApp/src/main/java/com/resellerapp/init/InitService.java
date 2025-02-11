package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class InitService implements CommandLineRunner {

    private final Map<ConditionName, String> descriptions = Map.of(
            ConditionName.EXCELLENT, "In perfect condition",
            ConditionName.GOOD, "Some signs of wear and tear or minor defects",
            ConditionName.ACCEPTABLE, "The item is fairly worn but continues to function properly"
    );

    private final ConditionRepository conditionRepository;

    public InitService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (conditionRepository.count() > 0) {
            return;
        }
        Arrays.stream(ConditionName.values()).forEach(conditionName -> {
            conditionRepository.save(new Condition(conditionName, descriptions.get(conditionName)));
        });
    }
}
