package kev.spring.springbucks.jpamysqldemo.repository;

import kev.spring.springbucks.jpamysqldemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
