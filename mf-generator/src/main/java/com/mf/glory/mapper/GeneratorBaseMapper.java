package com.mf.glory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan huang
 * @CreateDate: 2019/3/29 11:15
 */
public interface GeneratorBaseMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(@Param("tableName") String tableName);

    List<Map<String, String>> queryColumns(@Param("tableName") String tableName);

}
