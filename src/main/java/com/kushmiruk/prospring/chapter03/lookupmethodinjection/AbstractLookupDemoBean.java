package com.kushmiruk.prospring.chapter03.lookupmethodinjection;

public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation(){
        getMyHelper().doHelpful();
    }
}
