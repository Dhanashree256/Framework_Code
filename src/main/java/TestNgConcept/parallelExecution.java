package TestNgConcept;

public class parallelExecution {

	//parallel execution can perform on class level method level or test level
	//when we convert project to run from testng xml we can share name for execution and required test 
	//it can get perform through testng.xml file
	//on the basis of thread count browser initiate 
	
	//when we convert project in .xml file for execution we can pass
	//<test thread-count="5" parallel="methods" name="ChromeTest">
	//for parallel execution declare above syntax at suite level
	//through parameters we can set values which we need to pass during execution
	//<parameter name="browser" value="chrome"></parameter>
}
