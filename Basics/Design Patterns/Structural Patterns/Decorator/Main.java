public class Main {
    public static void main(String[] args) {
        //basic
        Pizza basic = new Basic();

        Pizza cheesepizza = new Cheese(basic);

        Pizza chickenpizza = new Chicken(basic);

        Pizza deluxechic = new Chicken(cheesepizza);

        System.out.println(basic.getDescription() +" Rs." + basic.getCost());
        System.out.println(cheesepizza.getDescription() +" Rs." + cheesepizza.getCost());
        System.out.println(chickenpizza.getDescription() +" Rs." + chickenpizza.getCost());
        System.out.println(deluxechic.getDescription() +" Rs." + deluxechic.getCost());

    }
}
