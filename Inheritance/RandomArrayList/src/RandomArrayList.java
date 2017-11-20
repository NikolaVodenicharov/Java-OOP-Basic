import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList(){
        this.random = new Random();
    }

    public Object getRandomElement(){
        int index = random.nextInt(super.size());
        Object removed = super.get(index);
        Object last = super.get(super.size() - 1);
        super.set(index, last);
        super.remove(super.size()-1);

        return removed;
    }
}
