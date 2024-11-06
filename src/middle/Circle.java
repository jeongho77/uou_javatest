package middle;

public class Circle { // 소스 파일 : middle.Circle.java
    int radius; // Circle의 반지름 필드
    String name; // middle.Circle 의 이름 필드
//    public middle.Circle() { } // Circle의 생성자(class 명과 동일)
    public double getArea() { // Circle의 면적 계산 메소드
        return 3.14*radius*radius;
    }
    public static void main(String[] args) {
        Circle pizza; //레퍼런스 변수 pizza선언
        pizza = new Circle(); // middle.Circle 객체 생성(객체의 주소를 pizza변수에 대입)
        pizza.radius = 10; // 객체필드 접근
        pizza.name = "자바피자"; // 객체필드 접근

        double area = pizza.getArea(); // 객체메소드 접근
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle donut = new Circle(); // middle.Circle 객체 생성
        donut.radius = 2; // 객체필드 접근
        donut.name = "자바도넛"; // 객체필드 접근

        area = donut.getArea(); // 객체메소드 접근
        System.out.println(donut.name + "의 면적은 " + area);

        Circle[] c = new Circle[5]; // middle.Circle 배열 c 선언

        for(int i=0; i<c.length; i++) // 배열의 개수만큼 객체 생성
            c[i] = new Circle();

    }
}