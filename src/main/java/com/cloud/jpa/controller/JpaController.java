package com.cloud.jpa.controller;

import com.cloud.jpa.dto.CarInDto;
import com.cloud.jpa.entity.Car;
import com.cloud.jpa.repository.FirstJpaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author:tianminghai
 * @Date:下午3:43 2018/6/20
 */
@RestController
public class JpaController {
    @Autowired
    FirstJpaRepository firstJpaRepository;

    private static Log logger = LogFactory.getLog(JpaController.class);

    @RequestMapping(value = "/testFun/{id}", method = RequestMethod.GET)
    public String testFun(@PathVariable(value = "id") int id) {
        Car c = firstJpaRepository.findByCarId(id);
        if (null == c) {
            return "testFun接口未查询到数据";
        } else {
            return "接口/testFun/{id}调用成功 " + c.toString();
        }
    }

    @RequestMapping(value = "/testFun2/{name}", method = RequestMethod.GET)
    public String testFun2(@PathVariable(value = "name") String name) {
        Car c = firstJpaRepository.findByCarName(name);
        if (null == c) {
            return "testFun2接口未查询到数据";
        } else {
            return "接口/testFun2/{name}调用成功 " + c.toString();
        }
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public String testFunSave(@RequestBody CarInDto carInDto) {
        logger.info(carInDto.toString());
        Car car = new Car();
        car.setCarName(carInDto.getCarName());
        firstJpaRepository.save(car);
        return "接口/save调用成功 " + car.toString();
    }

    @GetMapping(value = "/del")
    public String testFunDel(@RequestParam("id") Integer id) {
        logger.info("车辆ID：" + id);
        try {
            firstJpaRepository.deleteById(id);
            return "接口/del调用成功";
        } catch (EmptyResultDataAccessException e) {
            logger.info(e.getMessage());
            return "不存在车辆ID为" + id + "的数据，删除失败";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "其他异常";
        }
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String testFunUpdate(@RequestBody CarInDto carInDto) {
        logger.info("车辆：" + carInDto.toString());
        try {
            firstJpaRepository.updateCarNameByCarId(carInDto.getCarName(), carInDto.getCarId());
            return "接口/update调用成功";
        } catch (EmptyResultDataAccessException e) {
            logger.info(e.getMessage());
            return "不存在车辆ID为" + carInDto.getCarId() + "的数据，删除失败";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "其他异常";
        }
    }

    @GetMapping(value = "/count")
    public String count() {
        return "接口count调用成功 " + firstJpaRepository.count();
    }
}
