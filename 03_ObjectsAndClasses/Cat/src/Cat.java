import java.awt.*;
import java.security.PublicKey;

public class Cat
{
    public static final double MIN_WEIGHT = 1000;
    public static final double MAX_WEIGHT = 9000;
    public static final int QUANTILY_EYES = 4;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double weightFood;

    private ColorCat color;

    static int count = 0;


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        color = ColorCat.BLACK;
    }

    public static Cat copyCat (Cat cat) {
        if (cat.getWeight() <= MIN_WEIGHT || cat.getWeight() >= MAX_WEIGHT)
        {
            System.out.println("Dead cats not copy");
        }
        Cat copyCat = new Cat();
        copyCat.weight = cat.getWeight();
        copyCat.color = cat.getColorCat();
        copyCat.originWeight = cat.originWeight;
        return copyCat;
    }


    public void setColorCat(ColorCat color) {
        this.color = color;
    }

    public ColorCat getColorCat() {
        return color;
    }

    public Cat( double selectweight) {
        this();
        this.weight = selectweight;
    }

    public boolean isALive() {
        if (getWeight() >= minWeight && getWeight() <= maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWeightNormal() {
        return (getWeight() > MIN_WEIGHT && getWeight() < MAX_WEIGHT);
    }

    public void meow() {
        if (isALive()) {
            weight = weight - 1;
            System.out.println("Meow");
            if (!isWeightNormal()) {
                count = count - 1;
            }
        } else {
            System.out.println("Dead cats can not meow");
        }
    }

    public void feed(Double amount) {
        if (isALive()) {
            weightFood = amount;
            weight = weight + amount;
            System.out.println("Cat ate");
            if (!isWeightNormal()) {
                count = count -1;
            }
        }else {
            System.out.println("Dead cats can not eat");
        }
    }

   /* public void feed(Double amount) {
        if (isALive()) {
            weightFood = amount;
            weight = weight + amount;
            System.out.println("Cat ate");
        }
        if (!isALive()) {
            System.out.println("Dead cats can not eat");
        }
    }*/

    public void summaFood() {
        System.out.println("Cat ate " + weightFood + "gr");
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public static int getCount() {
        return count;
    }

    public Double getWeight() {
        return weight;
    }

    public void pee(Double amount) {
        if (isALive()) {
            weight = weight - amount;
            System.out.println("Cat went to the toilet");
            if (!isWeightNormal()) {
                count = count - 1;
            }
        } else {
            System.out.println("Cat went to the toilet");
        }
    }
    /*public void pee(Double amount) {
        if (isALive()) {
            weight = weight - amount;
            System.out.println("Cat went to the toilet");
        }
        if (!isALive()) {
            System.out.println("Dead cats can not go to the toilet");
        }
    }*/

    public String getStatus() {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}