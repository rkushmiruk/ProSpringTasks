package com.kushmiruk.chapter04.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    public static void main(String[] args) throws IOException {
        File file =File.createTempFile("test","txt");
        file.deleteOnExit();
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/propertyeditor/app-context-xml.xml");
        context.refresh();

        PropertyEditorBean propertyEditorBean = (PropertyEditorBean) context.getBean("builtInSample");
    }
}
