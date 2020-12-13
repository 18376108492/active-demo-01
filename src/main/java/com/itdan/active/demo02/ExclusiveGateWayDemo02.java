package com.itdan.active.demo02;


import com.itdan.active.demo.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 排他网关测试用例
 */
public class ExclusiveGateWayDemo02 {

    //1.创建流程定义，部署流程
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //创建流程
//        Deployment deployment = repositoryService.createDeployment()
//                .addClasspathResource("diagram/demo02/leave.bpmn")//添加流程BPM文件
//                .name("排他网关请假流程")
//                .deploy();

        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/demo02/leave01.bpmn")
               // .addClasspathResource("diagram/holiday.png")
                .name("排他网关请假流程")
                .deploy();
        //输出部署信息
        System.out.println("部署流程ID："+deploy.getId());
        System.out.println("部署流程名称："+deploy.getName());
        System.out.println("部署流程Key："+deploy.getKey());


        //创建流程后，启动流程
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //创建请假对象
        Holiday holiday=new Holiday();
        //创建map用于存储流程信息
        Map<String,Object> map=new HashMap<>();
        holiday.setNum(5F);
        map.put("holiday",holiday);
        //创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave_01", map);
        System.out.println("启动流程实例ID:"+processInstance.getId());
        System.out.println("启动流程实例名称"+processInstance.getName());
        System.out.println("启动流程实例流程定义ID"+processInstance.getProcessInstanceId());

       // 启动流程后，就需要流程实例中不同流程节点定义的用户账号去完成任务，走流程

    }
}
