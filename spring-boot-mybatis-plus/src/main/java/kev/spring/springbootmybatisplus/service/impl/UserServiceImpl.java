package kev.spring.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kev.spring.springbootmybatisplus.mapper.UserMapper;
import kev.spring.springbootmybatisplus.model.User;
import kev.spring.springbootmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
