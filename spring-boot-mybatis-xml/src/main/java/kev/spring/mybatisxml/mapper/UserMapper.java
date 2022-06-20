package kev.spring.mybatisxml.mapper;

import java.util.List;

import kev.spring.mybatisxml.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}