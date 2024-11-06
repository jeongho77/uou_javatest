package middle;

interface Mp3 {
    static final int VOLUME_MAX = 30;
    static final int VOLUME_MIN = 0;

    void play();
    void stop();

    void volumeUp();
    void volumeDown();
    int volumeChange(int i);
}
