/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pxv.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "auction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a"),
    @NamedQuery(name = "Auction.findById", query = "SELECT a FROM Auction a WHERE a.id = :id"),
    @NamedQuery(name = "Auction.findByTenNguoiGui", query = "SELECT a FROM Auction a WHERE a.tenNguoiGui = :tenNguoiGui"),
    @NamedQuery(name = "Auction.findByLoaiHangHoa", query = "SELECT a FROM Auction a WHERE a.loaiHangHoa = :loaiHangHoa"),
    @NamedQuery(name = "Auction.findByDiaChiGiaoHang", query = "SELECT a FROM Auction a WHERE a.diaChiGiaoHang = :diaChiGiaoHang"),
    @NamedQuery(name = "Auction.findByDiaChiNhanHang", query = "SELECT a FROM Auction a WHERE a.diaChiNhanHang = :diaChiNhanHang"),
    @NamedQuery(name = "Auction.findBySdtNguoiGiao", query = "SELECT a FROM Auction a WHERE a.sdtNguoiGiao = :sdtNguoiGiao"),
    @NamedQuery(name = "Auction.findBySdtNguoiNhan", query = "SELECT a FROM Auction a WHERE a.sdtNguoiNhan = :sdtNguoiNhan")})
public class Auction implements Serializable {

    @Size(max = 45)
    @Column(name = "HinhAnhSanPham")
    private String hinhAnhSanPham;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "TenNguoiGui")
    private String tenNguoiGui;
    @Size(max = 45)
    @Column(name = "LoaiHangHoa")
    private String loaiHangHoa;
    @Size(max = 45)
    @Column(name = "DiaChiGiaoHang")
    private String diaChiGiaoHang;
    @Size(max = 45)
    @Column(name = "DiaChiNhanHang")
    private String diaChiNhanHang;
    @Size(max = 45)
    @Column(name = "SdtNguoiGiao")
    private String sdtNguoiGiao;
    @Size(max = 45)
    @Column(name = "SdtNguoiNhan")
    private String sdtNguoiNhan;

    public Auction() {
    }
    
    @Transient
    private MultipartFile file;

    public Auction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNguoiGui() {
        return tenNguoiGui;
    }

    public void setTenNguoiGui(String tenNguoiGui) {
        this.tenNguoiGui = tenNguoiGui;
    }

    public String getLoaiHangHoa() {
        return loaiHangHoa;
    }

    public void setLoaiHangHoa(String loaiHangHoa) {
        this.loaiHangHoa = loaiHangHoa;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getSdtNguoiGiao() {
        return sdtNguoiGiao;
    }

    public void setSdtNguoiGiao(String sdtNguoiGiao) {
        this.sdtNguoiGiao = sdtNguoiGiao;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pxv.pojos.Auction[ id=" + id + " ]";
    }

    public String getHinhAnhSanPham() {
        return hinhAnhSanPham;
    }

    public void setHinhAnhSanPham(String hinhAnhSanPham) {
        this.hinhAnhSanPham = hinhAnhSanPham;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
