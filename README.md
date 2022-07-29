Agenda:
----------

1) Junit 5 and Mockito

Today's session:
-------------------

1) Why Testing is required?
2) What is unit testing?
3) Why we need testing frameworks?
4) How to setup Junit 5 with Maven Project?
5) What is TDD (Test Driven Development)?


Why Testing?
---------------

1) Before delivering an application or software to a client, we find bugs / errors.
2) It makes sure software is more reliable and easy to use. It guarntees Quality of software.
3) Thoroughly tested software ensures reliable and high performance operations.

What is Unit Testing?
------------------------

1) We are testing subprograms or subroutines. (Usually we test a function/method).

TDD (Test Driven Development) = Test First Development.


Why we need a frameworks?
---------------------------------


public class MathUtil {

    public int add (int a , int b) {
	return a +b;
    }
}


MathUtil m = new MathUtil();
int result = m.add(2, 5);
if(result != 7)
System.out.println("Test Failed");



MathUtil m = new MathUtil();
int result = m.add(-2, -5);
if(result != -7)
System.out.println("Test Failed");


MathUtil m = new MathUtil();
int result = m.add(-2, 5);
if(result != 3)
System.out.println("Test Failed");



Steps to Test a code:
------------------------

1. Preparation
2. Provide the test inputs.
3. Run the tests
4. Provide Expected output.
5. Verify the result.
6. Do something to alert developer if test is failed.

Developer responsible for steps 1, 2 and 4.
Testing framework does steps 3, 5 and 6.

Junit Framework => Testig Framework for Java.

Why Junit 5?
----------------

-- Junit 4 >= 10 Years.
-- Not upto date with Latest Java Language Features.
-- Monolithic Architecture.


Junit 5 Architecture:
-----------------------

Junit 4 jar file + dependent Hamcrest jar file.

In case of Junit 5, Architecture is different.

1) Core Platform:  It consists of TestEngine API. Launches Testing Framework on the JVM.
   Consists of library of Junit that runs your tests, providing a way to call test runners, providing execution context to tests etc...
2) Jupiter: As a developer, we are not dirfectly interacting with Core Platform.
   We actually use Junit API. Jupiter => Junit API => Annotations and assertXxx() method.

3) Vintage:  YOu can interact with older versions of Junit using Vintage library.

4) Custom Testing API:- 3rd Party libraries or You can write your own.


Test classes naming convention for Maven:
-----------------------------------------------

Test<Your_class_name>
<Your_class_name>Test



Assert Methods:
-------------------

Use - To verify expected and actual output

1) assertEquals(expected, actual)  => Overloaded method.
2) assertEqualsArray(expectedArray, actualArray)  => To test equality between 2 arrays.
3) assertIterableEquals(expectedIterable, actualIterable)  => To test equality collection framework classes.
3) assertTrue(condition)
4) assertFalse(condition)
5) assertNull(object)
6) assertNotNull(object)
7) assertNotEquals()  => Overloaded method.
8) assertThrows() => When u r expecting exception in your code.

   assertThrows(Class<T> expectedType, Executable executable)

@FunctionalInterface
@API(status = STABLE, since = "5.0")
public interface Executable {

     void execute() throws Throwable;
}

Agenda:
---------

1) assertAll()
2) Parameterized test
3) Method Order Execution:

    1) Alphanumeric
    2) Random
    3) OrderAnnotation - You have to provide Order. How to specify Order?  By using @Order(n) annotation'
    4) Custom Order -

4) Test Suite -  We can provide classes that we want to test.

    1) Create a class. Annotated with @RunWith(JunitPlatform.class)
    2) Various annotations available to specify which test classes to run.

   @SelectClasses
   @SelectPackages
   @IncludePackages - Use in combination with @SelectPackages
   @ExcludePackages - Use in combination with @SelectPackages
   @ExcludeClassNamePatterns  
   @IncludeTags - Use in combination with @SelectPackages
   @ExcludeTags - Use in combination with @SelectPackages

       @Tag - can be used with test method or test classes.


