package dnb.no.reskill.onlineretailer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Sunglasses", 199.99, 100});
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Hat", 29.49, 10});
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Shorts", 39.99, 50});
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Towel", 10.20, 30});
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Sandals", 19.00, 15});
        jdbcTemplate.update("INSERT INTO Product (name, price, inStock) VALUES(?, ?, ?)", new Object[]{"Sunscreen", 12.49, 125});

    }

}