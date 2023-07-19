import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import com.promineotech.TestDemo;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	//private TestDemo myDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		//myDemo = new TestDemo();

	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	public static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false));
	}

	@Test
	private void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(3, 2)).isEqualTo(5);
		assertThat(testDemo.addPositive(98, 96)).isEqualTo(194);
		assertThat(testDemo.addPositive(24, 27)).isEqualTo(51);
		assertThat(testDemo.addPositive(22, 1)).isEqualTo(23);

	}

	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}

	// my test that determines if integer first is less than the second integer
//	@ParameterizedTest
//	void doesMyTestWork(int first, int second, int result, boolean resultException) {
//		if (!resultException) {
//			assertThat(myDemo.myTest(first, second)).isEqualTo(result);
//		} else {
//			assertThatThrownBy(() -> myDemo.myTest(first, second)).isInstanceOf(IllegalArgumentException.class);
//		}
//	}
//
//	@Test
//	private void assertThatTheValuesAreComparedCorrectly() {
//		assertThat(myDemo.myTest(2, 3)).isLessThan(3);
//		assertThat(myDemo.myTest(1, 2)).isLessThan(2);
//		assertThat(myDemo.myTest(7, 4)).isLessThan(4);
//		assertThat(myDemo.myTest(9, 7)).isLessThan(7);
//		assertThat(myDemo.myTest(6, 1)).isLessThan(1);
//		
//	}
}
