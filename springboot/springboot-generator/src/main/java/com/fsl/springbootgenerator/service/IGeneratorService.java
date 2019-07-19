package com.fsl.springbootgenerator.service;

import com.fsl.springbootgenerator.pojo.GeneratorInfo;

public interface IGeneratorService {

    /**
     * 生成代码的主方法
     * @param generatorInfo
     */
    void generate(GeneratorInfo generatorInfo);
}
