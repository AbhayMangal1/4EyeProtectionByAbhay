package com.nucleus.controller;

import com.nucleus.dao.CustomerTempDao;
import com.nucleus.dao.CustomerTempMasterDao;
import com.nucleus.model.entity.CustomerTemp;
import com.nucleus.model.entity.CustomerTempMaster;
import com.nucleus.service.StrToDateConvert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/maker")
public class MakerController {

    private static final Logger log = LogManager.getLogger(MakerController.class);

    @Autowired
    CustomerTempDao customerTempDao;


    @Autowired
    CustomerTempMasterDao customerTempMasterDao;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new CustomerTemp());
        return "customerregister";
    }

    @RequestMapping("/userformsubmit")
    public ModelAndView processForm(@Valid @ModelAttribute("customer") CustomerTemp theCustomerTemp, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return new ModelAndView("customerregister");
        } else {
            theCustomerTemp.setCreateDate(new Date());
            theCustomerTemp.setRecordStatus("New");
            theCustomerTemp.setCreatedBy(theCustomerTemp.getCustomerName());
            customerTempDao.createCustomer(theCustomerTemp);
            return new ModelAndView("redirect:/maker/userformview");
        }
    }

    @RequestMapping("/userformview")
    public ModelAndView viewData() {
        List<CustomerTemp> customerTemps;
        List<CustomerTempMaster> customerTempMasters;
        customerTemps = customerTempDao.getAllCustomer();
        customerTempMasters = customerTempMasterDao.getAllCustomer();


        List<CustomerTempMaster> res = new ArrayList<>();

        for (CustomerTempMaster cm : customerTempMasters) {
            System.out.println(cm.getCustomerCode());
            if (!customerTemps.contains(CustomerTempMaster.convertMT(cm))) {
                System.out.println("doesnt contain : " + cm.getCustomerCode());
                res.add(cm);
            }
        }

        customerTempMasters = res;

        ModelAndView mv = new ModelAndView("view");
        mv.addObject("customerList", customerTemps);
        mv.addObject("customerMasterList", customerTempMasters);
        return mv;
    }

    @RequestMapping("/linkview")
    public ModelAndView viewlink(@RequestParam("code") String code) {

        CustomerTemp customer = customerTempDao.getById(code);
        ModelAndView mv = new ModelAndView("linkview");
        mv.addObject("item", customer);
        return mv;
    }


    @GetMapping("/update")
    public ModelAndView approve(@RequestParam("code") String code,
                                @RequestParam("status") String status,
                                @RequestParam("update") String update)
                                {


        if(update.equals("Delete")){
            if (status.equals("Authorised")) {
                CustomerTempMaster customerTempMaster = customerTempMasterDao.getById(code);
                customerTempMaster.setRecordStatus("Delete");
                CustomerTemp customerTemp = customerTempMasterDao.convertMT(customerTempMaster);
                customerTempDao.createCustomer(customerTemp);
            }
            else{
                customerTempDao.deleteCustomer(code);
            }
        }

        if(update.equals("Modify")){
            CustomerTemp customerTemp = customerTempDao.getById(code);
            ModelAndView model = new ModelAndView("modify");
            model.addObject("customerTemp", customerTemp);
            return model;
        }

        return new ModelAndView("redirect:/maker/userformview");
    }

    @RequestMapping("/userformupdate")
    public ModelAndView modifyForm(@Valid @ModelAttribute("customer1") CustomerTemp customer1, BindingResult theBindingResult) {
        customer1.setModifiedDate(new Date());
        customer1.setModifiedBy(customer1.getCustomerName());

        if (customer1.getRecordStatus().equals("New")) {
            customer1.setRecordStatus("Modified");
            customerTempDao.modify(customer1);
        } else if (customer1.getRecordStatus().equals("Authorised")) {
            customer1.setRecordStatus("Modified");
            System.out.println("runningggg...................");
            customerTempDao.createCustomer(customer1);
        } else if (customer1.getRecordStatus().equals("Modified")) {
            customer1.setRecordStatus("Modified");
            customerTempDao.modify(customer1);
        } else if (customer1.getRecordStatus().equals("NewRejected")) {
            customer1.setRecordStatus("New");
            customerTempDao.modify(customer1);
        } else if (customer1.getRecordStatus().equals("ModifiedRejected")) {
            customer1.setRecordStatus("New");
            customerTempDao.modify(customer1);
        } else if (customer1.getRecordStatus().equals("DeletedRejected")) {
            customer1.setRecordStatus("Modified");
            customerTempDao.modify(customer1);
        }


        return new ModelAndView("redirect:/maker/userformview");
    }


    @PostMapping(value = "/uploadFile")
    public ModelAndView handleFile(MultipartFile file) {
        System.out.println("Running upload file");
        ModelAndView mv = new ModelAndView("redirect:/maker/userformview");
        String fileContents = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                fileContents = new String(bytes);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        } else return mv;

        if (fileContents == null || fileContents.isEmpty()) {
            log.error("No records present to read");
            return mv;
        }

        String[] rows = fileContents.split("\n");
        String customerData[][] = new String[rows.length][rows[0].split("~").length];

        for (int i = 0; i < rows.length; i++) {
            String[] col = rows[i].split("~");
            customerData[i] = Arrays.copyOf(col, col.length);
        }

        List<CustomerTemp> customers = new ArrayList<>();

        for (int i = 0; i < customerData.length; i++) {
//        for (int i = 0; i < customerData.length; i++) {
            try {
//                for (int j = 0; j < customerData[0].length; j++) {
//                    System.out.println(customerData[0][j]);
//                }

                CustomerTemp ct = new CustomerTemp();
                ct.setCustomerCode(customerData[i][0]);
                ct.setCustomerName(customerData[i][1]);
                ct.setCustomerAddress1(customerData[i][2]);
                ct.setCustomerAddress2(customerData[i][3]);
                ct.setCustomerPinCode(customerData[i][4]);
                ct.setEmailAddress(customerData[i][5]);
                ct.setContactNumber(customerData[i][6]);
                ct.setPrimaryContactPerson(customerData[i][7]);
                ct.setRecordStatus(StrToDateConvert.nToNewConvert(customerData[i][8]));
                ct.setFlag(customerData[i][9]);
//                ct.setCreateDate(StrToDateConvert.formatDate(customerData[i][10]));
                ct.setCreatedBy(customerData[i][11]);
//                ct.setModifiedDate(StrToDateConvert.formatDate(customerData[i][12]));
                ct.setModifiedBy(customerData[i][13]);
//                ct.setAuthorisedDate(StrToDateConvert.formatDate(customerData[i][14]));
                ct.setAuthorisedBy(customerData[i][15]);
                log.info(ct);
                customers.add(ct);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        System.out.println("All customers");
        log.info(customers);
        customerTempDao.saveAll(customers);
        return mv;
    }


}





