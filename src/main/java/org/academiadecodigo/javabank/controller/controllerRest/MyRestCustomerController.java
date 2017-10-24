package org.academiadecodigo.javabank.controller.controllerRest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.dto.FormCustomer;
import org.academiadecodigo.javabank.model.dto.converters.CustomerFormConverter;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyRestCustomerController {


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
    public ResponseEntity<List<FormCustomer>> getCustomers() throws JsonProcessingException {
        List<FormCustomer> formCustomers = new ArrayList<>();
        List<Customer> customers = customerService.getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            formCustomers.add(customerFormConverter.CustomerToForm(customers.get(i),new FormCustomer()));
        }

        if(formCustomers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(formCustomers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/customers/{id}","/accounts/{id}/"})
    public ResponseEntity<FormCustomer>  getCustomer( @PathVariable Integer id) {
        Customer customer = customerService.findById(id);

        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FormCustomer formCustomer = customerFormConverter.CustomerToForm(customer,new FormCustomer());
        return new ResponseEntity<>(formCustomer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{id}/accounts")
    public ResponseEntity<List<Account>>  getCustomerAccounts( @PathVariable Integer id) {

        Customer customer = customerService.findById(id);


        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        List<Account> accounts = customer.getAccounts();

        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{cid}/account/{aid}")
    public ResponseEntity<Account> getCustomerAccount( @PathVariable Integer cid,@PathVariable Integer aid) {

        Account account = accountService.findById(aid);

        if(account == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        if(account.getCustomer().getId() != cid){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(account, HttpStatus.OK);
    }












/*















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

*/





}
