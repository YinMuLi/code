package controller;

import dao.EmployeeDao;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.Employee;

import java.util.Collection;

/**
 * @Author 饮木
 * @Date 2022/7/27 20:07
 * @Description TODO
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String queryEmployee(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employees", all);
        return "employee_query";
    }

    /**
     * //@PathVariable:绑定路径中的形式参数
     */
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }
    @PostMapping ("/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "/employee_update";
    }
    @PutMapping("/employee")
    public  String updateEmployee(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/employee";
    }
}
