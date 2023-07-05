//package com.nucleus.model.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.stereotype.Repository;
//
//
//public class CustomerMaster implements Serializable {
//    private static final long serialVersionUID = 5348846405774012637L;
//
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @NotEmpty
//    @Size(max = 10)
//    private int customerID;
//
//    @Id
//    @NotEmpty
//    @Column(nullable = false, unique = true)
//    @Size(min=3, max = 10)
//    private String customerCode;
//
//    @NotEmpty
//    @Column(length = 30)
//    @Size(min = 3, max = 30)
//    private String customerName;
//
//    @NotEmpty
//    @Size(min = 3, max = 100)
//    @Column(length = 100)
//    private String customerAddress1;
//
//    @Size(min = 3, max = 100)
//    @Column(length = 100)
//    private String customerAddress2;
//
//
//    @NotEmpty
//    @Size(min = 6, max = 6)
//    @Column(length = 6)
//    @Pattern(regexp = "(^$|[0-9]{6})")
//    private String customerPinCode;
//
//    @NotEmpty
//    @Email
//    private String emailAddress;
//
//    @Size(min = 10, max = 10)
//    @Column(length = 10)
//    @Pattern(regexp = "(^$|[0-9]{10})")
//    private String contactNumber;
//
//    @Size(min = 3, max = 10)
//    private String primaryContactPerson;
//
//    @NotEmpty
//    @Size(min = 1, max = 1)
//    @Column(length = 1)
//    @Pattern(regexp = "(^$|[N, M, D, A, R]{1})")
//    private String recordStatus;
//
//    @NotEmpty
//    @Size(min = 1, max = 1)
//    @Column(length = 1)
//    @Pattern(regexp = "(^$|[A, I]{1})")
//    private String flag;
//
//    @NotEmpty
//    @Temporal(TemporalType.DATE)
//    private Date createDate;
//
//    @NotEmpty
//    private String createdBy;
//
//    @Temporal(TemporalType.DATE)
//    private Date modifiedDate;
//
//    private String modifiedBy;
//
//    @Temporal(TemporalType.DATE)
//    private Date authorisedDate;
//
//    private String authorisedBy;
//
//
//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }
//
//    public String getCustomerCode() {
//        return customerCode;
//    }
//
//    public void setCustomerCode(String customerCode) {
//        this.customerCode = customerCode;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress1() {
//        return customerAddress1;
//    }
//
//    public void setCustomerAddress1(String customerAddress1) {
//        this.customerAddress1 = customerAddress1;
//    }
//
//    public String getCustomerAddress2() {
//        return customerAddress2;
//    }
//
//    public void setCustomerAddress2(String customerAddress2) {
//        this.customerAddress2 = customerAddress2;
//    }
//
//    public String getCustomerPinCode() {
//        return customerPinCode;
//    }
//
//    public void setCustomerPinCode(String customerPinCode) {
//        this.customerPinCode = customerPinCode;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public String getPrimaryContactPerson() {
//        return primaryContactPerson;
//    }
//
//    public void setPrimaryContactPerson(String primaryContactPerson) {
//        this.primaryContactPerson = primaryContactPerson;
//    }
//
//    public String getRecordStatus() {
//        return recordStatus;
//    }
//
//    public void setRecordStatus(String recordStatus) {
//        this.recordStatus = recordStatus;
//    }
//
//    public String getFlag() {
//        return flag;
//    }
//
//    public void setFlag(String flag) {
//        this.flag = flag;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(Date modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
//
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//
//    public Date getAuthorisedDate() {
//        return authorisedDate;
//    }
//
//    public void setAuthorisedDate(Date authorisedDate) {
//        this.authorisedDate = authorisedDate;
//    }
//
//    public String getAuthorisedBy() {
//        return authorisedBy;
//    }
//
//    public void setAuthorisedBy(String authorisedBy) {
//        this.authorisedBy = authorisedBy;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerID=" + customerID +
//                ", customerCode='" + customerCode + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress1='" + customerAddress1 + '\'' +
//                ", customerAddress2='" + customerAddress2 + '\'' +
//                ", customerPinCode='" + customerPinCode + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", contactNumber='" + contactNumber + '\'' +
//                ", primaryContactPerson='" + primaryContactPerson + '\'' +
//                ", recordStatus='" + recordStatus + '\'' +
//                ", flag='" + flag + '\'' +
//                ", createDate=" + createDate +
//                ", createdBy='" + createdBy + '\'' +
//                ", modifiedDate=" + modifiedDate +
//                ", modifiedBy='" + modifiedBy + '\'' +
//                ", authorisedDate=" + authorisedDate +
//                ", authorisedBy='" + authorisedBy + '\'' +
//                '}';
//    }
//
//    public CustomerMaster() {
//    }
//}
//
