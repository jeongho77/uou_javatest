package middle;

public class Song {
    String title, artist, year, country;

    public Song(String title, String artist, String year, String country){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    public Song(){
        this("","","","");
    }

    public void show(){
        System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
    }
}
