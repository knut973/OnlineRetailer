package dnb.no.reskill.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private VatConfig vatrepository;


    @Override
    public void addToStock(Product product) {
        repository.addProduct(product);

    }

    @Override
    public void deleteFromStock(int productId) {
        repository.deleteProduct(productId);

    }

    @Override
    public void updateStock(Product product) {
        repository.updateProduct(product);

    }

    @Override
    public Product findInStock(int productId) {
        return repository.findProduct(productId);
    }

    @Override
    public double getVat(double price) {


        MyVatBean a = vatrepository.vatBean25();
        MyVatBean b = vatrepository.vatBean27();
        MyVatBean c = vatrepository.vatBean50();

       if (price < 100){
        return price * a.getPercent();


       }
       if (price >101 && price < 1000){
           return price * b.getPercent();
       }

       else{
           return price * c.getPercent();
       }




}
}
