package kev.spring.springbucks.waiter.controller;

import kev.spring.springbucks.waiter.controller.request.NewCoffeeRequest;
import kev.spring.springbucks.waiter.exception.FormValidationException;
import kev.spring.springbucks.waiter.model.Coffee;
import kev.spring.springbucks.waiter.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        log.info("name {}", name);
        return coffeeService.getCoffee(name);
    }

    /**
     * 增加单条咖啡信息
     *
     * @param newCoffee
     * @return
     */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee addCoffee(@Valid NewCoffeeRequest newCoffee) {
        return coffeeService.saveCoffee(newCoffee.getName(), newCoffee.getPrice());
    }

    /**
     * 增加单条咖啡信息
     *
     * @param newCoffee
     * @return
     */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee addCoffeeJson(@RequestBody NewCoffeeRequest newCoffee) {
        return coffeeService.saveCoffee(newCoffee.getName(), newCoffee.getPrice());
    }

    /**
     * 增加单条咖啡信息
     * <p>
     * 区别是请求验证结果放到了BindingResult里，让我们可以自己处理验证异常，
     * 上面的方法是Spring会在请求验证不通过后直接返回错误信息给客户端。
     *
     * @param newCoffee
     * @return
     */
    @PostMapping(path = "/add-with-binding-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee addCoffee(@Valid NewCoffeeRequest newCoffee, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result.toString());
//            throw new FormValidationException(result);
        }
        return coffeeService.saveCoffee(newCoffee.getName(), newCoffee.getPrice());
    }

    /**
     * 批量增加Coffee信息
     * 测试： curl -F "file=@/YourPath/JavaSpring/springmvc-controller-demo/src/main/resources/coffee.txt" \
     * 127.0.0.1:8080/coffee/
     *
     * @param file
     * @return List<Coffee>
     */
    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public List<Coffee> batchAddCoffees(@RequestParam("file") MultipartFile file) {
        List<Coffee> coffees = new ArrayList<>();
        if (!file.isEmpty()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String str;
                while ((str = reader.readLine()) != null) {
                    log.info(str);
                    String[] arr = StringUtils.split(str, " ");
                    if (arr != null && arr.length == 2) {
                        coffees.add(coffeeService.saveCoffee(arr[0], Money.of(CurrencyUnit.of("CNY"),
                                NumberUtils.createBigDecimal(arr[1]))));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("exception: ", e);
            } finally {
                IOUtils.closeQuietly(reader);
            }
        }

        return coffees;
    }
}
