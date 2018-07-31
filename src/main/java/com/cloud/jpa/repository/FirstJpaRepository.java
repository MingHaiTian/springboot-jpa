package com.cloud.jpa.repository;

import com.cloud.jpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author:tianminghai
 * @Date:下午3:48 2018/6/20
 */
@Repository
public interface FirstJpaRepository extends JpaRepository<Car, Integer> {

    Car findByCarId(Integer carid);

    Car findByCarName(String carName);

    @Transactional
    @Modifying
    @Query(value = "update car c set c.car_name=? where car_id=?", nativeQuery = true)
    int updateCarNameByCarId(String carName, Integer carId);
}
