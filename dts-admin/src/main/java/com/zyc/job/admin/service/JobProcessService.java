package com.zyc.job.admin.service;


import com.zyc.job.admin.core.model.JobProcess;
import com.zyc.job.admin.core.model.XxlJobInfo;
import com.zyc.job.core.biz.model.ReturnT;

import java.util.Date;
import java.util.Map;

public interface JobProcessService {

	void save(JobProcess jobProcess);

	Map<String, Object> pageList(int start, int length);

	JobProcess getJob(String pid);

	void update(JobProcess jobProcess);
}
