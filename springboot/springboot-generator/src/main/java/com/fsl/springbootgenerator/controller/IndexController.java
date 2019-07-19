package com.fsl.springbootgenerator.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fsl.springbootgenerator.pojo.GeneratorInfo;
import com.fsl.springbootgenerator.pojo.ServiceResult;
import com.fsl.springbootgenerator.service.IGeneratorService;
import com.fsl.springbootgenerator.service.ITableService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * @author yudd
 * 2019年5月30日16:32:28
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITableService tableService;


    @Autowired
    private IGeneratorService generatorService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/listAllTableNames")
    public ServiceResult listAllTableNames(){
        List<String> strings = tableService.listAllTableNames();
        List<Map<String,String>> returnList = Lists.newArrayList();
        for(int i=0;i<strings.size();i++){
            Map<String,String> map = Maps.newHashMap();
            map.put("tableName",strings.get(i));
            returnList.add(map);
        }
        return ServiceResult.success(returnList);
    }


    @ResponseBody
    @RequestMapping("/generator")
    public ServiceResult generator(@RequestBody String requestJson, HttpServletRequest request){
        logger.info("前端传输过来的信息是："+requestJson);
        JSONObject jsonObject = JSON.parseObject(requestJson);
        JSONArray checkBoxStatus = jsonObject.getJSONArray("checkBoxStatus");
        String tableName = jsonObject.getString("tableName");
        String codePath = jsonObject.getString("codePath");
        String packageParentPath = jsonObject.getString("packageParentPath");
        String packagePath = jsonObject.getString("packagePath");
        String keyStrategy = jsonObject.getString("keyStrategy");

        //组装成对应的对象
        GeneratorInfo generatorInfo = new GeneratorInfo();
        generatorInfo.setTableName(tableName);
        generatorInfo.setCodePath(codePath);
        generatorInfo.setPackageParentPath(packageParentPath);
        generatorInfo.setPackagePath(packagePath);
        generatorInfo.setKeyStrategy(keyStrategy);
        //"name": $(this).attr('name'),
        //"checked": $(this).is(":checked")
        try {
            // 设置对应的创建状态和覆盖状态
            for (int i = 0; i < checkBoxStatus.size(); i++) {
                JSONObject fieldJSONObject = checkBoxStatus.getJSONObject(i);
                String name = fieldJSONObject.getString("name");
                Field f = generatorInfo.getClass().getDeclaredField(name);
                f.setAccessible(true);
                f.set(generatorInfo, fieldJSONObject.getBooleanValue("checked"));
            }
            // 设置各个实体的值
            JSONArray nameArray = jsonObject.getJSONArray("nameArray");
            for (int i = 0; i < nameArray.size(); i++) {
                JSONObject fieldJSONObject = nameArray.getJSONObject(i);
                String name = fieldJSONObject.getString("name");
                Field f = generatorInfo.getClass().getDeclaredField(name);
                f.setAccessible(true);
                f.set(generatorInfo, fieldJSONObject.getString("value"));
            }
        }
        catch (Exception e){
            logger.info("通过反射给对象赋值发生了异常，异常信息是：" + e.getMessage());
        }
        logger.info("前端传输过来的信息转换成generatorInfo = "+JSON.toJSONString(generatorInfo));

        generatorService.generate(generatorInfo);

        return ServiceResult.success(generatorInfo);
    }
}
