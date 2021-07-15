package com.rookie.bigdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rookie.bigdata.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getSysUserByName(@Param(value = "userName") String userName);
}
