package com.stopwatchDemo.stopwatchDemo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Table(name = "stopwatch_timer", schema = "")
@Entity
public class StopwatchTimer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stopwatch_timer_id")
    private Integer stopwatchTimerId;
    @Column(name = "start_time")
    LocalDateTime startTime;
    @Column(name = "end_time")
    LocalDateTime endTime;
    @Column(name = "duration")
    Long duration;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getStopwatchTimerId() {
        return stopwatchTimerId;
    }

    public void setStopwatchTimerId(Integer stopwatchTimerId) {
        this.stopwatchTimerId = stopwatchTimerId;
    }
}
