package com.alanchen.flowable.controller;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Alan Chen
 * @description 请假流程
 * @date 2020/10/16
 */
@RestController
@RequestMapping(value = "leave")
public class LeaveProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 添加请假申请
     * @param userId 用户ID
     * @param descption 请假理由
     * @return
     */
    @GetMapping("/add")
    public String addLeave(@RequestParam String userId,@RequestParam String descption) {
        //启动流程
        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("descption", descption);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Leave", map);
        return "提交成功.流程Id为：" + processInstance.getId();
    }

}
