package fi.sandman.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fi.sandman.utils.coordinate.CoordinateConversionFailed;
import fi.sandman.utils.coordinate.CoordinateUtils;
import fi.sandman.utils.coordinate.CoordinatePoint;
import fi.sandman.utils.coordinate.UnableToDetermineZone;

/**
 * 
 * Unit tests for {@link CoordinateUtils}
 */
public class CoordinateUtilsTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public CoordinateUtilsTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CoordinateUtilsTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	/**
	 * Tests converting KKJ xy to WGS86 latitude and longitude
	 * 
	 * @throws CoordinateConversionFailed
	 */
	public void testKKJxyToWGS86lalo() throws CoordinateConversionFailed {
		CoordinatePoint input = new CoordinatePoint(6904603.5, 3434823.2);
		// double[] input = new double[] { 6904603.5, 3434823.2 };
		CoordinatePoint output = CoordinateUtils.convertKKJxyToWGS86lalo(input);
		assertEquals(25.742858181882976, output.getLongitude());
		assertEquals(62.24141853294101, output.getLatitude());
	}

	/**
	 * Tests converting KKJ xy to KKJ latitude and longitude
	 * 
	 * @throws CoordinateConversionFailed
	 */
	public void testKKJxyToKKJlalo() throws CoordinateConversionFailed {
		CoordinatePoint input = new CoordinatePoint(6904603.5, 3434823.2);
		CoordinatePoint output = CoordinateUtils.convertKKJxyToKKJlalo(input);
		assertEquals(25.746211970608957, output.getLongitude());
		assertEquals(62.2411451459755, output.getLatitude());
	}

	public void testGetKKJzoneByEasting() throws UnableToDetermineZone {
		int result = CoordinateUtils.getKKJzoneByEasting(3434823.2);
		assertEquals(3, result);
	}

	public void testKKJlaloToKKJxy() {
		CoordinatePoint input = new CoordinatePoint(62.24114514597551, 25.746211970608957);
		CoordinatePoint output = CoordinateUtils.convertKKJlaloToKKJxy(input, 3);
		assertEquals(3434823.200588828, output.getLongitude());
		assertEquals(6904603.500755761, output.getLatitude());
	}

	public void testWGS84laloToKKJlalo() {
		CoordinatePoint input = new CoordinatePoint(62.241418532941026, 25.74285818188298);
		CoordinatePoint output = CoordinateUtils.convertWGS86toKKJlalo(input);
		assertEquals(25.7462119553654, output.getLongitude());
		assertEquals(62.241145239238975, output.getLatitude());
	}

	public void testWGS86lolaToKKJxy() throws CoordinateConversionFailed {
		CoordinatePoint input = new CoordinatePoint(62.241418532941026, 25.74285818188298);
		CoordinatePoint output = CoordinateUtils.convertWGS86lolaToKKJxy(input);
		assertEquals(3434823.1999977706, output.getLongitude());
		assertEquals(6904603.511164323, output.getLatitude());
	}
}
