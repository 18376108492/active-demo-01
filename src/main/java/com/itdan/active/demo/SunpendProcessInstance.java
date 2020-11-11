package com.itdan.active.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.Date;

/**
 *
 * 激活和挂起流程
 */
public class SunpendProcessInstance {

    public static void main(String[] args) {
        //1.获取流程定义列表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //2.获取流程实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("holiday").singleResult();
        //3.判断流程实例激活状态
        boolean suspended = processDefinition.isSuspended();
        if(suspended){
            //暂停状态
            repositoryService.activateProcessDefinitionById(processDefinition.getId(),true,new Date());
        }else {
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(),false,new Date());
        }
    }
}
