package com.cloud.jpa.dto;

/**
 * @Description:
 * @Author:tianminghai
 * @Date:下午2:01 2018/7/31
 */
public class CarInDto {

    private int carId;

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
        return "CarInDto{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                '}';
    }
}
