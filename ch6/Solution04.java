package chapter6;

public class Solution04 {
	//If there are 3 ants, the probability for them to all go clockwise is 0.5^3.
	//The probability of them all go counter clockwise is 0.5^3.
	//The probability for them to go same direction is 2 * 0.5^3.
	//The probability for collision is 1 - 2 * 0.5^3 = 0.75.
	
	//If there are n ants, the probability for them to all go clockwise is 0.5^n.
	//The probability of them all go counter clockwise is 0.5^n.
	//The probability for them to go same direction is 2 * 0.5^n.
	//The probability for collision is 1 - 2 * 0.5^n = 1 - 0.5^(n - 1).
}
