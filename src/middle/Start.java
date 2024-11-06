package middle;

public class Start {
    public static void main(String [] args) {
        SmartPhone mySmartPhone = new SmartPhone();
        mySmartPhone.play();
        System.out.println(mySmartPhone.volumeChange(15));
        mySmartPhone.volumeUp();
        System.out.println(mySmartPhone.i);
        mySmartPhone.printLogo("삼성 갤럭시");
        mySmartPhone.receiveCall();
    }
}