5) Nested Tests:-

                        We have UserService.

                          LoginFeature

                          login()  ->   Empty strings   "",  ""               
   	              Invalid credentials
   	 	Valid credentials
                                            Null -> null, null


                         ChangePasswordFeature

                         changePassword -> Empty "" 
                                                        Null 
                                                        User exists but wrong old password. - Failed
   		           User credentials are correct and change password (old password and new password different) - Success
   		           User does not exist - Failed
                                                        User crendentials are correct and Old password and new password are same.

                          resetPasswordLink ->  Valid user 
   			Invalid user

                         logout ->  Valid user 
   	           Invalid User	 



Conditional Execution:

@EnableOnOS(OS.LINUX)     => AIX, LINUX, MAC, WINDOWS, LINUX, SOLARIS      
@DisabledOnOS  => AIX, LINUX, MAC, WINDOWS, LINUX, SOLARIS


@EnableOnJre(JRE.JAVA_11)    
@DisabledOnJre()

@EnabledIfSystemProperty
@EnabledIfSystemProperties

@DisabledIfSystemProperty
@DisabledIfSystemProperties

@EnabledIfEnvironmentVariable
@EnabledIfEnvironmentVariables

@DisabledIfEnvironmentVariable
@DisabledIfEnvironmentVariables

> java -Dport=9999  <class_name>



6) Assumptions -   assumeTrue(condition)
   assumeFalse(condition)

                             If your assumption is true, then test method will be executed else it will be skipped (similar to @Disabled test)



Mockito Framework:
-----------------------

* Test a class in Isolation.

Application is basically divided into 3 layers:

a) Presentation Layer
b) Business Layer
c) Data Layer


public interface BankAccountService {

       public double withdraw(long accoutId, double amount);   === 101 -> 25000   |  5000
       public double deposit(long accountId, double amount);
       public double fundTransfer(long fromAccountId, long toAccountId, double amount);
       public double getBalance(long accountId);
}

public class BankAccountServiceImpl implements BankAccountService {

}

public class BankAccountController {

}

--------------------------------------------------------------

Stock ->

     1 - "Nifty" -  5    => 2500 * 5  = 12500
     2 - "Royal Enfield" - 2 => 100000 * 2 = 200000
====================================
Market Value = 212500


-- Mocking is a process of developing the objects that act as the mock or clone of the real objects. In other words, mocking is a testing technique where mock objects are used instead of real objects for testing purposes. Mock objects provide a specific (dummy) output for a particular (dummy) input passed to it. Mock objects are typically used for behavior verification.




Mockito - testing framework for Java for mock objects.
- Under the MIT License
- Open source

Mockito Features:
1) Creation of mock objects is taken care by mockito.
2) Annotation support
3) Testing exceptions
4) Order and verfication of method calls.
5) Spy Objects.


There are different ways to use Mockito - I'll go through them one by one.

Manually
Creating mocks manually with Mockito::mock works regardless of the JUnit version (or test framework for that matter).

Annotation Based
Using the @Mock-annotation and the corresponding call to MockitoAnnotations::initMocks to create mocks works regardless of the JUnit version (or test framework for that matter but Java 9 could interfere here, depending on whether the test code ends up in a module or not).

Mockito Extension
JUnit 5 has a powerful extension model and Mockito recently published one under the group / artifact ID org.mockito : mockito-junit-jupiter.

You can apply the extension by adding @ExtendWith(MockitoExtension.class) to the test class and annotating mocked fields with @Mock. From MockitoExtension's JavaDoc:

@ExtendWith(MockitoExtension.class)
public class ExampleTest {

    @Mock
    private List list;

    @Test
    public void shouldDoSomething() {
        list.add(100);
    }

}
The MockitoExtension documentation describes other ways to instantiate mocks, for example with constructor injection (if you rpefer final fields in test classes).
