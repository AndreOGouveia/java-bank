package org.academiadecodigo.javabank.controller;


import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.dto.FormCustomer;
import org.academiadecodigo.javabank.model.dto.converters.CustomerFormConverter;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

        private FormCustomer formCustomer;

        private CustomerFormConverter customerFormConverter= new CustomerFormConverter();

        @RequestMapping(method = RequestMethod.GET, path = {"/customers", "/", ""})
        public String getCustomers(Model model) {
            List<Customer> customers = customerService.getAllCustomers();
            model.addAttribute("customers", customers);
            model.addAttribute("newCustomer",new Customer());
            return "customers";
        }

        @RequestMapping(method = RequestMethod.GET, path = "/customers/{id}")
        public String getCustomers(Model model, @PathVariable Integer id) {
            Customer customer = customerService.findById(id);
            model.addAttribute("accountTypes",AccountType.values());
            model.addAttribute("customer", customer);
            return "singleCustomer";
        }

        @RequestMapping(method = RequestMethod.GET, path = "/customers/delete/{id}")
        public String deleteCustomers(@PathVariable Integer id , RedirectAttributes redirectAttributes) {
            customerService.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("alert","Deleted customer "+id);
            return "redirect:/customers";
        }



        @RequestMapping(method = RequestMethod.GET, path = "/newcustomer")
        public String newCustomerView(Model model) {
            Customer customer = new Customer();
            model.addAttribute(customer);
            return "newCustomer";
        }

        @RequestMapping(method = RequestMethod.POST, path = "/customeradd")
        public String addNewCustomer(@ModelAttribute("customer")
                                             Customer customer) {

            customerService.addCustomer(customer);
            return "redirect:/customers";
        }


        @RequestMapping(method = RequestMethod.GET, path = "/customers/edit/{id}")
        public String editCustomerView(Model model, @PathVariable Integer id) {
            Customer customer = customerService.findById(id);
            FormCustomer formCustomer =  customerFormConverter.CustomerToForm(customer,new FormCustomer());
            model.addAttribute("formCustomer",formCustomer);
            return "editCustomer";
        }

        @RequestMapping(method = RequestMethod.POST, path = "/customeredit")
        public String editCustomer(@Valid @ModelAttribute("formCustomer") FormCustomer formCustomer, BindingResult bindingResult , RedirectAttributes redirectAttributes) {

            if (bindingResult.hasErrors()) {
               return "editCustomer";
            }
            Customer customer = customerFormConverter.formToCustomer(formCustomer,customerService.findById(formCustomer.getId()));
            customerService.editCustomer(customer);

            redirectAttributes.addFlashAttribute("alert","Edited customer : " + customer.getFirstName() +" "+customer.getLastName());

            return "redirect:/customers";
        }

        @RequestMapping(method = RequestMethod.GET, path = "/account/main/{id}")
        public String accountMainView(Model model, @PathVariable Integer id) {
            Account account = accountService.findById(id);
            String accType = account.getAccountType().toString();
            model.addAttribute("accType",accType);
            model.addAttribute("account",account);
            model.addAttribute("customerNumber",account.getCustomer().getId());
            return "accountMain";
        }

        @RequestMapping(method = RequestMethod.POST, path = "/accountadd")
        public String accountAdd(Model model,@RequestParam("accountTypeChoice") AccountType acctype){


            Account account = accountFactory.createAccount(acctype);
            System.out.println(account.toString());
            return "redirect:/customers/";
        }

        @RequestMapping(method = RequestMethod.POST, path = "/account/withdrawal/{id}")
        public String accountWithdrawal(Model model, @PathVariable Integer id,@RequestParam("ammount") String ammount, RedirectAttributes redirectAttributes){
            accountService.withdraw(id,Double.parseDouble(ammount));
            redirectAttributes.addFlashAttribute("alert","Withdrawn " +ammount+ " from account "+ id);
            return "redirect:/account/main/"+id;
        }

        @RequestMapping(method = RequestMethod.POST, path = "/account/deposit/{id}")
        public String accountDeposit(Model model, @PathVariable Integer id, @RequestParam("ammount") String ammount , RedirectAttributes redirectAttributes){
            accountService.deposit(id,Double.parseDouble(ammount));
            redirectAttributes.addFlashAttribute("alert","Deposited "+ ammount +" on account "+id);
            return "redirect:/account/main/"+id;
        }

        @Transactional
        @RequestMapping(method = RequestMethod.POST, path = "/account/delete/{id}")
        public String accountDeposit(Model model, @PathVariable Integer id, RedirectAttributes redirectAttributes){

            int cid = accountService.findById(id).getCustomer().getId();
            accountService.deleteAccount(id);

            redirectAttributes.addFlashAttribute("alert", "Deleted account: " + id );
            return "redirect:/customers/"+cid;
        }








}