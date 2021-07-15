package com.rookie.bigdata.service;

import com.rookie.bigdata.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> getRoleByUserId(Integer id);
}
