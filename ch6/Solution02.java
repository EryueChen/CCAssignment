package chapter6;

public class Solution02 {
	//The possiblity of winning game 1 is p.
	//The possiblity of winning game 2 is 3 (1 - p) * p * p + p * p * p = 3 * p^2 - 2 * p^3
	//When p = 3 * p^2 - 2 * p^3, p = 0, 0.5, 1
	//When 0 < p < 0.5, play game 1
	//When 0.5 < p < 1, play game 2
	//When p = 0 or 0.5 or 1, play either game
}
