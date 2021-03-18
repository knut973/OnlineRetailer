package dnb.no.reskill.onlineretailer.datalayer;
import dnb.no.reskill.onlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository
public class ProductRepositoryH2Database implements ProductRepository {


    // This is the "EntityManager" equivalent of @Autowired.
    // it uses the EntityManagerFactory bean implicitly to create an EntityManager object for us.
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional
    public Product addProduct(Product p){
        entityManager.persist(p);
        return p;
    }


    @Override
    public Collection<Product> getAllProducts() {
        String jpql = "Select p From Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean deleteProduct(int productId) {
        Product p = entityManager.find(Product.class, productId);
        entityManager.remove(p);
        return true;
    }

    @Override
    @Transactional
    public boolean updateProduct(Product p) {
        Product updatedProd = entityManager.find(Product.class, p.getId());
        updatedProd.setId(p.getId());
        updatedProd.setName(p.getName());
        updatedProd.setPrice(p.getPrice());
        updatedProd.setInstock(p.getInstock());

        return true;

    }

    @Override
    public Product findProduct(int productId) {
        Product p = entityManager.find(Product.class, productId);
        return p;
    }

}