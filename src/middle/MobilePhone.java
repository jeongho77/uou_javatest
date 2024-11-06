package middle;

interface MobilePhone {
    void sendCall();
    void stop();
    default void printLogo(String phone){
        System.out.println(phone);
    }
}
