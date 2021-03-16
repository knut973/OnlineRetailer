package dnb.no.reskill.onlineretailer;

public interface ProductService {

        void addToStock(Product product);
        void deleteFromStock(int productId);
        void updateStock(Product product);
        Product findInStock(int productId);

        double getVat(double price);


}


