//All inputs are assumed integer values and all computations are also integral

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ExpressionAndValue {
	String expression = "";
	int value = 0;
}

public class FindTarget {

	HashMap<Integer, String> backTrack = new HashMap<>();
	boolean isFound = false;
	ArrayList<Integer> originalList = new ArrayList<>();
	ArrayList<ExpressionAndValue> finalResult = new ArrayList<>();
	int values[];

	String makeTarget(Integer numbers[], int target) {
		int len = numbers.length;
		int ops = len - 1;
		values = new int[ops];
		for (Integer i : numbers) {
			originalList.add(i);
		}
		getPossibleResultsHelper(Arrays.asList(numbers), ops, target);
		if (!isFound)
			return "None";

		return finalResult.get(0).expression;
	}

	// tries all combinations of operators on all combinations of numbers
	// store computation in hashMap to regenerate expression, if found
	void getPossibleResultsHelper(List<Integer> numbers, int ops, int target) {
		if (isFound == true)
			return;
		if (ops == 0) {
			if (numbers.get(0) == target) {
				isFound = true;
				printExpression(backTrack, backTrack.size());
			}
		} else {
			for (int i = 0; i < numbers.size() - 1; i++) {
				List<Integer> next = new ArrayList<>(numbers);
				int first = numbers.get(i);
				next.remove(new Integer(first));

				for (int j = i + 1; j < numbers.size(); j++) {
					int second = numbers.get(j);

					next.remove(new Integer(second));
					next.add(first + second);
					values[ops - 1] = first + second;
					backTrack.put(ops, first + " " + "+" + " " + second);
					getPossibleResultsHelper(next, ops - 1, target);
					next.remove(new Integer(first + second));
					next.add(new Integer(second));

					next.remove(new Integer(second));
					next.add(first * second);
					values[ops - 1] = first * second;
					backTrack.put(ops, first + " " + "*" + " " + second);
					getPossibleResultsHelper(next, ops - 1, target);
					next.remove(new Integer(first * second));
					next.add(new Integer(second));

					next.remove(new Integer(second));
					next.add(first - second);
					values[ops - 1] = first - second;
					backTrack.put(ops, first + " " + "-" + " " + second);
					getPossibleResultsHelper(next, ops - 1, target);
					next.remove(new Integer(first - second));
					next.add(new Integer(second));

					next.remove(new Integer(second));
					next.add(second - first);
					values[ops - 1] = second - first;
					backTrack.put(ops, second + " " + "-" + " " + first);
					getPossibleResultsHelper(next, ops - 1, target);
					next.remove(new Integer(second - first));
					next.add(new Integer(second));

					if (second != 0) {
						next.remove(new Integer(second));
						next.add(first / second);
						values[ops - 1] = first / second;
						backTrack.put(ops, first + " " + "/" + " " + second);
						getPossibleResultsHelper(next, ops - 1, target);
						next.remove(new Integer(first / second));
						next.add(new Integer(second));
					}
					if (first != 0) {
						next.remove(new Integer(second));
						next.add(second / first);
						values[ops - 1] = second / first;
						backTrack.put(ops, second + " " + "/" + " " + first);
						getPossibleResultsHelper(next, ops - 1, target);
						next.remove(new Integer(second / first));
						next.add(new Integer(second));
					}
				}
			}
		}
	}

	// makes use of hashMap to generate expression
	// bottom-up approach used for each computation
	// result of each computation is stored in ArrayList element
	// In the end single node of ArrayList will have the result
	void printExpression(HashMap<Integer, String> hm, int count) {
		for (int i = count; i >= 1; i--) {
			String str[] = hm.get(i).split("\\s");
			if (originalList.contains(Integer.parseInt(str[0]))
					&& originalList.contains(Integer.parseInt(str[2]))) {
				originalList.remove(new Integer(Integer.parseInt(str[0])));
				originalList.remove(new Integer(Integer.parseInt(str[2])));
				ExpressionAndValue ev = new ExpressionAndValue();
				ev.expression = "(" + str[0] + str[1] + str[2] + ")";
				ev.value = values[i - 1];
				finalResult.add(ev);
			} else if (originalList.contains(Integer.parseInt(str[0]))) {
				originalList.remove(new Integer(Integer.parseInt(str[0])));
				int pos;
				for (pos = 0; pos < finalResult.size(); pos++) {
					if (finalResult.get(pos).value == Integer.parseInt(str[2]))
						break;
				}
				ExpressionAndValue next = finalResult.get(pos);
				ExpressionAndValue ev = new ExpressionAndValue();
				ev.expression = "(" + str[0] + str[1] + next.expression + ")";
				ev.value = values[i - 1];
				finalResult.set(pos, ev);
			} else if (originalList.contains(Integer.parseInt(str[2]))) {
				originalList.remove(new Integer(Integer.parseInt(str[2])));
				int pos;
				for (pos = 0; pos < finalResult.size(); pos++) {
					if (finalResult.get(pos).value == Integer.parseInt(str[0]))
						break;
				}
				ExpressionAndValue prev = finalResult.get(pos);
				ExpressionAndValue ev = new ExpressionAndValue();
				ev.expression = "(" + prev.expression + str[1] + str[2] + ")";
				ev.value = values[i - 1];
				finalResult.set(pos, ev);
			} else {
				int lpos;
				for (lpos = 0; lpos < finalResult.size(); lpos++) {
					if (finalResult.get(lpos).value == Integer.parseInt(str[0]))
						break;
				}
				ExpressionAndValue prev = finalResult.remove(lpos);

				int rpos;
				for (rpos = 0; rpos < finalResult.size(); rpos++) {
					if (finalResult.get(rpos).value == Integer.parseInt(str[2]))
						break;
				}
				ExpressionAndValue next = finalResult.remove(rpos);

				ExpressionAndValue ev = new ExpressionAndValue();
				ev.expression = "(" + prev.expression + str[1]
						+ next.expression + ")";
				ev.value = values[i - 1];
				finalResult.add(Math.min(lpos, rpos), ev);
			}
		}
	}

	public static void main(String[] args) {
		// at least 2 numbers should be passed in command line
		if (args.length < 2) {
			System.out.println("Invalid Input");
			return;
		}

		try {
			int target = Integer.parseInt(args[0]);
			Integer numbers[] = new Integer[args.length - 1];
			for (int i = 1; i < args.length; i++) {
				numbers[i - 1] = Integer.parseInt(args[i]);
			}
			FindTarget fg = new FindTarget();
			System.out.println(fg.makeTarget(numbers, target));
		} catch (NumberFormatException ex) {
			System.out.println("Invalid numbers");
			return;
		}

	}
}
