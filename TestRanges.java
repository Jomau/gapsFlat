
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
    public void testRangesRemove1() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval toRemove = new Interval(1.0, 100.0);
        ranges.remove(toRemove);
        assertThat (ranges.toString(), is("[]")); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesRemove2() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval toRemove = new Interval(5.0, 100.1);
        ranges.remove(toRemove);
        Interval[] expected = { new Interval(1.0, 5.0) };
        assertThat (ranges, contains(expected) ); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesRemove3() {
        Ranges ranges = new Ranges(1.0, 100.0);
        Interval toRemove = new Interval(5.0, 50.0);
        ranges.remove(toRemove);
        Interval[] expected = { new Interval(1.0, 5.0) ,  new Interval(50.0, 100.0) };
        assertThat (ranges, contains(expected) ); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesRemove4() {
        Ranges ranges = new Ranges(2.0, 100.0);
        Interval toRemove = new Interval(1.0, 100.0);
        ranges.remove(toRemove);
        assertThat (ranges.toString(), is("[]") ); // checks ranges.iterator()
    }
    
    @Test
    public void testRangesRemove5() {
        Ranges ranges = new Ranges(2.0, 100.0);
        Interval toRemove = new Interval(1.0, 110.0);
        ranges.remove(toRemove);
        assertThat (ranges.toString(), is("[]") ); // checks ranges.iterator()
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
        assertThat (ranges.iterator().hasNext(), is(true)); // checks ranges.iterator()
    }
    
}
