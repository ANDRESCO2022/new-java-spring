package com.andres.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.andres.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.andres.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {
    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Laptop Lenovo", 1200);
        Product p2 = new Product("mause ", 800);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));

    }
    @Bean
    @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("resma papel", 1000);
        Product p2 = new Product("impresora epson ", 8500);
        Product p3 = new Product("cable HDMI ", 800);
        Product p4 = new Product("cable USB ", 1000);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4),new Item(p3, 5), new Item(p4, 6)
         );

    }

}
