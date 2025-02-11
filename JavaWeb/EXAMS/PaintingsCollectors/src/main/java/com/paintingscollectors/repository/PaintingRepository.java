package com.paintingscollectors.repository;

import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, UUID> {

    Set<Painting> findAllByOwnerNot(User owner);

    @Query(value = "select * from paintings order by votes desc limit 2" , nativeQuery = true)
    List<Painting> getMostRatedPainting();
}
