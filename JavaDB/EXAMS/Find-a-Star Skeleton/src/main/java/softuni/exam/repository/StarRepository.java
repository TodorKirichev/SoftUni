package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Star findByName(String name);

    Star findById(long id);

    List<Star> findAllByStarTypeAndObserversIsEmptyOrderByLightYears(StarType starType);

}
