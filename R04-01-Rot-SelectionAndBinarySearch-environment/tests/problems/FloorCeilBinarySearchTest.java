package problems;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloorCeilBinarySearchTest {

    private Integer[] firstArray;
    private Integer[] secondArray;
    private Integer[] keys;
    private OrderStatistics implementation;

    @Before
    public void setUp() throws Exception {
        this.firstArray = new Integer[]{5,4,7,8,3,5,32,5,3,7,8,4,7};
        this.secondArray = new Integer[]{453,6,3,6,2,4,3,1,5,65,3,5,67};
        this.keys = new Integer[]{4,7,3,2,1,5};
        this.implementation = new OrderStatisticsSelectionImpl();
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, implementation.getOrderStatistics(firstArray, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, implementation.getOrderStatistics(keys, 3));
    }

}