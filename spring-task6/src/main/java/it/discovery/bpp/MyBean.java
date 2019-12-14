package it.discovery.bpp;

public class MyBean {
    @Init
    public void init() {
        System.out.println("Empty init method");
    }

    //@Init
    //public void init(ApplicationContext context) {
    //    System.out.println("Init method with context");
    //}
}
