/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.businessLogic;

import static com.frontams.businessLogic.enums.Param.*;
//import com.frontams.businessLogic.transactions.DoTransaction;
import com.frontams.businessLogic.transactions.Sale;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rrodriguez
 */
@Service
public class TransactionService {

    @Autowired
    private Sale sale;

   
}
