package dnb.no.reskill.onlineretailer.models;

import javax.persistence.*;


@Entity
@Table(name = "Product")
public class Product {

//    public static final int DUMMY_ID = -1;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id = -1;
    private String name;
    private double price;

    @Column(name = "instock")
    private long instock;

    public Product(){}

    public Product(String name, double price, long inStock){
        this(-1, name, price, inStock);
    }

    public Product(int id, String name, double price, long inStock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.instock = inStock;
    }

//    public static int getDummyId() {
//        return DUMMY_ID;
//    }

    public long getInstock() {
        return instock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInstock(long instock) {
        this.instock = instock;
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
                ", instock=" + instock +
                '}';
    }
}
