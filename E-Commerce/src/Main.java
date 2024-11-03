public class Main {
    public static Service service;
    public static void main(String[] args) {
        service = new Service();
        service.init();
        try {
            service.test1();
            //service.test2();
            //service.test3();
           // service.test4();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // happy

}