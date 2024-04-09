package com.ohgiraffers.section02.initdestroy.subsetion03.xml;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.initdestroy.subsection02.annotation.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section02/initdestroy/subsection03/xml/spring-config.xml");

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


        /* 필기.
        *   init 메소드는 bean 객체 생성 시점에 동작하므로 바로 확인할 수 있지만,
        *   destroy 메소드는 bean 객체 생성 시점에 동작하므로 컨테이너가 종료되지
        *   않을 경우 확인할 수 없다.
        *   가비지 컬렉터가 해당 빈을 메모리에서 지울 때 destroy 메소드가 동작하게 되는데
        *   메모리에서 지우기 전에 프로페스는 종료되기 때문이다.
        *   따라서 close() 메소드로 컨테이너를 강제로 종료시키면 destroy 메소드가
        *   동작하게 되는 것이다.
        * */

        ((GenericXmlApplicationContext)context).close();


    }
}
