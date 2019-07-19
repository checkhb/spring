package com.fsl.jpa.controller;

import com.fsl.jpa.dto.City;
import com.fsl.jpa.service.CityService;
import com.fsl.jpa.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/save")
    public ServiceResult save(){
        City city = new City("纽约","待出发");
        cityService.save(city);
        return ServiceResult.success(city);
    }


    @RequestMapping("/delete/{id}")
    public ServiceResult delete(@PathVariable Long id){
        cityService.delete(id);
        return ServiceResult.success("删除对象成功");
    }


    @RequestMapping("/update/{id}")
    public ServiceResult update(@PathVariable Long id){
        cityService.update(id);
        return ServiceResult.success("更新对象成功");
    }

    @RequestMapping("/get/{id}")
    public ServiceResult get(@PathVariable Long id){
        return ServiceResult.success(cityService.get(id));
    }
}
