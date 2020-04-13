package com.uatx.app.correos.Job;
import com.uatx.app.correos.service.impl.CorreosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class AlertJob {
	private final Logger log = LoggerFactory.getLogger(AlertJob.class);

	@Autowired
	private CorreosServiceImpl correo;

    @Async
    @Scheduled(cron="0 0 12 * * ?") // A las 12 del mediodía cada día.
    public void heavyWorkSync1() {
        correo.mandarCorreos();
    }

}
