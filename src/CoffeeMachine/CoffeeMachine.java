package CoffeeMachine;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");
    }
}
