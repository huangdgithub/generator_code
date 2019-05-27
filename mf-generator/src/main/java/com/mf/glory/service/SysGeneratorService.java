package com.mf.glory.service;

import com.mf.glory.utils.PageUtils;
import com.mf.glory.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * @Author: MuFeng
 * @CreateDate: 2019/3/29 14:40
 */
public interface SysGeneratorService {

    PageUtils queryList(Query query);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generatorCode(String[] tableNames);
}
