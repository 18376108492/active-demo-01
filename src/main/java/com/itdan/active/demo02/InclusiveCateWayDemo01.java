package com.itdan.active.demo02;

import com.itdan.active.demo02.entry.User;
import com.sun.javafx.collections.MappingChange;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

public class InclusiveCateWayDemo01 {

    public static void main(String[] args) {
        //企业体检流程，不同级别的员工体检的项目不一样，根据type来区分流程的走向
        ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/demo02/inclusive_demo02.bpmn")
                .name("含他网关流程")
                .deploy();

        //输出部署信息
        System.out.println("部署流程ID："+deploy.getId());
        System.out.println("部署流程名称："+deploy.getName());
        System.out.println("部署流程Key："+deploy.getKey());


        //部署流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //添加参数
        Map<String,Object> map=new HashMap<>();
        //创建用户
        User user01=new User();
        user01.setUsername("zhangsan");
        user01.setUserType(0);
        User user02=new User();
        user02.setUsername("lisi");
        user02.setUserType(1);
       // map.put("user",user01);
        map.put("user",user02);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("inclusive_01",map);
        System.out.println("启动流程实例ID:"+processInstance.getId());
        System.out.println("启动流程实例名称"+processInstance.getName());
        System.out.println("启动流程实例流程定义ID"+processInstance.getProcessInstanceId());
    }
}
