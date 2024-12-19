package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypeEnum engine) {
        this.engine = engine;
    }
}
