package com.xlr.controller;


import com.xlr.entity.mysql.MysqlBlog;
import com.xlr.repository.MysqlBlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sixkery
 * @date 2019/11/24
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    MysqlBlogRepository mysqlBlogRepository;

    @GetMapping("/")
    public String index() {
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        log.info("【查询所有的博客数据】all={}", all.size());
        return "index.html";

    }
}
