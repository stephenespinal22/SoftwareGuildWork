/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine.advice;

import org.aspectj.lang.JoinPoint;
import sg.com.vendingmachine.daos.VendingMachinePersistanceException;
import sg.com.vendingmachine.daos.VendingMachineServiceExceptionAudit;
import sg.com.vendingmachine.services.InsufficientFundsException;
import sg.com.vendingmachine.services.ItemNotFoundException;
import sg.com.vendingmachine.services.ItemOutOfStockException;

/**
 *
 * @author stephenespinal
 */
public class LoggingAdvice {

    private VendingMachineServiceExceptionAudit audit;

    public LoggingAdvice(VendingMachineServiceExceptionAudit audit) {
        this.audit = audit;
    }

    //if you attach this to a method the joinpoint will give you the 
    //info that was passed in from that method
    public void createAuditEntry(JoinPoint jp) {
        //hey i need to get the arguments being passed in
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";

        for (Object currentArg : args) {
            //keep appending arguments to string
            auditEntry += currentArg;
        }

        try {
            audit.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistanceException e) {
            System.err.println("ERROR: Could not create audit entry in Logging Advice");
        }
    }

    public void afterThrowingOutOfStockAdvice(ItemOutOfStockException ex) throws VendingMachinePersistanceException {
        audit.writeAuditEntry("ItemOutOfStockException: " + ex.getMessage());
    }

    public void afterThrowingInsufficientFundsAdvice(InsufficientFundsException ex) throws VendingMachinePersistanceException {
        audit.writeAuditEntry("InsufficientFundsException: " + ex.getMessage());
    }

    public void afterThrowingItemNotFoundAdvice(ItemNotFoundException ex) throws VendingMachinePersistanceException {
        audit.writeAuditEntry("ItemNotFoundException: " + ex.getMessage());
    }
}
