package middle;

class Person15 {
    String name;
    public Person15(String name) {
        this.name = name;
    }
}
class Student15 extends Person15 {
    String id;
    String grade;
    public Student15(String name) {
        super(name);
    }
}
public class Middle13 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("자바 사랑해");
        sb.insert(3, "너도 ");
        System.out.println(sb);
        sb.append(" 응 정말");
        System.out.println(sb);
        sb.replace(2, 10, " 진짜로 좋아 ");
        System.out.println(sb);
        sb.setLength(5);
        System.out.println(sb);
    }
}