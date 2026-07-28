package Test;

class A{
    static void show(){
        System.out.println("A");
    }
}

class B extends A{
    static void show(){
        System.out.println("B");
    }
}

public class Main {
    public static void main(String[] args) {
        B.show();
    }
}

