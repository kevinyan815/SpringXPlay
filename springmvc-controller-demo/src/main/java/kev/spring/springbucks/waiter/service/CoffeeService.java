package kev.spring.springbucks.waiter.service;

import kev.spring.springbucks.waiter.model.Coffee;
import kev.spring.springbucks.waiter.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    /**
     * 获取所有Coffee
     *
     * @return List<Coffee>
     */
    @Cacheable
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    /**
     * 获取所有名称匹配的Coffee
     *
     * @param names
     * @return
     */
    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }

    /**
     * 通过ID获取Coffee
     *
     * @param id
     * @return
     */
    public Coffee getCoffee(Long id) {
        return coffeeRepository.findById(id).get();
    }

    /**
     * 通过name 获取Coffee
     *
     * @param name
     * @return
     */
    public Coffee getCoffee(String name) {
        return coffeeRepository.findByName(name);
    }
}
