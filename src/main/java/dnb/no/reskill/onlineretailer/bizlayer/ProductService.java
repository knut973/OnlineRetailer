package dnb.no.reskill.onlineretailer.bizlayer;

import dnb.no.reskill.onlineretailer.models.Product;

import java.util.Collection;

public interface ProductService {

        void addToStock(Product product);
        boolean deleteFromStock(int productId);
        boolean updateStock(Product product);
        Product findInStock(int productId);
        Collection<Product> getAllProducts();


        double getVat(double price);
        void adjustPriceByPercentage(int productId, double byPercent);
        double getTotalStockValue(Collection<Product> products);

}


