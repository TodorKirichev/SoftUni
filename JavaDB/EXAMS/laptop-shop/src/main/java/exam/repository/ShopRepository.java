package exam.repository;

import exam.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Shop findByName(String name);
}
