package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.entity.SysUser;
import com.rookie.bigdata.mapper.SysUserMapper;
import com.rookie.bigdata.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByName(String userName) {


        return sysUserMapper.getSysUserByName(userName);
        //return null;
    }
}
