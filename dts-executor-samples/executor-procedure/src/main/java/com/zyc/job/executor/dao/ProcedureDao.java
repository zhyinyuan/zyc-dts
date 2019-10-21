package com.zyc.job.executor.dao;

import org.apache.ibatis.annotations.Mapper;


import java.util.Map;
@Mapper
public interface ProcedureDao {
    public int insertProcedure(Map<String,Object> paramsMap);
}
