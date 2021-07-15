package com.rookie.bigdata.mapper;

import com.rookie.bigdata.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getRoleByUserId(Integer id);

}
