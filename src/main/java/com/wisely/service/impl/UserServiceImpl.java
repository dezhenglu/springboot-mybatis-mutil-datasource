package com.wisely.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisely.dao.cluster.CityDao;
import com.wisely.dao.master.UserDao;
import com.wisely.domain.City;
import com.wisely.domain.User;
import com.wisely.service.UserService;

/**
 * 用户业务实现层
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("沈阳市");
        user.setCity(city);
        return user;
    }
}
