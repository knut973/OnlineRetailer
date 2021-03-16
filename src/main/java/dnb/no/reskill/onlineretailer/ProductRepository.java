package dnb.no.reskill.onlineretailer;

import java.util.Collection;

public interface ProductRepository {
//create, read, update, delete
        
        // FROM ANDY: The product id typically isn't known until after insertion.
        // So this method should return the id,
        // or maybe the entire Product object (with its id assigned).
        void addProduct(Product product);
        
        boolean deleteProduct(int productId);
        boolean updateProduct(Product product);
        Product findProduct(int productId);


}

