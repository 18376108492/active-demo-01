package com.itdan.active.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 任务查询和任务处理
 */
public class TaskTest {
    public static void main(String[] args) {
        //启动一个流程
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //taskService获取任务实例
        TaskService taskService = processEngine.getTaskService();
        //获取任务列表
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();
        //展示任务列表
        for (Task task:list){
            System.out.println("任务名"+task.getName());
            System.out.println("任务ID"+task.getId());
            //假装处理任务
            taskService.complete(task.getId());//数据库任务表的任务结束时间会有值
        }

    }
}
