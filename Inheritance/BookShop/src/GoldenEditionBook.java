public class GoldenEditionBook extends Book{
    private final double PRICE_INCREASE_COEFFICIENT = 1.3;
    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(double price){
        super.setPrice(price * PRICE_INCREASE_COEFFICIENT);
    }
}
