import java.util.Collections;

public class Predator extends Animal{
    private int health;

    public void feed(Food food){
        super.foodEaten.add(food);
        health += 1;
    }

    public void feedAll(Food[] foods){
        Collections.addAll(super.foodEaten, foods);
        this.health += foods.length;
    }
}
