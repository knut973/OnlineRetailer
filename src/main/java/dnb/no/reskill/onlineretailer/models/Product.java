package dnb.no.reskill.onlineretailer.models;

import javax.persistence.*;

//todo add lombok getter/setters
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id = -1;
    private String name;
    private double price;

    @Column(name = "instock")
    private long inStock;

    public Product(){}

    public Product(String name, double price, int inStock){
       // this(-1, name, price, inStock);
        this.id=id++;
        this.name=name;
        this.price=price;
        this.inStock = inStock;
    }

    public Product(int id, String name, double price, long inStock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.inStock = inStock;
    }


    public long getInstock() {
        return inStock;
    }

    public void setId(int id) {
        this.id = id++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInstock(long inStock) {
        this.inStock = inStock;
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

    public double adjustPriceByPercentage(double percent){
        price *= 1+ percent/100;
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", instock=" + inStock +
                '}';
    }
}
