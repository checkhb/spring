package com.fsl.springbootgenerator.service.impl;

import com.fsl.springbootgenerator.mapper.TableMapper;
import com.fsl.springbootgenerator.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yudd
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TableServiceImpl  implements ITableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<String> listAllTableNames() {
        return tableMapper.listAllTableNames();
    }
}
