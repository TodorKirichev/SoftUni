package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Attraction;

import java.util.Set;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Attraction findByName(String name);

    Attraction findById(long id);

    @Query("SELECT a FROM Attraction a WHERE a.type = :firstType OR a.type = :secondType AND a.elevation >= :elevation " +
            "ORDER BY a.name ASC, a.country.name ASC")
    Set<Attraction> findAllAttractionsWithHistoricalOrArchaelogicalSiteWithElevationMoreOrEqualTo300(String firstType, String secondType, Integer elevation);
}
