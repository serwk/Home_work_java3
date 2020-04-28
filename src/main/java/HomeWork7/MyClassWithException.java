package HomeWork7;

public class MyClassWithException {
    @BeforeSuite
    public void init() {
        System.out.println("init");
    }

    @BeforeSuite
    @Test(priority = 3)
    public void test1() {
        System.out.println("test1. priority = 3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("test4. priority = 4");
    }

    public void method() {
        System.out.println("method");
    }

    @AfterSuite
    public void stop() {
        System.out.println("stop");
    }
}
