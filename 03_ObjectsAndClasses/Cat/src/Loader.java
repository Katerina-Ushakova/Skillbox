import java.awt.*;

public class Loader {
    public static void main(String[] args) {
        //cat1
        Cat cat1 = new Cat();
        System.out.println("Cat1 weight: " + cat1.getWeight());
        cat1.feed(cat1.getWeight() / 10);
        System.out.println("Cat1 weight: " + cat1.getWeight());

        //cat2
        Cat cat2 = new Cat();
        System.out.println("Cat2 weight: " + cat2.getWeight());
        while (!cat2.getStatus().equals("Dead")) {
            cat2.meow();
        }
        System.out.println("Cat2 died");

        //cat3
        Cat cat3 = new Cat();
        System.out.println("Cat3 weight: " + cat3.getWeight());
        while (!cat3.getStatus().equals("Exploded")) {
            cat3.feed(cat3.getWeight() / 40);
        }
        System.out.println("Cat3 exploded");

        //cat4
        Cat cat4 = new Cat();
        System.out.println("Cat4 weight: " + cat4.getWeight());
        cat4.feed(250.5);
        System.out.println("Cat4 weight: " + cat4.getWeight());


        //cat5
        Cat cat5 = new Cat();
        System.out.println("Cat5 weight: " + cat5.getWeight());
        cat5.feed(170.0);
        cat5.pee(5.2);
        cat5.meow();
        cat5.summaFood();
        System.out.println("Cat5 weight: " + cat5.getWeight());

        //cat6
        Cat cat6 = new Cat();
        System.out.println("Cat6 weight: " + cat6.getWeight());
        cat6.setColorCat(ColorCat.WHITE);
        System.out.println("Color cat: " + cat6.getColorCat());

        //cat7 (copy)
        Cat cat7 = Cat.copyCat(cat6);
        System.out.println("Cat7 weight: " + cat7.getWeight());


        System.out.println("Number of cats = " + Cat.getCount());
    }

    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}