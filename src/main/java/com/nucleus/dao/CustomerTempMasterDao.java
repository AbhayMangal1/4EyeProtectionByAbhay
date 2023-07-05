package com.nucleus.dao;

import com.nucleus.model.entity.CustomerTemp;
import com.nucleus.model.entity.CustomerTempMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomerTempMasterDao {

    @Autowired
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate hibernateTemplate) {
        this.template = hibernateTemplate;
    }


    @Transactional(readOnly = false)
    public void createCustomer(CustomerTempMaster customerTempMaster) {
        System.out.println("Template save method called");
        template.save(customerTempMaster);
    }

    @Transactional(readOnly = false)
    public void updateCustomer(CustomerTempMaster customerTempMaster) {
        System.out.println("Template save method called");
        template.saveOrUpdate(customerTempMaster);
    }

    @Transactional(readOnly = false)
    public void modify(CustomerTempMaster customerTempMaster) {
        template.merge(customerTempMaster);
    }


    @Transactional(readOnly = false)
    public void deleteCustomer(String customerCode) {
        CustomerTempMaster customerTempMaster=template.get(CustomerTempMaster.class,customerCode);
        template.delete(customerTempMaster);
    }

    @Transactional(readOnly = false)
    public CustomerTempMaster getById(String customerCode) {
        return template.get(CustomerTempMaster.class,customerCode);
    }

    @Transactional(readOnly = false)
    public List<CustomerTempMaster> getAllCustomer() {
        List<CustomerTempMaster> customerTempsMasters=template.loadAll(CustomerTempMaster.class);
        return customerTempsMasters;
    }

    @Transactional(readOnly = false)
    public CustomerTemp convertMT(CustomerTempMaster customerTempMaster){
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

    @Transactional(readOnly = false)
    public CustomerTempMaster convertTM(CustomerTemp customerTemp){
        CustomerTempMaster customerTempMaster = new CustomerTempMaster();
        customerTempMaster.setCustomerID(customerTemp.getCustomerID());
        customerTempMaster.setCustomerCode(customerTemp.getCustomerCode());
        customerTempMaster.setCustomerName(customerTemp.getCustomerName());
        customerTempMaster.setCustomerAddress1(customerTemp.getCustomerAddress1());
        customerTempMaster.setCustomerAddress2(customerTemp.getCustomerAddress2());
        customerTempMaster.setContactNumber(customerTemp.getContactNumber());
        customerTempMaster.setCustomerPinCode(customerTemp.getCustomerPinCode());
        customerTempMaster.setEmailAddress(customerTemp.getEmailAddress());
        customerTempMaster.setPrimaryContactPerson(customerTemp.getPrimaryContactPerson());
        customerTempMaster.setFlag(customerTemp.getFlag());
        customerTempMaster.setRecordStatus(customerTemp.getRecordStatus());

        customerTempMaster.setCreateDate(customerTemp.getCreateDate());
        customerTempMaster.setCreatedBy(customerTemp.getCreatedBy());
        customerTempMaster.setAuthorisedDate(customerTemp.getAuthorisedDate());
        customerTempMaster.setAuthorisedBy(customerTemp.getAuthorisedBy());

        return customerTempMaster;
    }
}
