/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.loggingapp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author gecasti
 */
public class LoggingTrial {
    private static Logger logger = Logger.getLogger(LoggingTrial.class);
    
    public static void main(String[] args) {
        logger.info("log4j practice session");
        logger.info("log4j practice session");
        logger.info("log4j practice session");
        logger.info("log4j practice session");
        logger.info("log4j practice session");
        logger.info("log4j practice session");
        
        /*
         * The FileApender using the layout org.apache.log4j.HTMLLayout creates
         * an HTML table log page, but it has no ending </body></html> tag; thereofe,
         * this is not a valid HTML page.  To ensure that an ending </body></html> HTML
         * tag are put in the HTML table log page, you have to shutdown the Log Manager.
         */
        LogManager.shutdown();
    }
}