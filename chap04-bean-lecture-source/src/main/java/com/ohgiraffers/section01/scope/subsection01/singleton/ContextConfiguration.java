package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {

        return new Bread("붕어빵", 5000, new Date());
    }
    @Bean
    public Product milk() {

        return new Beverage("우유", 2000, 2);
    }
    @Bean
    public Product water() {

        return new Beverage("삼다수", 1500, 1);
    }


    @Bean
    @Scope("singleton")
    public ShoppingCart plastic() {

        return new ShoppingCart();
    }

}
