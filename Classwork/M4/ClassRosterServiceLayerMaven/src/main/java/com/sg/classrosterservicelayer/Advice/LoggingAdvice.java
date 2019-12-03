/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classrosterservicelayer.Advice;

import com.sg.classrosterservicelayer.DAO.ClassRosterAuditDao;
import com.sg.classrosterservicelayer.servicelayer.ClassRosterDuplicateIdException;
import com.sg.classrosterservicelayer.servicelayer.ClassRosterPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author rscla
 */
public class LoggingAdvice {
    private ClassRosterAuditDao auditDao; 

    public LoggingAdvice(ClassRosterAuditDao audit) {
        this.auditDao = audit;
    }
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
         try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (ClassRosterPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    public void afterThrowingAdvice(ClassRosterDuplicateIdException ex) throws ClassRosterPersistenceException {
      auditDao.writeAuditEntry(ex.getMessage());   
   } 
}
