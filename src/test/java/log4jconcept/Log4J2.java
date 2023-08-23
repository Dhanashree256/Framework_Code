package log4jconcept;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4J2 {
	
	Logger log ;
	
	@Test 
	public void loggerDemo() {
		
		 log = LogManager.getLogger("Log4J2");    // Class Name
		 
		 System.out.println("This is Logger Class...........");	 
		 
	  // Levels of Logger
		 log.fatal("This is Fatal....");
		 log.error("This is error....");
		 log.warn("This is warning....");
		 log.info("This is Info....");
		 log.debug("This is Debug .....");
		 log.trace("This is Trace.....");
		// All
	}

}
