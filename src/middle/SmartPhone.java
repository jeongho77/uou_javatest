package middle;

public class SmartPhone implements Mp3, MobilePhone{
    int i = 0;

    public void sendCall(){
        System.out.println("전화연결중");
    }

    public void receiveCall(){
        System.out.println("전화걸림");
    }

    public void stop(){
        System.out.println("음악 재생 중지");
    }

    public void play(){
        System.out.println("음악 재생");
    };

    public int volumeChange(int i){
        this.i = i;

        if(i > Mp3.VOLUME_MAX || VOLUME_MIN > i) {
            this.i = 5;
        }
        return this.i;
    }

    public void volumeUp(){
        this.i++;
        if(VOLUME_MAX < i) {
            this.i = VOLUME_MAX;
        }
    };

    public void volumeDown(){
        this.i--;
        if(VOLUME_MIN > i) {
            this.i = VOLUME_MIN;
        }
    }
}
