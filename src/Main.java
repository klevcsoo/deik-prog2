public class Main {
    public static void main(String[] args) {
//        Player player1 = new Player("Tom", 100, 50, 0, 0);
//        Player player2 = new Player("David", 100, 50, 0, 0);
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