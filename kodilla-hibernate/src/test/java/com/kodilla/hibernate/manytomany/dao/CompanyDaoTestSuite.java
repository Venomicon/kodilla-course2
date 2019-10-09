package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueries() {
        //Given
        Employee emp1 = new Employee("Jan", "Kowalski");
        Employee emp2 = new Employee("Mateusz", "Kowal");
        Employee emp3 = new Employee("Anna", "Nowak");
        Company company1 = new Company("CocaCola");
        Company company2 = new Company("Bayer");
        Company company3 = new Company("CocoChanel");

        company1.getEmployees().add(emp1);
        company2.getEmployees().add(emp2);
        company3.getEmployees().add(emp3);
        emp1.getCompanies().add(company1);
        emp2.getCompanies().add(company2);
        emp3.getCompanies().add(company3);

        employeeDao.save(emp1);
        employeeDao.save(emp2);
        employeeDao.save(emp3);
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        //When
        List list1 = employeeDao.retrieveByLastName("Kowal");
        List list2 = companyDao.retrieveCompanies("Coc");

        //Then
        Assert.assertEquals(1, list1.size());
        Assert.assertEquals(2, list2.size());

        //Cleanup
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }
}