package dnb.no.reskill.onlineretailer.bizlayer;

import dnb.no.reskill.onlineretailer.MyVatBean;
import dnb.no.reskill.onlineretailer.datalayer.ProductRepository;
import dnb.no.reskill.onlineretailer.models.Product;
import dnb.no.reskill.onlineretailer.VatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    //todo implement crud repository
    @Autowired
    public ProductServiceImpl(@Qualifier("productRepositoryH2Database") ProductRepository repository){
        this.repository = repository;
    }


    @Autowired
    private VatConfig vatConfig;

//TODO fix vatsetup, autowire to bean


    @Override
    public void addToStock(Product product) {
        repository.addProduct(product);

    }

    @Override
    public boolean deleteFromStock(int productId) {
        repository.deleteProduct(productId);

        return false;
    }

    @Override
    public boolean updateStock(Product product) {
        return repository.updateProduct(product);

    }

    @Override
    public Product findInStock(int productId) {
        return repository.findProduct(productId);
    }

    @Override
    public Collection<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    @Override
    public double getVat(double price) {


       if (price < 100){
           MyVatBean a = vatConfig.vatBean25();
           return price * a.getPercent();

       }
       if (price >101 && price < 1000){
           MyVatBean b = vatConfig.vatBean27();
           return price * b.getPercent();
       }

       else{
           MyVatBean c = vatConfig.vatBean50();
           return price * c.getPercent();
       }


}
    @Override
    public void adjustPriceByPercentage(int productId, double byPercent) {
        Product prod = repository.findProduct(productId);
        if (prod == null) {
            return;
        }
        else{
            prod.adjustPriceByPercentage(byPercent);
        }

    }

    @Override
    public double getTotalStockValue(Collection<Product> products) {
        return repository.getAllProducts()
                .stream()
                .mapToDouble(c -> c.getPrice() * c.getInstock())
                .sum();

    }

}
