
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test of the Ranges class
 */
public class TestRanges {

    double precision = 0.001;

    @Test
    public void testConstructor() {
        Ranges ranges = new Ranges(1.0, 100.0);
        assertThat(ranges.sum(), closeTo(99.0, precision));

        Interval[] expected = { new Interval(1.0, 100.0) };
        assertThat (ranges, contains(expected)); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesSubtract1() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval toRemove = new Interval(1.0, 100.0);
        ranges.subtract(toRemove);
        assertThat (ranges.remaining.size(), is(0)); // checks ranges.iterator()
    }

    @Test
    public void testRangesSubtract2() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval toRemove = new Interval(1.000, 1.0);
        ranges.subtract(toRemove);
        Interval[] expected = { new Interval(1.0, 100.0) };
        assertThat (ranges, contains(expected)); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesToString() {
        Ranges ranges = new Ranges(1.0, 100.0);
        String expected = "[(1.0,100.0)]";
        assertThat (ranges.toString(), is(expected)); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesIterator() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval[] expected = { new Interval(1.0, 100.0) };
        assertThat (ranges.iterator().hasNext(), is(true)); // checks ranges.iterator()
    }
    
}
