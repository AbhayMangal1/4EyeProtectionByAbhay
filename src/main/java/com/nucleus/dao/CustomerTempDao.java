package com.nucleus.dao;

import com.nucleus.controller.CheckerController;
import com.nucleus.model.entity.CustomerTemp;
import com.nucleus.model.entity.CustomerTempMaster;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomerTempDao {

    private static final Logger log = LogManager.getLogger(CheckerController.class);

    @Autowired
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate hibernateTemplate) {
        this.template = hibernateTemplate;
    }


    @Transactional(readOnly = false)
    public void createCustomer(CustomerTemp customerTemp) {
        System.out.println("Template save method called");
        template.save(customerTemp);
    }

    @Transactional(readOnly = false)
    public void modify(CustomerTemp customerTemp) {
        template.merge(customerTemp);
    }

    public void saveOrUpdate(CustomerTempMaster ct) {
        template.saveOrUpdate(ct);
    }
    @Transactional(readOnly = false)
    public void saveAll(List<CustomerTemp> customers) {

        for (CustomerTemp c : customers) {
            try {
                log.info("saving customer temp : " + c);
                template.saveOrUpdate(c);
            } catch (Exception e) {
                log.error("cannot save : " + c);
                log.error(e.getMessage());
            }
        }
    }


    @Transactional(readOnly = false)
    public void deleteCustomer(String customerCode) {
        CustomerTemp customerTemp = template.get(CustomerTemp.class, customerCode);
        assert customerTemp != null;
        template.delete(customerTemp);
    }

    @Transactional(readOnly = false)
    public CustomerTemp getById(String customerCode) {
        return template.get(CustomerTemp.class, customerCode);
    }

    @Transactional(readOnly = false)
    public List<CustomerTemp> getAllCustomer() {
        List<CustomerTemp> customerTemps = template.loadAll(CustomerTemp.class);
        return customerTemps;
    }

}