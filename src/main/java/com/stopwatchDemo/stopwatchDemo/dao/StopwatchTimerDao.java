package com.stopwatchDemo.stopwatchDemo.dao;

import com.stopwatchDemo.stopwatchDemo.model.StopwatchTimer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StopwatchTimerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Session getCurrentSession() {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        return session;
    }

    public StopwatchTimer saveStopWatchTimerDetails(StopwatchTimer stopwatchTimer) {
        try {
            Integer id =(Integer) getCurrentSession().save(stopwatchTimer);
            stopwatchTimer.setStopwatchTimerId(id);
            return stopwatchTimer;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StopwatchTimer getStopwatchTimerById(Integer stopwatchTimerId) {
        StopwatchTimer stopwatchTimer = null;
        try {
            Criteria criteria = getCurrentSession().createCriteria(StopwatchTimer.class, "stopwatchTimer");
            criteria.add(Restrictions.eq("stopwatchTimer.stopwatchTimerId", stopwatchTimerId));
            stopwatchTimer = (StopwatchTimer) criteria.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stopwatchTimer;
    }

    @Transactional
    public StopwatchTimer updateStopWatchTimerDetails(StopwatchTimer stopwatchTimer) {
        try {
            getCurrentSession().merge(stopwatchTimer);
            return stopwatchTimer;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
