package bg.softuni.pathfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;
}
