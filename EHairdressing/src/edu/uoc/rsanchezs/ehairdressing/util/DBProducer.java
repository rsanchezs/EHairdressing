package edu.uoc.rsanchezs.ehairdressing.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class DBProducer 
{

    // ======================================
    // =             Attributes             =
    // ======================================

    @Produces @EHairdressingPU
    @PersistenceContext(unitName = "EHairdressingPU")
    private EntityManager em;
}
