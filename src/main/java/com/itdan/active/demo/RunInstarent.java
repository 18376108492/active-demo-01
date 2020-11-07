package com.itdan.active.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 流程实例操作
 */
public class RunInstarent {

    public static void main(String[] args) {
        //启动一个流程
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //获取runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //我们需要通过流程的key来让runServie启动哪一个流程
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("holiday");
        //获取流程实例
//        System.out.println(holiday.toString());
        System.out.println("流程实例ID:"+holiday.getId());//流程实例ID
        System.out.println("流程部署ID:"+holiday.getDeploymentId());
        System.out.println("流程业务KEY:"+holiday.getBusinessKey());
        System.out.println("流程活动ID:"+holiday.getActivityId());

//        背后影响的表：
// *       act_hi_actinst     已完成的活动信息
//        act_hi_identitylink   参与者信息
//        act_hi_procinst   流程实例
//        act_hi_taskinst   任务实例
//        act_ru_execution   执行表
//        act_ru_identitylink   参与者信息
//        act_ru_task  任务
    }
}
