package dnb.no.reskill.onlineretailer.datalayer;


import dnb.no.reskill.onlineretailer.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryCrud extends CrudRepository<Product, Long> {


}
