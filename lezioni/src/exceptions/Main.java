package exceptions;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Ale", StudentType.ARCH);
        try {
            System.out.println("Pippo");
            float media = s.getMedia();
            System.out.println("Pluto");
        } catch (NonHaFattoEsamiException e) {
            System.out.println("non aveva fatto esami");
        }

    }

}