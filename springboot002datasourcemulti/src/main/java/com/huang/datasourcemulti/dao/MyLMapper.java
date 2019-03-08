package com.huang.datasourcemulti.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MyLMapper
 * @Description
 * @Author huangrq
 * @Date 2019/2/15 15:08
 */
public interface MyLMapper {
    public List<String> getList(Map<String,Object> param);
}
