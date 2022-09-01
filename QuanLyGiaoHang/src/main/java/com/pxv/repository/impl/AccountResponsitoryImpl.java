/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.repository.impl;

import com.pxv.pojos.Account;
import com.pxv.repository.AccountResponsitory;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountResponsitoryImpl implements AccountResponsitory{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
        
    @Override
    public boolean addAccount(Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(account);
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Account> getListAccountShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query = query.select(root).where(builder.equal(root.get("status"), Account.DISABLE));
        Query q = session.createQuery(query);
        List<Account> list = q.getResultList();
        return list;
    }

    @Override
    public Account getAccountByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public boolean changeStatus(int id) {
        try {
            Account a = getAccountByID(id);
            a.setStatus(Account.ENABLE);
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }
    
}
