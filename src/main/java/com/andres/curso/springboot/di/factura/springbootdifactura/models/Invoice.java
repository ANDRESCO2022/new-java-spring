package com.andres.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description.office}")
    private String description;
    @Autowired
    private List<Item> items;
    public Invoice() {
    
    }

    @PostConstruct
    public void init() {
        System.out.println("creando componente");
       client.setName(client.getName().concat("Rodriguez"));
       description = description.concat(" - ").concat(client.getName()).concat(" ").concat(client.getLastname());

    }
   @PreDestroy 
    public void destroy(){
        System.out.println("destruyendo en componente");
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public int getTotal(){
        // int total = 0;
        // for (Item item : items) {
        //     total += + item.getImport();
        // }
        // return total;
        int total =items.stream()
        .map(item->item.getImport())
        .reduce(0,(sum,importe)->sum+importe);
        return total;
    }
   

}
