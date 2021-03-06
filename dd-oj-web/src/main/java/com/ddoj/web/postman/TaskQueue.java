package com.ddoj.web.postman;

import com.ddoj.web.postman.task.BaseTask;
import com.ddoj.web.postman.task.BaseTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhengtt
 **/
@Component
public class TaskQueue {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private BlockingQueue<BaseTask> taskQueue;

    public TaskQueue() {
        taskQueue = new LinkedBlockingQueue<>();
    }

    public void addTask(BaseTask task) {
        taskQueue.add(task);
    }

    public BaseTask take() {
        try {
            return taskQueue.take();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
