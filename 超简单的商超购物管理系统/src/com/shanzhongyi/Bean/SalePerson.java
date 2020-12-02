package com.shanzhongyi.Bean;

public class SalePerson {
    private String salePersonName;
    private String salePersonAddress;
    private String salePersonpost;

    public SalePerson(){
        set(salePersonName,salePersonAddress,salePersonpost);
    }

    public void set(String salePersonName, String salePersonAddress, String salePersonpost) {
        this.salePersonName = salePersonName;
        this.salePersonAddress = salePersonAddress;
        this.salePersonpost = salePersonpost;
    }

    public String getSalePersonName() {
        return salePersonName;
    }

    public void setSalePersonName(String salePersonName) {
        this.salePersonName = salePersonName;
    }

    public String getSalePersonAddress() {
        return salePersonAddress;
    }

    public void setSalePersonAddress(String salePersonAddress) {
        this.salePersonAddress = salePersonAddress;
    }

    public String getsalePersonpost() {
        return salePersonpost;
    }

    public void setSalePersonpost(String salePersonpost) {
        this.salePersonpost = salePersonpost;
    }

    @Override
    public String toString() {
        return "SalePerson{" +
                "salePersonName='" + salePersonName + '\'' +
                ", salePersonAddress='" + salePersonAddress + '\'' +
                ", salePersonpost='" + salePersonpost + '\'' +
                '}';
    }
}
