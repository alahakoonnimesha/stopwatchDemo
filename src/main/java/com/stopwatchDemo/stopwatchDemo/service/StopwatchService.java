package com.stopwatchDemo.stopwatchDemo.service;

import com.stopwatchDemo.stopwatchDemo.dao.StopwatchTimerDao;
import com.stopwatchDemo.stopwatchDemo.model.StopwatchTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class StopwatchService {

    @Autowired
    StopwatchTimerDao stopwatchTimerDao;

    public StopwatchTimer saveStartDetails(Boolean doStart)
    {
        StopwatchTimer stopwatchTimer = new StopwatchTimer();
        StopwatchTimer returnedStopwatchTimer = new StopwatchTimer();
        stopwatchTimer.setStartTime(LocalDateTime.now());
        returnedStopwatchTimer = stopwatchTimerDao.saveStopWatchTimerDetails(stopwatchTimer);
        return returnedStopwatchTimer;
    }

    public StopwatchTimer saveStopDetails(Integer id, Boolean doStop) {

        StopwatchTimer returnedStopwatchTimer = new StopwatchTimer();

        Long duration = null;
            StopwatchTimer savedStopwatchTimer = stopwatchTimerDao.getStopwatchTimerById(id);
            savedStopwatchTimer.setEndTime(LocalDateTime.now());
            duration = ChronoUnit.SECONDS.between(savedStopwatchTimer.getStartTime(), savedStopwatchTimer.getEndTime());
            savedStopwatchTimer.setDuration(duration);
            returnedStopwatchTimer = stopwatchTimerDao.updateStopWatchTimerDetails(savedStopwatchTimer);
        return returnedStopwatchTimer;
    }
}
