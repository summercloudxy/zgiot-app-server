package com.zgiot.app.server.module.historydata.job;

import com.zgiot.app.server.config.ApplicationContextListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

/**
 * 信号汇总定时任务
 */
public class HistoryMinDataJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContext context = ApplicationContextListener.getApplicationContext();
        HistoryMinDataManager historyMinDataManager = (HistoryMinDataManager) context.getBean("historyMinDataManager");
        historyMinDataManager.collectHistoryMinData();
    }
}
