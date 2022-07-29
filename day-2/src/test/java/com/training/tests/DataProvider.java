package com.training.tests;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DataProvider {

	public static Stream<Arguments> getInputDataForTestPower() {

		return Stream.of(Arguments.of(2, 3, 8), Arguments.of(3, 3, 27), Arguments.of(2, 0, 1), Arguments.of(5, 2, 25),
				Arguments.of(11, 2, 121));
	}

	public static Stream<Integer> getInputDataForTestOdd() {

		return Stream.of(3, 5, 9, 13, 19, 17, 21, 27);
	}
}
