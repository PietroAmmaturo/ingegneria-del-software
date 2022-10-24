package esercitazione4.es0.ambiguous.esempio1;

class Class1 {
}

class Class2 extends Class1 {
}

class ExtClass1 {
    public void m1 (Class1 x, Class2 z) {
        System.out.println("EXTCLASS1");
    }
}

class ExtClass2 extends ExtClass1 {
    public void m1 (Class2 x, Class1 z) {
        System.out.println("EXTCLASS2");
    }
}
