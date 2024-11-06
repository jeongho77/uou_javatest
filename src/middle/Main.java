package middle;
//class StaticExam{
//    static int a;
//    static int getA(){return a;}
//    int b;
//    int getB() {return b;}
//    int f1() {return getA();}
//    int f2() {return getB();}
//}
//
//class Area{
//    int x,y;
//
//    public Area(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public Area(int x) {
//        this(x,5);
//    }
//
//    public void show() {
//        System.out.println("면적은" + x*y + "이다");
//    }
//}

class Person2{
    String name;
}
class Man extends Person2{
    double weight ;
    int age;
}

final class Circle2{
    public static final double PI2 = 3.14;
    public void show() {
        System.out.println("원주율은" + PI2 + "이다");
    }
}

class Circle3{
    public void show() {
        int radius = 5;
        System.out.println("원의 면적은" + Circle2.PI2*radius*radius + "이다");
    }
}

abstract class Color{
    protected String name;
    abstract public void paint();
}

class ColorPaint extends Color{
    public ColorPaint(String name) {
        this.name = name;
    }

    @Override
    public void paint() {
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {

//        middle.Pen sharp = new SharpPencil();
//        sharp.PenClass(100, 1, "red");

        SmartPhone mySmartPhone = new SmartPhone();



//        String a = "Ulsan";
//        String c = a;
//        String b = new String("Hello");
//        String d = new String("Hello");
//        StringBuffer sb = new StringBuffer("hello");
//
//        if (a.equals(c))
//            System.out.println("a equals c");
//        if(a == c) {
//            System.out.println("a == c");
//        }
//        if(b.equals(d))
//            System.out.println("b equals d");
//        if(b == d)
//            System.out.println("b == d");
//
//        System.out.println(sb.append("world"));
//        System.out.println(sb.delete(1,4));




//        middle.ColorPaint colorPaint = new middle.ColorPaint("Red");
//        colorPaint.paint();
//
//        middle.Person2 p = new middle.Man();
//        p.name="홍길동";
//
//        middle.Man m = (middle.Man) p;
//
//        middle.Person2 p2 = new middle.Man();
//
//        p2.name = "김삿갓";
//
//        m.weight = 75.3;
//        m.age = 25;
//        System.out.println(p.name + " " + m.weight + " " + m.age);
//
//        middle.Circle3 c = new middle.Circle3();
//        c.show();

//        middle.D d = new middle.D();
//        d.f3();

//        StaticExam se = new StaticExam();
//        StaticExam.a = 15;
//        se.b = 10;
//        se.b = 15;
//        System.out.println("getA()=" + StaticExam.getA() + " getB()=" + se.getB());
//        System.out.println("f1()=" + se.f1() + " f2()=" + se.f2());
//
//
//        Area a = new Area(3);
//        a.show();
    }
}