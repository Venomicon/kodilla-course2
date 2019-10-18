package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;

    public List<Employee> findByExtractOfLastName(String extract) {
         List<Employee> theList = employeeDao.retrieveByExtractOfLastName("%"+extract+"%");
         if (theList.size() > 0) {
             LOGGER.info("Names containing " + extract + ": ");
             return  theList;
         } else {
             LOGGER.info("No names containing " + extract + " found.");
             return new ArrayList<>();
         }
    }

    public List<Company> findByExtractOfCompany(String extract) {
        List<Company> theList = companyDao.retrieveCompaniesByExtract("%"+extract+"%");
        if (theList.size() > 0) {
            LOGGER.info("Companies containing " + extract + ": ");
            return  theList;
        } else {
            LOGGER.info("No companies containing " + extract + " found.");
            return new ArrayList<>();
        }
    }

}
