package com.mf.glory.controller;

import com.mf.glory.service.SysGeneratorService;
import com.mf.glory.utils.PageUtils;
import com.mf.glory.utils.Query;
import com.mf.glory.utils.Result;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: MuFeng
 * @CreateDate: 2019/3/29 14:53
 */
@RestController
@RequestMapping(value = "/sys/generator")
public class SysGeneratorController {

    private static final Logger log = LoggerFactory.getLogger(SysGeneratorController.class);

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public @ResponseBody Result list(@RequestParam Map<String, Object> params){
        PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));
        return Result.ok().put("page", pageUtil);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(String tables, HttpServletResponse response) {
        try {
            byte[] data = sysGeneratorService.generatorCode(tables.split(","));

            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"mf-zhiyin.zip\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream; charset=UTF-8");

            IOUtils.write(data, response.getOutputStream());
        } catch (IOException e) {
            log.error("generator code error：{}", e);
        }
    }
}
