package dnb.no.reskill.onlineretailer.models;

public class Product {

    private int id = 1;
    private String name;
    private double price;

    public Product(String name, double price){
        this.name=name;
        this.price=price;
        this.id=id++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId(){
        return id;
    }

    public int setId(){
        return id++;
    }

    public void adjustPriceByPercentage(double percent){
        price *= 1+ percent/100;
    }


}
