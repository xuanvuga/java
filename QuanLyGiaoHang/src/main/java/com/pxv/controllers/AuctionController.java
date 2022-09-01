/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.pxv.pojos.Auction;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuctionController {
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/auction")
    public String auction(Model model){
        model.addAttribute("auction", new Auction());
        return "auction";
    }
    
    @PostMapping("/auction")
    public String auction(@ModelAttribute(value="auction") Auction auction){
        System.out.println("OKE");
        //            Map r = this.cloudinary.uploader().upload(auction.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type","auto"));
//System.out.println((String) r.get("secure_url"));
//return "redirect:/";
        return"auction";
    }
}
