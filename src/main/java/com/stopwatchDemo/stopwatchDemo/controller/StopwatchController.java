
package com.stopwatchDemo.stopwatchDemo.controller;

import com.stopwatchDemo.stopwatchDemo.model.StopwatchTimer;
import com.stopwatchDemo.stopwatchDemo.service.StopwatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class StopwatchController {

    @Autowired
    StopwatchService stopwatchService;

    @PostMapping("/getStopwatch")
    public StopwatchTimer savePpBasicDetails(@RequestParam @Nullable Boolean doStart, @RequestParam @Nullable Integer id, @RequestParam @Nullable Boolean doStop) {
        StopwatchTimer stopwatchTimer = new StopwatchTimer();
        if(doStart != null && doStart == true && doStop == null || doStop == false)
        {
            stopwatchTimer = stopwatchService.saveStartDetails(doStart);
        }
        else if(doStop != null && doStop == true && doStart == null || doStart == false)
        {
            stopwatchTimer = stopwatchService.saveStopDetails(id,doStop);
        }
       return stopwatchTimer;
    }
}
