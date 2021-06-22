package kev.spring.springbucks.waiter.controller;

import kev.spring.springbucks.waiter.model.Coffee;
import kev.spring.springbucks.waiter.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    /**
     * 查询所有Coffee信息
     *
     * @return List<Coffee>
     */
    @GetMapping(path = "/", params = "!name")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }

    /**
     * 查询ID对应的Coffee信息
     *
     * @param id
     * @return Coffee
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Coffee getById(@PathVariable Long id) {
        log.info("id " + id);
        Coffee coffee = coffeeService.getCoffee(id);
        return coffee;
    }

    /**
     * 查询name对应的Coffee信息
     *
     * @param name
     * @return Coffee
     */
    @GetMapping(path = "/", params = "name")
    @ResponseBody
    public Coffee getByName(@RequestParam String name) {
        return coffeeService.getCoffee(name);
    }
}
