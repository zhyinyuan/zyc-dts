package com.zyc.job.executor.service.jobhandler;

import com.zyc.job.core.biz.model.ReturnT;
import com.zyc.job.core.handler.IJobHandler;
import com.zyc.job.core.handler.annotation.JobHandler;
import com.zyc.job.core.log.XxlJobLogger;
import com.zyc.job.executor.dao.ProcedureDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/**
 * 任务Handler示例（Bean模式）
 *
 * 开发步骤：
 * 1、继承"IJobHandler"：“IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2015-12-19 19:43:36
 */
@JobHandler(value="demoJobHandler")
@Component
public class DemoJobHandler extends IJobHandler {

	@Resource
	private ProcedureDao procedureDao;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String[]  strArray = param.split(",");
		HashMap<String,Object> params = new HashMap<String,Object>();
		System.out.println("------------"+strArray[0]);
		params.put("procName","NewProc");
		params.put("idParam",strArray[0]);
		params.put("nameParam",strArray[1]);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss SSS");

		XxlJobLogger.log(String.format(strArray[0] +"----记录时间----"+df.format(new Date()) ));

		int ret2 = procedureDao.insertProcedure(params);
		return SUCCESS;
	}

}
