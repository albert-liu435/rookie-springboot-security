package com.rookie.bigdata.service;

import com.rookie.bigdata.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
public interface SysUserService extends IService<SysUser> {


    /**
     * 根据用户名查询用户的信息
     *
     * @param userName
     * @return
     */
    SysUser getSysUserByName(String userName);
}
