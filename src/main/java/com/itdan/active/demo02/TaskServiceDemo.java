package com.itdan.active.demo02;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 通过登入不同账号去完成不同阶段认为
 *
 */
public class TaskServiceDemo {

    public static void main(String[] args) {
        ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();//获取任务处理服务

     //String username="zhangsan";//设置用户名
        String username="lisi";//设置用户名
      //  String username="wangwu";//设置用户名
       //String username="zhaoliu";//设置用户名
       // String username="qiqi";//设置用户名
      //  String taskName="leave_03";
        String taskName="inclusive_01";

        //获取该用户的代办理节点
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey(taskName)
                .taskAssignee(username)
                .list();
        //输出任务ID

        for (Task task : list){
            System.out.println("输出任务ID："+task.getId());
            if(task!=null){
                //如果该用户待办理任务不为空,将其办理掉
                taskService.complete(task.getId());
                System.out.println("任务办理完成");
            }
        }


    }

}
