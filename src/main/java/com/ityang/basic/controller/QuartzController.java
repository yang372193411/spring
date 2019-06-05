package com.ityang.basic.controller;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;

public class QuartzController {

    public static void main(String[] args) {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        try {
            TriggerBuilder<Trigger> builder = TriggerBuilder.newTrigger().withIdentity("yang","defd");
            Scheduler scheduler = null;
            scheduler.deleteJob(new JobKey("id","df"));
            JobDetail jobDetail =new  JobDetailImpl();
            scheduler.scheduleJob(jobDetail, null);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
