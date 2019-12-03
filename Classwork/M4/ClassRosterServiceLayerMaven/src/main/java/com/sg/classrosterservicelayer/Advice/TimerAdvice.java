/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classrosterservicelayer.Advice;

import com.sg.classrosterservicelayer.DAO.ClassRosterAuditDao;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author rscla
 */
public class TimerAdvice {

    ClassRosterAuditDao audit;

    public TimerAdvice(ClassRosterAuditDao audit) {
        this.audit = audit;
    }

    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        audit.writeAuditEntry("Going to call the method.");
        Object output = pjp.proceed();
        audit.writeAuditEntry("Method execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        audit.writeAuditEntry("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
