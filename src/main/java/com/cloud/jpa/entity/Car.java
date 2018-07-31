package com.cloud.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @Author:tianminghai
 * @Date:下午3:55 2018/6/20
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id()
    //  @GeneratedValue(strategy = GenerationType.AUTO)
    //  @Column()
    @Column(name = "car_id")
    private int carId;

    //  @Column()
    @Column(name = "car_name")
    private String carName;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                '}';
    }
}
