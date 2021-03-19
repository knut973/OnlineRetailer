package dnb.no.reskill.onlineretailer;

import dnb.no.reskill.onlineretailer.datalayer.ProductRepository;
import dnb.no.reskill.onlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Collection;


@Component
public class Tester {


    @Qualifier("productRepositoryH2Database")
    @Autowired
    private ProductRepository repository;

        public void doDemo() {

            try {

                //add new product
                System.out.println("Adding toy car");
                Product p = new Product("Toycar", 99, 50);
                repository.addProduct(p);
                System.out.println("Id of " +p.getName() + ": " +p.getId());


                System.out.println("Adding real car, with id -1");
                Product p10 = new Product(-1, "Realcar", 999, 11);
                repository.addProduct(p10);
                System.out.println("Id of " +p10.getName() + ": " +p10.getId());


                //find product
                System.out.println("This is the product just added:");
                System.out.println(repository.findProduct(p.getId())+"/n");

                //Print all products
                printAllProducts();

                //Delete and print again
                repository.deleteProduct(6);
                System.out.println("\nProduct deleted");
                printAllProducts();

                //insert new product
                System.out.println("\nAdding ice cream");
                Product p5 = new Product("Icecream", 20, 75);
                repository.addProduct(p5);
                printAllProducts();

                System.out.println("\ndoubling the stock of icecream and increase price by 10%");
                Product p6 = repository.findProduct(8);
                p6.setInstock(150);
                p6.setPrice(p6.adjustPriceByPercentage(10));
                repository.updateProduct(p6);
                System.out.println(repository.findProduct(8));


            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    private void printAllProducts() {
        Collection<Product> prod = repository.getAllProducts();
        for (Product s:prod){
            System.out.println(s);
        }
    }


}
