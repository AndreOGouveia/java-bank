package org.academiadecodigo.javabank.controller;


import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SMVCController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginController(Model model){
        model.addAttribute("greeting","LoginPage");
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/menu")
    public String menuController(Model model){
        model.addAttribute("greeting","LoginPage");
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction")
    public String transactionController(Model model){
        model.addAttribute("greeting","LoginPage");
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/openaccount")
    public String openController(Model model){
        model.addAttribute("greeting","LoginPage");
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public String getCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("customers",customers);
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{id}")
    public String getCustomers(Model model, @PathVariable Integer id){
        Customer customer = customerService.findById(id);

        model.addAttribute("customer",customer);
        return "singleCustomer";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/delete/{id}")
    public String deleteCustomers(Model model, @PathVariable Integer id){
        customerService.deleteCustomer(id);
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers",customers);

        return "customers";
    }
}
