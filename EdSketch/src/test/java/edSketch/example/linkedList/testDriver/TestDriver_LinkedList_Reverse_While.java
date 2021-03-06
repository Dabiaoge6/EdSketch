/**
 * @author Lisa Dec 1, 2016 TestDriver.java 
 */
package edSketch.example.linkedList.testDriver;

import edSketch.example.TestDriver;
import edSketch.example.linkedList.LL_Reverse_While;
import edSketch.example.linkedList.LinkedList;
import edSketch.example.linkedList.LinkedList_expected;
import edSketch.executor.SketchExecutor;

/**
 * While this can be replaced with JUNIT, I use main for simplicity.
 * 
 * @author lisahua
 *
 */
public class TestDriver_LinkedList_Reverse_While extends TestDriver_LinkedList {
	private boolean testEmptyList() {
		return testHelper(new int[] {});
	}

	private boolean testOneNode() {
		return testHelper(new int[] { 1 });
	}

	private boolean testTwoNode() {
		return testHelper(new int[] { 1, 2 });
	}

	private boolean testThreeNode() {
		return testHelper(new int[] { 1, 2, 3 });
	}

	private boolean testMoreNode() {
		return testHelper(new int[] { 1, 2, 3, 4 });
	}

	@Override
	public boolean test() {
//		if(!testEmptyList()) return false;
//		if(!testOneNode()) return false;
//		if(!testTwoNode()) return false;
//		if(!testThreeNode()) return false;
		if(!testMoreNode()) return false;
		return true;
	}

	protected boolean testHelper(int[] arr) {
		LL_Reverse_While sketch = new LL_Reverse_While(arr);
		sketch.reverse();
		LinkedList expect = new LinkedList_expected(arr);
		expect.reverse();
		return checkEq(expect, sketch);
	}
	
	public static void main(String[] a) {
		TestDriver driver = new TestDriver_LinkedList_Reverse_While();
		try {
			if (!driver.test())
				throw new RuntimeException("****TEST FAILURE");
		} catch (NullPointerException npe) {
			//npe.printStackTrace();
			//System.out.println( "*****BACKTRACKING: null pointer exception");
			SketchExecutor.backtrack();
		} catch (RuntimeException re) {
		//	System.out.println( re.getMessage());
			SketchExecutor.backtrack();
		}
	//	System.out.println("****ALL TESTS PASSED!  Time: " + nf.format((System.nanoTime() - startTime) * 1.0 / Math.pow(10, 9)));
		throw new RuntimeException("****FOUND FIRST SOLUTION");
	}
}
