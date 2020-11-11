package com.itdan.active.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 将正在运行的流程挂起
 */
public class SunpendProcessInstance01 {

    public static void main(String[] args) {

        //1.获取流程定义列表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //2.创建查询条件
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("2501").singleResult();
        //3.判断是否为挂起状态
        boolean suspended = processInstance.isSuspended();
        if(suspended){
            //挂起
            runtimeService.activateProcessInstanceById(processInstance.getId());
        }else {
            runtimeService.suspendProcessInstanceById(processInstance.getId());
        }
    }
}
