package com.nucleus.model.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "CustomerTempMaster16886")
public class CustomerTempMaster{

    @Column(name="customerID")
    private int customerID;
    @Id
    @Column(name="customerCode")
    private String customerCode;
    @Column(name="customerName")
    private String customerName;
    @Column(name="customerAddress1")
    private String customerAddress1;
    @Column(name="customerAddress2")
    private String customerAddress2;
    @Column(name="customerPinCode")
    private String customerPinCode;
    @Column(name="emailAddress")
    private String emailAddress;
    @Column(name="contactNumber")
    private String contactNumber;
    @Column(name="primaryContactPerson")
    private String primaryContactPerson;
    @Column(name="recordStatus")
    private String recordStatus;
    @Column(name="flag")
    private String flag;
    @Column(name="createDate")
    private Date createDate;
    @Column(name="createdBy")
    private String createdBy;
    @Column(name="modifiedDate")
    private Date modifiedDate;
    @Column(name="modifiedBy")
    private String modifiedBy;
    @Column(name="authorisedDate")
    private Date authorisedDate;
    @Column(name="authorisedBy")
    private String authorisedBy;


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public String getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(String customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = new Date();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAuthorisedDate() {
        return authorisedDate;
    }

    public void setAuthorisedDate(Date authorisedDate) {
        this.authorisedDate = authorisedDate;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPinCode='" + customerPinCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", primaryContactPerson='" + primaryContactPerson + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", flag='" + flag + '\'' +
                ", createDate=" + createDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", authorisedDate=" + authorisedDate +
                ", authorisedBy='" + authorisedBy + '\'' +
                '}';
    }
    public boolean equals(Object o){
        if(! (o instanceof CustomerTempMaster))return false;
        return this.getCustomerCode().equals(((CustomerTempMaster) o).getCustomerCode());
    }

    public static CustomerTemp convertMT(CustomerTempMaster customerTempMaster){
        CustomerTemp customerTemp = new CustomerTemp();
        customerTemp.setCustomerID(customerTempMaster.getCustomerID());
        customerTemp.setCustomerCode(customerTempMaster.getCustomerCode());
        customerTemp.setCustomerName(customerTempMaster.getCustomerName());
        customerTemp.setCustomerAddress1(customerTempMaster.getCustomerAddress1());
        customerTemp.setCustomerAddress2(customerTempMaster.getCustomerAddress2());
        customerTemp.setContactNumber(customerTempMaster.getContactNumber());
        customerTemp.setCustomerPinCode(customerTempMaster.getCustomerPinCode());
        customerTemp.setEmailAddress(customerTempMaster.getEmailAddress());
        customerTemp.setPrimaryContactPerson(customerTempMaster.getPrimaryContactPerson());
        customerTemp.setFlag(customerTempMaster.getFlag());
        customerTemp.setRecordStatus(customerTempMaster.getRecordStatus());

        customerTemp.setCreateDate(customerTempMaster.getCreateDate());
        customerTemp.setCreatedBy(customerTempMaster.getCreatedBy());
        customerTemp.setAuthorisedDate(customerTempMaster.getAuthorisedDate());
        customerTemp.setAuthorisedBy(customerTempMaster.getAuthorisedBy());

        return customerTemp;
    }
    public CustomerTempMaster() {
    }
}






