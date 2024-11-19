package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Volcanologist;

import javax.validation.constraints.Size;

@Repository
public interface VolcanologistRepository extends JpaRepository<Volcanologist, Long> {

    Volcanologist findByFirstNameAndLastName(String firstName, String lastName);
}
