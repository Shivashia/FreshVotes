package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String rootView(){
        return "index";
    }

    @GetMapping(value = "/dashboard")
    public String dashboardview(){
        return "dashboard";
    }

//    @Autowired
//    JdbcTemplate jdbc;
//    @RequestMapping("/insert")
//    public String index(){
//        jdbc.execute("insert into users_tb(u_id,pwd,username,u_name)values(1,'pwd1','testuser','Shiv')");
//        return"data inserted Successfully";
//    }
}