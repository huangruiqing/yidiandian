package com.huang.datasourcemulti.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysAccountMapper
 * @Description
 * @Author huangrq
 * @Date 2019/2/15 14:15
 */
public interface SysAccountMapper {

    public List<String> getList(Map<String,Object> param);


}
