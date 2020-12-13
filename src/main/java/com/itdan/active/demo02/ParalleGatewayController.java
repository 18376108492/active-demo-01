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
 * 并行网关测试用例
 */
public class ParalleGatewayController {

    public static void main(String[] args) {

        ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/demo02/leave03.bpmn")
                .name("并行网关流程")
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
        holiday.setNum(1F);
        map.put("holiday",holiday);
        //创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave_03", map);
        System.out.println("启动流程实例ID:"+processInstance.getId());
        System.out.println("启动流程实例名称"+processInstance.getName());
        System.out.println("启动流程实例流程定义ID"+processInstance.getProcessInstanceId());

    }

}
