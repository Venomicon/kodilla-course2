package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.ItemDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = InvoiceDao.class)
public class InvoiceTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");
        Product product4 = new Product("Product 4");
        Item item1 = new Item(product1, new BigDecimal(10), 1, new BigDecimal(10));
        Item item2 = new Item(product2, new BigDecimal(10), 5, new BigDecimal(50));
        Item item3 = new Item(product3, new BigDecimal(50), 2, new BigDecimal(100));
        Invoice invoice1 = new Invoice("Invoice #1");
        Invoice invoice2 = new Invoice("Invoice #2");

        product1.setItem(item1);
        product2.setItem(item2);
        product3.setItem(item3);
        item1.getProducts().add(product1);
        item1.getProducts().add(product2);
        item2.getProducts().add(product3);
        item3.getProducts().add(product4);
        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int id1 = invoice1.getId();
        int size2 = invoice2.getItems().size();

        //Then
        Assert.assertNotEquals(0, id1);
        Assert.assertTrue(size2 > 0);

        //CleanUp
        //invoiceDao.deleteById(id1);
        //invoiceDao.deleteById(invoice2.getId());
    }
}
