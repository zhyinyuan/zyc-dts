package com.zyc.job.admin.service.impl;

import com.zyc.job.admin.core.model.JobProcess;
import com.zyc.job.admin.core.model.XxlJobInfo;
import com.zyc.job.admin.dao.JobProcessDao;
import com.zyc.job.admin.dao.XxlJobGroupDao;
import com.zyc.job.admin.service.JobProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobProcessServiceImpl implements JobProcessService {
    private static Logger logger = LoggerFactory.getLogger(XxlJobServiceImpl.class);

    @Resource
    private JobProcessDao jobProcessDao;

    @Override
    public void save(JobProcess jobProcess) {
        jobProcessDao.save(jobProcess);
    }

    @Override
    public Map<String, Object> pageList(int start, int length) {
        // page list
        List<JobProcess> list = jobProcessDao.pageList(start, length);
        int list_count = jobProcessDao.pageListCount(start, length);

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", list_count);		// 总记录数
        maps.put("recordsFiltered", list_count);	// 过滤后的总记录数
        maps.put("data", list);  					// 分页列表
        return maps;
    }

    @Override
    public JobProcess getJob(String pid) {
        return jobProcessDao.getJob(pid);
    }

    @Override
    public void update(JobProcess jobProcess) {
        jobProcessDao.update(jobProcess);
    }
}
