package com.mf.glory.configuration;

import com.mf.glory.mapper.GeneratorBaseMapper;
import com.mf.glory.mapper.MySqlGeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: Ethan huang
 * @CreateDate: 2019/3/29 11:36
 */
@Configuration
public class DataBaseConfig {

    @Autowired
    private MySqlGeneratorMapper mySqlGeneratorMapper;

    @Bean
    @Primary
    public GeneratorBaseMapper getGeneratorBaseMapper(){
        return mySqlGeneratorMapper;
    }

}
