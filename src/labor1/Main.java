package labor1;

import labor1.Car;

public class Main {
    public static void main(String[] args) {
//        labor1.Player player1 = new labor1.Player("Tom", 100, 50, 0, 0);
//        labor1.Player player2 = new labor1.Player("David", 100, 50, 0, 0);
//
////        Hash comparison
//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println(player1 == player2);
//
////        Void methods
//        System.out.println(player1);
//        player1.moveUp(3);
//        System.out.println(player1);

        Car car1 = new Car("NVT-184", 7, true);
        Car car2 = new Car();
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car1.equals(car2));
    }
}