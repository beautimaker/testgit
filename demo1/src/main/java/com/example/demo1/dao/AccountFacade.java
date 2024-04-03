package com.example.demo1.dao;

import com.example.demo1.entity.Account;

import org.springframework.data.repository.CrudRepository;

public interface AccountFacade extends CrudRepository<Account,Integer> {

    static String openAccount(){

        return "已开户";
    }
//   interface AccountRepository extends CrudRepository<Account,Integer>{
//
//   }


}
