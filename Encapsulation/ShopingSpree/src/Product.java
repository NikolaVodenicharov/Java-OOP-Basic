public class Product {
    private String name;
    private Double price;

    public Product (String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    public String getName(){
        return this.name;
    }
    private void setName(String name){
        if (name == null){
            throw new NullPointerException("Name cannot be empty");
        }
        if (name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name can not be empty.");
        }

        this.name = name;
    }

    public Double getPrice(){
        return this.price;
    }
    private void setPrice(Double price){
        if (price == null){
            throw new NullPointerException("Price can not be null.");
        }
        if (price < 0){
            throw new IllegalArgumentException("PMoney cannot be negative");
        }

        this.price = price;
    }

    public String toString(){
        return this.getName();
    }
}
