package dnb.no.reskill.onlineretailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VatConfig {

    @Bean
    public MyVatBean vatBean25(){
        MyVatBean v = new MyVatBean();
        v.setPercent(25);
        return v;
    }

    @Bean
    public MyVatBean vatBean27(){
        MyVatBean v = new MyVatBean();
        v.setPercent(27);
        return v;
    }

    @Bean
    public MyVatBean vatBean50(){
        MyVatBean v = new MyVatBean();
        v.setPercent(50);
        return v;
    }


}
