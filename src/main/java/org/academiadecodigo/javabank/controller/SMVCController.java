package org.academiadecodigo.javabank.controller;


import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SMVCController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthService authService;
    @Autowired
    private AccountFactory accountFactory;

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("newCustomer",new Customer());
        return "customers";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{id}")
    public String getCustomers(Model model, @PathVariable Integer id) {
        Customer customer = customerService.findById(id);
      /*List<String> accountTypes = new ArrayList<>();
        for (AccountType type : AccountType.values()){
            accountTypes.add(type.toString());
        }
        authService.authenticate(id);
        System.out.println(accountTypes);*/
        model.addAttribute("accountTypes",AccountType.values());
        model.addAttribute("customer", customer);
        return "singleCustomer";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/delete/{id}")
    public String deleteCustomers(@PathVariable Integer id) {
        customerService.deleteCustomer(id);

        return "redirect:/customers";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/newcustomer")
    public String newCustomerView(Model model) {
        Customer customer = new Customer();
        model.addAttribute(customer);
        return "newCustomer";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customeradd")
    public String addNewCustomer(@ModelAttribute("contact")
                                         Customer customer) {

        customerService.addCustomer(customer);
        return "redirect:/customers";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/customers/edit/{id}")
    public String editCustomerView(Model model, @PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        model.addAttribute(customer);
        return "editCustomer";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customeredit")
    public String editCustomer(@ModelAttribute("customer")
                                       Customer customer) {
        customerService.editCustomer(customer);

        return "redirect:/customers";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/account/main/{id}")
    public String accountMainView(Model model, @PathVariable Integer id) {
        Account account = accountService.findById(id);
        System.out.println(account.toString());
        String accType = account.getAccountType().toString();
        model.addAttribute("accType",accType);
        model.addAttribute("account",account);
        model.addAttribute("customerNumber",account.getCustomer().getId());
        return "accountMain";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/account/withdrawal/{id}")
    public String accountWithdrawal(Model model, @PathVariable Integer id,@RequestParam("ammount") String ammount){
        accountService.withdraw(id,Double.parseDouble(ammount));
        return "redirect:/account/main/"+id;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/account/deposit/{id}")
    public String accountDeposit(Model model, @PathVariable Integer id,@RequestParam("ammount") String ammount){
        accountService.deposit(id,Double.parseDouble(ammount));
        return "redirect:/account/main/"+id;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/account/delete/{id}")
    public String accountDeposit(Model model, @PathVariable Integer id){
        accountService.deleteAccount(id);
        return "redirect:/account/main/"+id;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/accountadd")
    public String accountAdd(Model model, @PathVariable Integer id,@RequestParam("acctype") String acctype){

        System.out.println(acctype);
        return "redirect:/customers/";
    }

}