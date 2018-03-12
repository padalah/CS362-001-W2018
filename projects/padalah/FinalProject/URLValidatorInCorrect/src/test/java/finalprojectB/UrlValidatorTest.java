
package finalprojectB;

import junit.framework.TestCase;

import java.util.Random;

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
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String httpVal = "http://255.com:80";
      assertEquals(false, urlVal.isValid(httpVal));
   }
   
   public void testYourSecondPartition(){
      //You can use this function to implement your Second Partition testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String httpVal = "ftp://www.google.com:80/test1?action=view";
      assertEquals(true, urlVal.isValid(httpVal));
   }
   //You need to create more test cases for your Partitions if you need to

   public void testYourThirdPartition(){
      //You can use this function to implement your Second Partition testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String value=null;
      assertEquals(false, urlVal.isValid(value));
   }

   public void testYourFourthPartition(){
      //You can use this function to implement your Second Partition testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String httpVal = "http://www.google.com";
      assertEquals(true, urlVal.isValid(httpVal));
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      for(int i=0; i<50; i++) {
         StringBuilder urlBuffer = new StringBuilder();
         Random rand = new Random();
         int urlSchemeTNum = rand.nextInt(testUrlSchemeTrue.length);
         int urlAuthorityTNum = rand.nextInt(testUrlAuthorityTrue.length);
         int urlPortTNum = rand.nextInt(testUrlPortTrue.length);
         int urlPathTNum = rand.nextInt(testPathTrue.length);
         int urlPathOptionsTNum = rand.nextInt(testUrlPathOptionsTrue.length);
         int urlQueryTNum = rand.nextInt(testUrlQueryTrue.length);
         int numOptionTimes = rand.nextInt(6);
         for(int j=0; j<numOptionTimes; j++){
            if(j==0){
               urlBuffer.append(testUrlSchemeTrue[urlSchemeTNum]);
            }
            else if(j==1){
               urlBuffer.append(testUrlAuthorityTrue[urlAuthorityTNum]);
            }
            else if(j==2){
               urlBuffer.append(testUrlPortTrue[urlPortTNum]);
            }
            else if(j==3){
               urlBuffer.append(testPathTrue[urlPathTNum]);
            }
            else if(j==4){
               urlBuffer.append(testUrlPathOptionsTrue[urlPathOptionsTNum]);
            }
            else if(j==5){
               urlBuffer.append(testUrlQueryTrue[urlQueryTNum]);
            }
         }
         String url = urlBuffer.toString();
         assertTrue(urlVal.isValid(url));
      }

      for(int i=0; i<50; i++) {
         StringBuilder urlBuffer = new StringBuilder();
         Random rand = new Random();
         int urlSchemeFNum = rand.nextInt(testUrlSchemeFalse.length);
         int urlAuthorityFNum = rand.nextInt(testUrlAuthorityFalse.length);
         int urlPortFNum = rand.nextInt(testUrlPortFalse.length);
         int urlPathFNum = rand.nextInt(testPathFalse.length);
         int urlPathOptionsFNum = rand.nextInt(testUrlPathOptionsFalse.length);
         int urlQueryFNum = rand.nextInt(testUrlQueryFalse.length);
         int numOptionTimes = rand.nextInt(6);
         for(int j=0; j<numOptionTimes; j++){
            if(j==0){
               urlBuffer.append(testUrlSchemeFalse[urlSchemeFNum]);
            }
            else if(j==1){
               urlBuffer.append(testUrlAuthorityFalse[urlAuthorityFNum]);
            }
            else if(j==2){
               urlBuffer.append(testUrlPortFalse[urlPortFNum]);
            }
            else if(j==3){
               urlBuffer.append(testPathFalse[urlPathFNum]);
            }
            else if(j==4){
               urlBuffer.append(testUrlPathOptionsFalse[urlPathOptionsFNum]);
            }
            else if(j==5){
               urlBuffer.append(testUrlQueryFalse[urlQueryFNum]);
            }
         }
         String url = urlBuffer.toString();
         assertFalse(urlVal.isValid(url));
      }

      for(int i=0; i<50; i++) {
         StringBuilder urlBuffer = new StringBuilder();
         Random rand = new Random();
         int urlSchemeTNum = rand.nextInt(testUrlSchemeTrue.length);
         int urlAuthorityTNum = rand.nextInt(testUrlAuthorityTrue.length);
         int urlPortTNum = rand.nextInt(testUrlPortTrue.length);
         int urlPathTNum = rand.nextInt(testPathTrue.length);
         int urlPathOptionsTNum = rand.nextInt(testUrlPathOptionsTrue.length);
         int urlQueryTNum = rand.nextInt(testUrlQueryTrue.length);
         int urlSchemeFNum = rand.nextInt(testUrlSchemeFalse.length);
         int urlAuthorityFNum = rand.nextInt(testUrlAuthorityFalse.length);
         int urlPortFNum = rand.nextInt(testUrlPortFalse.length);
         int urlPathFNum = rand.nextInt(testPathFalse.length);
         int urlPathOptionsFNum = rand.nextInt(testUrlPathOptionsFalse.length);
         int urlQueryFNum = rand.nextInt(testUrlQueryFalse.length);
         int numOptionTimes = rand.nextInt(6);
         final int one=1;
         Boolean trueorfalse = false;
         for(int j=0; j<numOptionTimes; j++){
            int choice = rand.nextInt(1);
            while(j<one) {
               if (choice == 1) {
                  trueorfalse = true;
               }
            }
            if(j==0 && choice==0){
               urlBuffer.append(testUrlSchemeTrue[urlSchemeTNum]);
            }
            else if(j==0 && choice==1){
               urlBuffer.append(testUrlSchemeFalse[urlSchemeFNum]);
            }
            else if(j==1 && choice==0){
               urlBuffer.append(testUrlAuthorityTrue[urlAuthorityTNum]);
            }
            else if(j==1 && choice==1){
               urlBuffer.append(testUrlAuthorityFalse[urlAuthorityFNum]);
            }
            else if(j==2 && choice==0){
               urlBuffer.append(testUrlPortTrue[urlPortTNum]);
            }
            else if(j==2 && choice==1){
               urlBuffer.append(testUrlPortFalse[urlPortFNum]);
            }
            else if(j==3 && choice==0){
               urlBuffer.append(testPathTrue[urlPathTNum]);
            }
            else if(j==3 && choice==1){
               urlBuffer.append(testPathFalse[urlPathFNum]);
            }
            else if(j==4 && choice==0){
               urlBuffer.append(testUrlPathOptionsTrue[urlPathOptionsTNum]);
            }
            else if(j==4 && choice==1){
               urlBuffer.append(testUrlPathOptionsFalse[urlPathOptionsFNum]);
            }
            else if(j==5 && choice==0){
               urlBuffer.append(testUrlQueryTrue[urlQueryTNum]);
            }
            else if(j==5 && choice==1){
               urlBuffer.append(testUrlQueryFalse[urlQueryFNum]);
            }
         }
         String url = urlBuffer.toString();
         if(trueorfalse==true) {
            assertFalse(urlVal.isValid(url));
         }
         else{
            assertTrue(urlVal.isValid(url));
         }
      }
   }


   String[] testUrlSchemeTrue = {"http://", "ftp://", "h3t://", ""};

   String[] testUrlSchemeFalse = {"3ht://", "http:/", "http:", "http/", "://"};

   String[] testUrlAuthorityTrue = {
           "www.google.com",
           "go.com",
           "go.au",
           "0.0.0.0",
           "255.255.255.255",
           "255.com"
   };

   String[] testUrlAuthorityFalse = {
           "256.256.256.256",
           "1.2.3.4.5",
           "1.2.3.4.",
           "1.2.3",
           ".1.2.3.4",
           "go.a",
           "go.a1a",
           "go.1aa",
           "aaa.",
           ".aaa",
           "aaa",
           ""
   };

   String[] testUrlPortTrue = {
           ":80",
           ":65535",
           ":0",
           ""
   };

   String[] testUrlPortFalse = {
           ":-1",
           ":65636",
           ":65a"
   };

   String[] testPathTrue = {"/test1",
           "/t123",
           "/$23",
           "/test1/",
           "",
           "/test1/file"
   };

   String[] testPathFalse = {
           "/..",
           "/../",
           "/..//file",
           "/test1//file"
   };

   //Test allow2slash, noFragment
   String[] testUrlPathOptionsTrue = {"/test1",
           "/t123",
           "/$23",
           "/test1/",
           "",
           "/test1/file",
           "/t123/file",
           "/$23/file",
           "/test1//file"
   };

   String[] testUrlPathOptionsFalse = {
           "/..",
           "/../",
           "/#",
           "/../file",
           "/..//file",
           "/#/file"
   };

   String[] testUrlQueryTrue = {"?action=view",
           "?action=edit&mode=up",
           ""
   };

   String[] testUrlQueryFalse = {"?action?=view",
           "?action=//edit&mode=up",
           "&%$@#"
   };

}
