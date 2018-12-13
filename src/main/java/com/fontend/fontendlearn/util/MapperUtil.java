package com.fontend.fontendlearn.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author lulu
 * @since 2018/12/13
 * @param <T>
 * FIXME 特别注意，该接口不能被扫描到，否则会出错
 */
public interface MapperUtil<T> extends Mapper<T>,MySqlMapper<T> {
}
