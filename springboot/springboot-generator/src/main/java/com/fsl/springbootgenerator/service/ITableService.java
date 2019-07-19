package com.fsl.springbootgenerator.service;

import java.util.List;

/**
 * @author yudd
 * 2019年5月30日16:48:46
 */
public interface ITableService {

    /**
     * 查询出所有的表名
     * @return
     */
    List<String> listAllTableNames();
}
