package middle;

import java.util.Scanner;

class Book2{
    String title;
    String author;

    void show(){
        System.out.println(title + " " + author);
    }

    public Book2(){
        this("","");
    }

    public Book2(String title){
        this(title, "작자미상");
    }

    public Book2(String t, String a){
        this.title = t; this.author = a;
    }
}

public class BookArray {
    public static void main(String[] args){
        Book2[] book = new Book2[2];

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < book.length; i++){
            System.out.println("제목>>");
            String title = scanner.nextLine();
            System.out.println("저자>>");
            String author = scanner.nextLine();
            book[i] = new Book2(title,author);
        }

        for(int i =0; i<book.length; i++){
            System.out.println(book[i].title + " " + book[i].author);
        }
        scanner.close();
    }
}
