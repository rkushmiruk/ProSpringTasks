package com.kushmiruk.prospring.chapter04.beannameaware;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNamePrinter implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void doSmth(){
        System.out.println("Bean ["+ beanName+ "] - doSmth()");
    }
}
