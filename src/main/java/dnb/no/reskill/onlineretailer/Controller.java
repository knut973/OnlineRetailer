package dnb.no.reskill.onlineretailer;

import dnb.no.reskill.onlineretailer.bizlayer.ProductService;
import dnb.no.reskill.onlineretailer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;


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

    //create product
    @PutMapping(value="/products/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product product) {
        if (!service.updateStock(product))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }


    //create
    @PostMapping(
            value="/products",
            consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
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
    public String idInput(@RequestParam int input){

        String p =  service.findInStock(input)
                .toString();

        String allProd = service.getAllProducts()
                .stream()
                .map(c -> c.toString())
                .reduce("", String::concat);


        if (input == 100){
            return allProd;
        }
        else
            return p;
    }

    @GetMapping(value = "/stock/productsResult{}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Product>> getAll(){

        Collection<Product> products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }




}
