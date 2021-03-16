package dnb.no.reskill.onlineretailer.datalayer;

import dnb.no.reskill.onlineretailer.models.Product;

import java.util.Collection;

public interface ProductRepository {
//create, read, update, delete

        Product addProduct(Product product);
        Collection<Product> getAllProducts();
        boolean deleteProduct(int productId);
        boolean updateProduct(Product product);
        Product findProduct(int productId);


}

