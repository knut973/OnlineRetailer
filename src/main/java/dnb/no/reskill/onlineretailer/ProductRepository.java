package dnb.no.reskill.onlineretailer;

import java.util.Collection;

public interface ProductRepository {

        void addProduct(Product product);
        boolean deleteProduct(int productId);
        boolean updateProduct(Product product);
        Product findProduct(int productId);


}

