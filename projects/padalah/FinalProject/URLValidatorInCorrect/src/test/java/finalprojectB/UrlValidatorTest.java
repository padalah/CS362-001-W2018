
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest01()
   {
      //You can use this function to implement your manual testing
      UrlValidator urlVal = new UrlValidator();
      String value=null;
      assertEquals(false,urlVal.isValid(value));

   }

   public void testManualTest02(){
      UrlValidator urlVal = new UrlValidator();
      String httpVal = "go.au:0/test1/#?action=view";
      assertEquals(false, urlVal.isValid(httpVal));
   }

   public void testManualTest03(){
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String httpVal = "http://go:.com/test1?action=view";
      assertEquals(true, urlVal.isValid(httpVal));
   }

   public void testManualTest04(){
      UrlValidator urlVal = new UrlValidator();
      String h3tVal = "h3t://aaa./test15//action=view";
      assertEquals(false, urlVal.isValid(h3tVal));

   }

   public void testManualTest05(){
      UrlValidator urlVal = new UrlValidator();
      String h3tVal = "3ht://www.google.com/?action=view";
      assertEquals(false, urlVal.isValid(h3tVal));

   }

   public void testManualTest06(){
      UrlValidator urlVal = new UrlValidator();
      String h3tVal = "ftp://256.256.256.256/test15/action=view";
      assertEquals(false, urlVal.isValid(h3tVal));
   }

   public void testManualTest07(){
      UrlValidator urlVal = new UrlValidator();
      String ftpVal = "ftp://255.255.255.255/test1?action=view";
      assertEquals(true, urlVal.isValid(ftpVal));
   }

   public void testManualTest08(){
      UrlValidator urlVal = new UrlValidator();
      String ftpVal = "ftp://www.google.com/";
      assertEquals(true, urlVal.isValid(ftpVal));
   }
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
