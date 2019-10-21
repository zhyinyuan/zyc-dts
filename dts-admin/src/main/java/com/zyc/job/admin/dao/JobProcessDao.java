package com.zyc.job.admin.dao;

import com.zyc.job.admin.core.model.JobProcess;
import com.zyc.job.admin.core.model.XxlJobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
@Mapper
public interface JobProcessDao {


	void save(JobProcess jobProcess);

	List<JobProcess> pageList(int start, int length);

	int pageListCount(int start, int length);

	JobProcess getJob(String pid);

	void update(JobProcess jobProcess);
}
