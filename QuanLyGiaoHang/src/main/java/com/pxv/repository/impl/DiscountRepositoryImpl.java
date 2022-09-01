/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.repository.impl;

import com.pxv.pojos.Discount;
import com.pxv.repository.DiscountRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DiscountRepositoryImpl implements DiscountRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addOrUpdate(Discount discount) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if(getDiscountByID(discount.getId()) == null)
                session.save(discount);
            else
                session.update(discount);
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Discount> getListDiscount(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Discount> query = builder.createQuery(Discount.class);
        Root root = query.from(Discount.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("content").as(String.class), 
                    String.format("%%%s%%", kw));
        }
        
        Query q = session.createQuery(query);
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1)*max);
        
        return q.getResultList();
    }

    @Override
    public long countDiscount() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("Select Count(*) From Discount");
        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
    @Override
    public Discount getDiscountByID(int ID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Discount.class, ID);
    }
    
    @Override
    public boolean deleteDiscount(int ID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Discount discount = getDiscountByID(ID);
            session.remove(discount);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
}
