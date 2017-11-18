import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Double money;
    private List<Product> products;

    public Person (String name, Double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getNmae(){
        return this.name;
    }
    private void setName(String name){
        if (name == null){
            throw new NullPointerException("Name can not be null.");
        }
        if (name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public Double getMoney(){
        return this.money;
    }
    private void setMoney(Double money){
        if(money == null){
            throw new NullPointerException("Money can not be null.");
        }
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product){
        if(canAfford(product)){
            this.money -= product.getPrice();
            this.products.add(product);
        }
    }
    public boolean canAfford(Product product){
        boolean isAffordable = this.money >= product.getPrice();
        return isAffordable;
    }
    public String toString(){
        StringBuilder formated = new StringBuilder();

        formated.append(String.format("%s - ", this.name));
        if (this.products.size() > 0){
            for (Product product : this.products) {
                formated
                        .append(product)
                        .append(", ");
            }
            formated.delete(formated.length()-2, formated.length());
        }
        else{
            formated.append("Nothing bought");
        }

        return formated.toString();
    }
}
