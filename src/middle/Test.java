package middle;

class A{ }
class B extends A{ }
class C extends B{ }
class D extends B{ }
public class Test {
    static void show(A a) {
        if (a instanceof A)
            System.out.print("middle.A ");
        if (a instanceof B)
            System.out.print("middle.B ");
        if (a instanceof C)
            System.out.print("middle.C ");
        if (a instanceof D)
            System.out.print("middle.D ");
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.print("new middle.A()==>"); show(new A());
        System.out.print("new middle.B()==>"); show(new B());
        System.out.print("new middle.C()==>"); show(new C());
        System.out.print("new middle.D()==>"); show(new D());
    }
}