package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByBrandAndModel(String brand, String model);

    @Query("SELECT d FROM Device d WHERE d.deviceType = :deviceType AND d.price < :price AND d.storage >= :storage ORDER BY LOWER(d.brand) ASC")
    List<Device> findAllByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqualOrderByBrand(DeviceType deviceType, Double price, Integer storage);
}
