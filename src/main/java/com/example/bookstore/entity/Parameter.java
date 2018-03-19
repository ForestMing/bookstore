package com.example.bookstore.entity;

import java.util.Date;

public class Parameter {
    private String webname;

    private String regtiaoyue;

    private String notice;

    private String address;

    private String postcode;

    private String tel;

    private String copyright;

    private String weblogo;

    private String website;

    private String affordmethod;

    private String shopstream;

    private String postmethod;

    private Long postprice;

    private String postdescp;

    private Date worktime;

    private String service;

    private String law;

    private String commques;

    private String dealrule;

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname == null ? null : webname.trim();
    }

    public String getRegtiaoyue() {
        return regtiaoyue;
    }

    public void setRegtiaoyue(String regtiaoyue) {
        this.regtiaoyue = regtiaoyue == null ? null : regtiaoyue.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getWeblogo() {
        return weblogo;
    }

    public void setWeblogo(String weblogo) {
        this.weblogo = weblogo == null ? null : weblogo.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getAffordmethod() {
        return affordmethod;
    }

    public void setAffordmethod(String affordmethod) {
        this.affordmethod = affordmethod == null ? null : affordmethod.trim();
    }

    public String getShopstream() {
        return shopstream;
    }

    public void setShopstream(String shopstream) {
        this.shopstream = shopstream == null ? null : shopstream.trim();
    }

    public String getPostmethod() {
        return postmethod;
    }

    public void setPostmethod(String postmethod) {
        this.postmethod = postmethod == null ? null : postmethod.trim();
    }

    public Long getPostprice() {
        return postprice;
    }

    public void setPostprice(Long postprice) {
        this.postprice = postprice;
    }

    public String getPostdescp() {
        return postdescp;
    }

    public void setPostdescp(String postdescp) {
        this.postdescp = postdescp == null ? null : postdescp.trim();
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law == null ? null : law.trim();
    }

    public String getCommques() {
        return commques;
    }

    public void setCommques(String commques) {
        this.commques = commques == null ? null : commques.trim();
    }

    public String getDealrule() {
        return dealrule;
    }

    public void setDealrule(String dealrule) {
        this.dealrule = dealrule == null ? null : dealrule.trim();
    }
}