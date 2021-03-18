package dnb.no.reskill.onlineretailer;

import dnb.no.reskill.onlineretailer.bizlayer.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


        ProductService service = ctx.getBean(ProductService.class);
        Tester service2 = ctx.getBean(Tester.class);



        System.out.println(service.getVat(90.0));
        System.out.println(service.getVat(150.0));
        System.out.println(service.getVat(1500.0));


        System.out.println("now");
        service2.doDemo();
    }


}
