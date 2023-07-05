package com.nucleus.controller;

import com.nucleus.dao.CustomerTempDao;
import com.nucleus.dao.CustomerTempMasterDao;
import com.nucleus.model.entity.CustomerTemp;
import com.nucleus.model.entity.CustomerTempMaster;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/checker")
public class CheckerController {

    private static final Logger log = LogManager.getLogger(CheckerController.class);


    @Autowired
    CustomerTempDao customerTempDao;

    @Autowired
    CustomerTempMasterDao customerTempMasterDao ;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/showFormChecker")
    public ModelAndView viewData() {
        List<CustomerTemp> customerTempInitial = customerTempDao.getAllCustomer();
        List<CustomerTemp> customerTemps = new ArrayList<>();

        for(CustomerTemp ct : customerTempInitial){
            if(!ct.getRecordStatus().contains("Rejected")){
                customerTemps.add(ct);
            }
        }

        ModelAndView mv = new ModelAndView("checkerview");
        mv.addObject("customerList", customerTemps);
        return mv;
    }

    @RequestMapping("/approve")
    public ModelAndView approve(@RequestParam("code") String code,@RequestParam("status") String status) {
        try {
            if (status.equals("New")) {
                CustomerTemp customerTemp = customerTempDao.getById(code);
                CustomerTempMaster customerTempMaster = customerTempMasterDao.convertTM(customerTemp);
                customerTempMaster.setRecordStatus("Authorised");
                customerTempMaster.setAuthorisedDate(new Date());
                customerTempMaster.setAuthorisedBy("Admin");
                customerTempMasterDao.createCustomer(customerTempMaster);
                customerTempDao.deleteCustomer(code);
                log.info("new user added successfully");
            } else if (status.equals("Delete")) {
                customerTempMasterDao.deleteCustomer(code);
                customerTempDao.deleteCustomer(code);

            } else if (status.equals("Modified")) {
                CustomerTemp customerTemp = customerTempDao.getById(code);
                CustomerTempMaster customerTempMaster = customerTempMasterDao.convertTM(customerTemp);
                customerTempMaster.setRecordStatus("Authorised");
//            customerTempMasterDao.createCustomer(customerTempMaster);
                customerTempMasterDao.updateCustomer(customerTempMaster);
                customerTempDao.deleteCustomer(code);
            }
        }catch(Exception e){
            log.error(e.getMessage() + " at approve");
        }

        return new ModelAndView("redirect:/checker/showFormChecker");
    }

    @RequestMapping("/reject")
    public ModelAndView reject(@RequestParam("code") String code,@RequestParam("status") String status) {

        if(status.equals("New")){
            CustomerTemp customerTemp = customerTempDao.getById(code);
            customerTemp.setRecordStatus("NewRejected");
            customerTempDao.modify(customerTemp);}

        else if (status.equals("Modified")) {
            CustomerTemp customerTemp = customerTempDao.getById(code);
            customerTemp.setRecordStatus("ModifiedRejected");
            customerTempDao.modify(customerTemp);}

        else if (status.equals("Delete")) {
            CustomerTemp customerTemp = customerTempDao.getById(code);
            customerTemp.setRecordStatus("DeletedRejected");
            customerTempDao.modify(customerTemp);}

        return new ModelAndView("redirect:checker/showFormChecker");
    }

    @RequestMapping("/viewMasterData")
    public ModelAndView viewmasterData() {
        List<CustomerTempMaster> customerTempMasters;
        customerTempMasters = customerTempMasterDao.getAllCustomer();
        ModelAndView mv = new ModelAndView("mastertableview");
        mv.addObject("customerList", customerTempMasters);
        return mv;
    }

}
