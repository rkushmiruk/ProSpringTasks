package com.kushmiruk.chapter04.groovyconfig

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericXmlApplicationContext

def ctx = new GenericXmlApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx)

reader.beans {
    contact(Contact ,firstName: 'Roman', lastName:'Kushmyruk', age: 23)
}

ctx.refresh();

println ctx.getBean("contact")