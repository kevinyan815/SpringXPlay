package kev.spring.springbucks.jpamysqldemo;

import kev.spring.springbucks.jpamysqldemo.model.Coffee;
import kev.spring.springbucks.jpamysqldemo.model.CoffeeOrder;
import kev.spring.springbucks.jpamysqldemo.service.CoffeeOrderService;
import kev.spring.springbucks.jpamysqldemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class JpaMysqlDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService coffeeOrderService;

    public static void main(String[] args) {
        SpringApplication.run(JpaMysqlDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
    }

    private void initOrders() {
        Coffee newLatte = coffeeService.saveCoffee("new latte", Money.of(CurrencyUnit.of("CNY"), 30.00));
        Coffee newEspresso = coffeeService.saveCoffee("new espresso", Money.of(CurrencyUnit.of("CNY"), 20.00));
        log.info("Coffee: {}", newLatte);
        log.info("Coffee: {}", newEspresso);

        log.info("Total Coffee: {}", coffeeService.getCoffeeCount());

        CoffeeOrder order = coffeeOrderService.createOrder("Li Lei", new Coffee[]{newLatte, newEspresso});
        log.info("Order: {}", order);

    }
}
