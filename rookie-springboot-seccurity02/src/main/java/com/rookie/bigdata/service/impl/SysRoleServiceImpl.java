package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.entity.SysRole;
import com.rookie.bigdata.mapper.SysRoleMapper;
import com.rookie.bigdata.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer id) {


        return sysRoleMapper.getRoleByUserId(id);
    }


}
