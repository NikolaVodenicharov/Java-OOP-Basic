import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push (String item){
        data.add(item);
    }
    public String pop (){
        int lastIndex = data.size() - 1;
        String removed = data.get(lastIndex);
        data.remove(lastIndex);

        return removed;
    }
    public String peek(){
        int lastIndex = data.size() - 1;
        String last = data.get(lastIndex);

        return last;
    }
    public boolean isEmpty(){
        boolean isCollectionEmpty = data.isEmpty();

        return isCollectionEmpty;
    }
}
