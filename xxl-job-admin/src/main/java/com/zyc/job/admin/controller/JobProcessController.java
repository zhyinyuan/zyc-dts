package com.zyc.job.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyc.job.admin.core.exception.XxlJobException;
import com.zyc.job.admin.core.model.JobProcess;
import com.zyc.job.admin.core.model.XxlJobGroup;
import com.zyc.job.admin.core.model.XxlJobInfo;
import com.zyc.job.admin.core.model.XxlJobUser;
import com.zyc.job.admin.core.route.ExecutorRouteStrategyEnum;
import com.zyc.job.admin.core.thread.JobTriggerPoolHelper;
import com.zyc.job.admin.core.trigger.TriggerTypeEnum;
import com.zyc.job.admin.core.util.I18nUtil;
import com.zyc.job.admin.dao.XxlJobGroupDao;
import com.zyc.job.admin.service.JobProcessService;
import com.zyc.job.admin.service.LoginService;
import com.zyc.job.admin.service.XxlJobService;
import com.zyc.job.core.biz.model.ReturnT;
import com.zyc.job.core.enums.ExecutorBlockStrategyEnum;
import com.zyc.job.core.glue.GlueTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@Controller
@RequestMapping("/jobprocess")
public class JobProcessController {

	@Resource
	private JobProcessService jobProcessService;

    @RequestMapping
    public String index(HttpServletRequest request, Model model, @RequestParam(required = false, defaultValue = "-1") int jobGroup) {

        return "jobprocess/jobprocess.index";
    }

    @RequestMapping("/pageList")
    @ResponseBody
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length/*,
                                        int jobGroup, int triggerStatus, String jobDesc, String executorHandler, String author*/) {

        return jobProcessService.pageList(start, length);
    }
    @RequestMapping("/jobEditPage")
    public String jobEditPage( int operFlag,@RequestParam(required = false, defaultValue = "") String pid, Model model){
        //操作方式为新增
        if(operFlag == 1){
            model.addAttribute("operFlag","add");
            model.addAttribute("pid","");
        }else if(operFlag == 2){
            if(pid != null && !"".equals(pid)){
                model.addAttribute("operFlag","edit");
                model.addAttribute("pid",pid);
            }else{
                return "jobprocess/jobprocess.index";
            }
        }

        return "jobprocess/jobprocess.edit";
    }

	@RequestMapping("/saveMyflow")
	@ResponseBody
	public ReturnT<String> saveMyflow(String  flows, String flag, Model model){
        if (flag != null) {
            JSONObject flowJson = JSON.parseObject(flows);
            JobProcess jobProcess = new JobProcess();
            jobProcess.setPid(flowJson.getString("pid"));
            jobProcess.setPname(flowJson.getString("pname"));
            jobProcess.setPnote(flowJson.getString("pdesc"));
            jobProcess.setPcontext(flows);
            if ("add".equals(flag)) {
                jobProcessService.save(jobProcess);
                return ReturnT.SUCCESS;
            } else if ("edit".equals(flag)) {
                jobProcessService.update(jobProcess);
                return ReturnT.SUCCESS;
            }
        }
        return ReturnT.FAIL;
	}

	@RequestMapping("/getJob")
	@ResponseBody
	public Map<String, Object> getJob(String  pid, Model model){
        JobProcess process = jobProcessService.getJob(pid);
        Map<String, Object> map = new HashMap<>();
        map.put("process", process);
        return map;
	}
}
