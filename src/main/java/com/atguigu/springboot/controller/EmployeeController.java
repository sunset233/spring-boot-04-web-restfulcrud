package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @ Author: Sunset
 * @ Date: 2020/7/20 22:07
 * @ Version: 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao  employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(){
        return "emp/add";
    }
}
