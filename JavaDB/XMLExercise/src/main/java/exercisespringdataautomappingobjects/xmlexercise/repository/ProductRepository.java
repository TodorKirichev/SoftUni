package exercisespringdataautomappingobjects.xmlexercise.repository;

import exercisespringdataautomappingobjects.xmlexercise.model.entity.Product;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal min, BigDecimal max);


}
