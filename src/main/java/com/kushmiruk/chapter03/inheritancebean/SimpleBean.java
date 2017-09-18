package com.kushmiruk.chapter03.inheritancebean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private String name;
    private int age;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter03/META-INF/spring/inheritancebean/app-context-xml.xml");
        context.refresh();

        SimpleBean parent = (SimpleBean) context.getBean("inheritParent");
        SimpleBean child = (SimpleBean) context.getBean("inheritChild");

        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
