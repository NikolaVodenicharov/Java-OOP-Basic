public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getAuthor(){
        return this.author;
    }
    private void setAuthor(String author) {
        if (author == null){
            throw new NullPointerException("Author name can not be null");
        }

        String[] splitName = author.split("\\s+");

        boolean isTwoWords = splitName.length == 2;
        if(!isTwoWords){
            throw new IllegalArgumentException("Author not valid!");
        }

        String secondName = splitName[1];
        char secondNameFrstChar = secondName.charAt(0);
        boolean isDigit = Character.isDigit(secondNameFrstChar);
        if (isDigit) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }
    private void setTitle(String title) {
        if (title == null){
            throw new NullPointerException("Title can not be null");
        }

        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    public double getPrice(){
        return this.price;
    }
    protected void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append(String.format("Price: %.1f",this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
