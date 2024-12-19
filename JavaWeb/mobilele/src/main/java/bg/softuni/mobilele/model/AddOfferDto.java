package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineTypeEnum;

public record AddOfferDto(
        String description,
        EngineTypeEnum engineTypeEnum
) {
}
