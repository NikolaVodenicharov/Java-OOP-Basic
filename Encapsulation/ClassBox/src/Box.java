public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Double surfaceArea(){
        Double area = 2*this.length*this.height + 2*this.width*this.height + 2*this.length*this.width;
        return area;
    }

    public Double lateralArea(){
        Double area = 2*this.length*this.height + 2*this.width*this.height;
        return area;
    }

    public Double volume(){
        Double vol = this.height * this.width * this.length;
        return vol;
    }
}
