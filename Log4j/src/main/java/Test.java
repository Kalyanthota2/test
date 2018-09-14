import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Test {
	
	final static Logger logger=Logger.getLogger(Test.class); 
public static void main(String args[])
{

	//BasicConfigurator.configure();
	logger.info("Logger message in test class");
	System.out.println("Hello Kalyan");
	System.out.println("Hello Kalyan Thota.");
	System.out.println("Hello Kalyan Thota. How are you");
	try{
		int a=10;
		int b=10;
		int c=b/a;
	}
	catch(Exception e){
		logger.error("Error message"+e);
	}
	
}

}
