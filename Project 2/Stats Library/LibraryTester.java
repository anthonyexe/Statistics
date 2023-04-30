//Anthony D'Alessandro
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class LibraryTester {
	public static void main(String[] args) {
		StatsLibrary lib = new StatsLibrary();
		
		//Hypergeometric Distribution Tests
		System.out.printf("Hypergeometric Distribution given y = 2, N = 10, n = 5, r = 4: %.3f", lib.hypergeometricDistribution(10, 5, 4, 2));
		System.out.printf("\n\nExpected Value of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricExpected(10, 4, 5));
		System.out.printf("\n\nVariance of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricVariance(10, 4, 5));
		System.out.printf("\n\nStandard Deviation of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricStandardDeviation(10, 4, 5));
		
		
		//Poisson Distribution Tests
		System.out.printf("\n\nPoisson Distribution given lambda = 2 and y = 4: %.3f", lib.poissonDistribution(2, 4));
		System.out.println("\n\nExpected Value and Variance of Poisson Distribution given lambda = 2: " + lib.poissonExpectedAndVariance(2));
		System.out.printf("\n\nStandard Deviation of Poisson Distribution given lambda = 2: %.3f", lib.poissonStandardDeviation(2));
		
		//Chebyshev Tests
		System.out.printf("Percentage of values between 16 and 24 given a mean of 20 and a standard deviation of 2: %.3f", lib.chebyshev(16, 24, 20, 2));
		System.out.printf("\n\nPercentage of values between 16 and 24 given a mean of 20 and a variance of 4: %.3f", lib.chebyshevGivenVariance(16, 24, 20, 4));
		
		
		//Uniform Distribution Tests
		System.out.printf("\n\nUniform Distribution given a = 5, b = 15, c = 0, d = 20: %.3f", lib.uniformDistribution(5, 15, 0, 20));
		System.out.printf("\n\nExpected Value of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformExpectedValue(1, 20));
		System.out.printf("\n\nVariance of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformVariance(1, 20));
		System.out.printf("\n\nStandard Deviation of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformStandardDeviation(1, 20));
	}
}
