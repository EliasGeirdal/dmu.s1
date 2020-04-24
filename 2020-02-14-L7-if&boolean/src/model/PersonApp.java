package model;

public class PersonApp {

    public static void main(String[] args) {
        Person p1 = new Person("Bent", "Janus", "Christensen", 16, 9, 2019);
        Person p2 = new Person("Søren", "Bente", "Latername", 27, 8, 1990);
        Person p3 = new Person("Jens", "Jensen", "Sidastenafn", 15, 9, 1990);
        
        p1.printPerson();
        System.out.println("Initialer: " + p1.getInit());
        System.out.println("Username: " + p1.getUserName());
        System.out.println("Age: " + p1.age(16, 9, 2019)); // p's age today
        System.out.println("_________________________________________________________________");
        
        p2.printPerson();
        System.out.println("Initialer: " + p2.getInit());
        System.out.println("Username: " + p2.getUserName());
        System.out.println("Age: " + p2.age(16, 9, 2019)); // p's age today
        System.out.println("_________________________________________________________________");
        
        p3.printPerson();
        System.out.println("Initialer: " + p3.getInit());
        System.out.println("Username: " + p3.getUserName());
        System.out.println("Age: " + p3.age(16, 9, 2019)); // p's age today
        System.out.println("_________________________________________________________________");
        // int year = 2019;
        // System.out.println("Er " + year + " skudår: " + p.leapYear(year));
        System.out.println(p1.leapYear(4));
        System.out.println(p1.leapYear(100));
        System.out.println(p1.leapYear(400));
        System.out.println(p1.leapYear(2));
        System.out.println(p1.leapYear(2019));
        System.out.println(p1.leapYear(2012));

    }
}
