package com.uatx.app.correos.Job;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAsync
@EnableScheduling
public class JobConfig {

}
