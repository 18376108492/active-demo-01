package com.itdan.active.demo;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.动态赋值,先在经理节点设置${assignee}
 *
 * 2.
 */
public class AssigneeUEL {

    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        //2.设置assignee的取值, 用户可以在界面上设置流程执行人
        Map<String,Object> map=new HashMap<>();
        map.put("assignee01","zhangsan");
        map.put("assignee01","lisi");
        map.put("assignee01","wangwu");
        map.put("assignee02","wangwu");
        map.put("assignee03","lisi");
        //4.启动流程实例，同时还要设置流程定义的assignee的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", map);

        //5.输出
        System.out.println(processEngine.getName());
    }
}
