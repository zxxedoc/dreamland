package com.zxx.dreamland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxx.dreamland.dao.UserInfoMapper;
import com.zxx.dreamland.entity.UserInfo;
import com.zxx.dreamland.service.UserInfoService;

/**
 * Created by wly on 2017/12/15.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfo findByUid(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setuId(id);
        return userInfoMapper.selectOne(userInfo);
    }

    public void update(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    public void add(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }
}
