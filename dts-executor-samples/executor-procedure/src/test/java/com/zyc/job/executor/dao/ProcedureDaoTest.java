package com.zyc.job.executor.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcedureDaoTest {

    @Resource
    private ProcedureDao procedureDao;

    @Test
    public void test() {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("procName","NewProc");
        params.put("idParam",555);
        params.put("nameParam","23131");

        int ret2 = procedureDao.insertProcedure(params);
    }

}