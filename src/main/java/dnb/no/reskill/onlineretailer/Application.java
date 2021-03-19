package dnb.no.reskill.onlineretailer;

import dnb.no.reskill.onlineretailer.bizlayer.ProductService;
import dnb.no.reskill.onlineretailer.forTesting.Tester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


        ProductService service = ctx.getBean(ProductService.class);
        Tester service2 = ctx.getBean(Tester.class);


        service2.doDemo();
    }


}
