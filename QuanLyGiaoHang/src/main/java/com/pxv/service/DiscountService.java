/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.service;

import com.pxv.pojos.Discount;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface DiscountService {
    boolean addOrUpdate(Discount discount);
    List<Discount> getListDiscount(String kw, int page);
    long countDiscount();
    Discount getDiscountByID(int ID);
    boolean deleteDiscount(int ID);
}
