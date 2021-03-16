package dnb.no.reskill.onlineretailer.bizlayer;

import dnb.no.reskill.onlineretailer.models.Product;

public interface ProductService {

        void addToStock(Product product);
        void deleteFromStock(int productId);
        void updateStock(Product product);
        Product findInStock(int productId);


        double getVat(double price);
        void adjustPriceByPercentage(int productId, double byPercent);


}


