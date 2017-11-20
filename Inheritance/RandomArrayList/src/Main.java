import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ran = new RandomArrayList();
        ran.add(1);
        ran.add("Steven");
        ran.add(new ArrayList<String>());

        System.out.println(ran.getRandomElement());
    }
}
