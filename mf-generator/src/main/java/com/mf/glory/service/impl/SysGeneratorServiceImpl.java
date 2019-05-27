package com.mf.glory.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mf.glory.mapper.MySqlGeneratorMapper;
import com.mf.glory.service.SysGeneratorService;
import com.mf.glory.utils.GeneratorUtils;
import com.mf.glory.utils.PageUtils;
import com.mf.glory.utils.Query;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @Author: MuFeng
 * @CreateDate: 2019/3/29 14:41
 */
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {

    private static final Logger log = LoggerFactory.getLogger(SysGeneratorServiceImpl.class);

    @Autowired
    private MySqlGeneratorMapper mySqlGeneratorMapper;

    @Override
    public PageUtils queryList(Query query) {
        Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Map<String, Object>> list = mySqlGeneratorMapper.queryList(query);
        return new PageUtils(list, (int)page.getTotal(), query.getLimit(), query.getPage());
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return mySqlGeneratorMapper.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return mySqlGeneratorMapper.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        if (tableNames.length > 0) {
            for (String tableName : tableNames) {
                //查询表信息
                Map<String, String> tableMap = queryTable(tableName);
                //查询列信息
                List<Map<String, String>> columns = queryColumns(tableName);
                //生成代码
                GeneratorUtils.generatorCode(tableMap, columns, zipOutputStream);
            }
        }
        //关闭流
        IOUtils.closeQuietly(zipOutputStream);
        return outputStream.toByteArray();
    }

}
