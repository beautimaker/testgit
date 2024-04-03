
package com.example.demo1.Controller;

import com.example.demo1.dao.AccountFacade;
import com.example.demo1.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@Controller
@RequestMapping(path = "/demo")
public class MainController {

    /**
     *
     */
    @Autowired
    private AccountFacade accountFacade;

    /**
     *
     * @param name
     * @return
     */
    @GetMapping(path="/add")
    @ResponseBody
    public  String openAccount(@RequestParam(value = "name",defaultValue = "null")String name){

        Account a=new Account();
        a.setName(name);
        accountFacade.save(a);
        /*

         */
        return "已开户";
    }

    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<Account> getAllAccount(){
        return accountFacade.findAll();
    }


}
