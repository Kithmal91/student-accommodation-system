package cw.sas.application;

import cw.sas.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 11/7/2015.
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
        final UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        // final SystemUser lahiru = userService.getUser("Lahiru");
        //System.out.println(lahiru);
        //userService.saveUser("TTTTT");
    }
}
