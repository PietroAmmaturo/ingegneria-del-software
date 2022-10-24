package esercitazione4.es0;

public class Class1 {
    public Class1 () {}

    public void m1() {System.out.println("CLASS1 m1");}

    public void m2() {
        System.out.println("CLASS1 m2");
        m3();
    }

    public void m3() {System.out.println("CLASS1 m3");}
}

class Class2 extends Class1 {

    public void m1() {
        System.out.println("CLASS2 m1");
        super.m1();
    }

    public void m3() {System.out.println("CLASS2 m3");}

}

class Class3 extends Class2 {
    public void m1() {
        System.out.println("CLASS3 m1");
        super.m1();
    }
}
