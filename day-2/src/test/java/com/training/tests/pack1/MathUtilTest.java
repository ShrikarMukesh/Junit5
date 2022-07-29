package com.training.tests.pack1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.training.MathUtil;

//@EnabledOnOs(OS.LINUX)
//@EnabledOnJre(JRE.JAVA_14)
//@EnabledIfEnvironmentVariable(named="PROCESSOR_ARCHITECTURE", matches="[A-Z]*64")
//@EnabledIfSystemProperty(named="os.name", matches="Windows 10")
@EnabledIfEnvironmentVariable(named = "java_version", matches="1.8.121")
public class MathUtilTest {
	
//	  @Disabled("Mention reason to disable the test")
	@Test
	public void testAdditionWithTwoPositiveNumbersAsInput() throws InterruptedException {
//		  int x = 10;
//		  int y = 20;
//		  int result = MathUtil.addition(x, y);
//		  int expectedResult = 30;
//		  
//		  // assert => expected value and actual value
//		  assertEquals(expectedResult, result);

		assertEquals(30, MathUtil.addition(10, 20));
//		System.getenv().forEach((k, v) -> System.out.println(k + " - " + v));	
		
		System.setProperty("java_version", "8");
		System.getProperties().forEach((k, v) -> System.out.println(k + " - " + v));
	}

//	  @Disabled
	@Test
	public void testAdditionWithOnePositiveAndOneNegativeNumberAsInut() throws InterruptedException {

		assertEquals(18, MathUtil.addition(-12, 30));
	}

//	  @Disabled
	@Test
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testAdditionWithBothNegativeNumbersAsInput()  {

		assertEquals(-36, MathUtil.addition(-12, -24));
	}

	@Test
	public void testSubtraction() {

		assertEquals(20, MathUtil.subtraction(40, 20));
		assertEquals(-12, MathUtil.subtraction(-16, -4));
		assertEquals(20, MathUtil.subtraction(16, -4));
	}

	@Test
	@DisplayName("Test subtraction() with assertAll()")
	public void testSubtraction2() {

//		 Executable e1 = () -> assertEquals(20, MathUtil.subtraction(40, 20));
//		 Executable e2 = () -> assertEquals(-12, MathUtil.subtraction(-16, -4));
//		 Executable e3 = () -> assertEquals(20, MathUtil.subtraction(16, -4));
//		 
//		 assertAll(e1, e2, e3);
		assertAll(() -> assertEquals(-12, MathUtil.subtraction(-16, -4)),
				() -> assertEquals(20, MathUtil.subtraction(40, 20)),
				() -> assertEquals(20, MathUtil.subtraction(16, -4)));
	}
	
	
	@ParameterizedTest	
	@CsvSource(value= { 
			                        "2,3,8",
			                        "5,2,25",
			                        "3,3,27",
			                        "9,2,81"
			                     })
	public void testPower(int x, int y, int result) {
		
		assertEquals(result, MathUtil.power(x, y));		
	}
	
	@ParameterizedTest(name= "{index} - Test with arguments => {0}, {1}, {2}")
	@CsvFileSource(resources="/input_data.csv", numLinesToSkip=1)
	public void testPower2(int x, int y, int result) {
		
		assertEquals(result, MathUtil.power(x, y));	
	}
	
	
	@ParameterizedTest(name="{index} - Test with arguments => {arguments}")
	@MethodSource("com.training.tests.DataProvider#getInputDataForTestPower")
	public void testPower3(int x, int y, int result) {
		
		assertEquals(result, MathUtil.power(x, y));
	}
	
	
//	public static Stream<Arguments> getInputDataForPower() {
//		
//		return Stream.of(Arguments.of(2, 3, 8),
//				                   Arguments.of(3, 3, 27),
//				                   Arguments.of(2, 0, 1),
//				                   Arguments.of(5, 2, 25),
//				                   Arguments.of(11, 2, 121));
//	}
	
	
	@ParameterizedTest
//	@ValueSource(ints = { 3, 5, 9, 13, 19, 17, 21, 27 })
	@MethodSource("com.training.tests.DataProvider#getInputDataForTestOdd")
	public void testOdd(int n) {
		
		assertTrue(MathUtil.isOdd(n));
	}
	
//	public static Stream<Integer> getInputDataForTestOdd() {
//		
//		return Stream.of( 3, 5, 9, 13, 19, 17, 21, 27);
//	}
	
	@ParameterizedTest	
	@NullSource
	@ValueSource(strings = { "", "   " })
	public void test_isBlank(String s) {
		
		assertTrue(MathUtil.isBlank(s));
	}
	
	
	@ParameterizedTest
//	@EmptySource
	@NullAndEmptySource
	public void test_isBlank2(String s) {
		
		assertTrue(MathUtil.isBlank(s));
	}
	
	
}



























