package dnb.no.reskill.onlineretailer;

import dnb.no.reskill.onlineretailer.bizlayer.ProductService;
import dnb.no.reskill.onlineretailer.datalayer.ProductRepository;
import dnb.no.reskill.onlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/stock")
@CrossOrigin
public class Controller {

    @Autowired ProductService service;


    //get one product
    @GetMapping(value = "/products/{id}", produces = {"application/json"})
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product p =  service.findInStock(id);
        if (p==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(p);
        }
    }


    //get all products
    @GetMapping(value = "/products", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Product>> getAllProducts(){
        Collection<Product> products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
        }

    //update product
    @PutMapping(value="/products/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product product) {
        if (!service.updateStock(product))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }


    //create
    @PostMapping(
            value="/productsResult{addProd}",
            consumes={"application/x-www-form-urlencoded"},
            produces={"application/json"})
    public ResponseEntity<Product> addProductToStock( Product product) {
        System.out.println(product);
        service.addToStock(product);
        URI uri = URI.create("/products/" + product.getId());
        return ResponseEntity.created(uri).body(product);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        if (!service.deleteFromStock(id))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }



    @GetMapping(value = "/productsResult", produces = {"application/json"})
    public Product idInput(@RequestParam int input){
        Product p =  service.findInStock(input);
            return p;
    }


    @GetMapping(value = "/productsResult/{getall}", produces = {"application/json"})
    public ResponseEntity<Collection<Product>> getAll(){
        Collection<Product> products = service.getAllProducts();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/productsResult/{getTotalValue}", produces = {"application/json"})
    public ResponseEntity<Double> getTotalValue(){
        double stockValue = service.getTotalStockValue(service.getAllProducts());
        return ResponseEntity.ok().body(stockValue);
    }


    @GetMapping("/productsResult{delete}")
    public ResponseEntity<Void> deleteProdWeb(@RequestParam int id) {
        if (!service.deleteFromStock(id))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }


}
