package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames) {
            System.out.println("bean = " + bean);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart plastic1 = context.getBean("plastic", ShoppingCart.class);
        ShoppingCart plastic2 = context.getBean("plastic", ShoppingCart.class);

        plastic1.additem(carpBread);
        plastic1.additem(milk);
        plastic2.additem(water);

//        List<Product> products = plastic1.getItem();
//        for(Product p : products){
//            System.out.println(p);
//        }
//        List<Product> products2 = plastic2.getItem();
//        for(Product p : products2){
//            System.out.println(p);
//        }

        System.out.println(plastic1.getItem());
        System.out.println(plastic2.getItem());

        System.out.println("plastic1 해시코드 : "+ plastic1.hashCode());
        System.out.println("plastic2 해시코드 : "+ plastic2.hashCode());


    }
}
