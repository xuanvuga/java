/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.service;

import com.pxv.pojos.Account;
import java.util.List;


public interface AccountService {
     public boolean addAccount(Account account);
      List<Account> getListAccountShipper();
      Account getAccountByID(int id);
      boolean changeStatus(int id);
}
