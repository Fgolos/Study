//package com.home.optimizations;
//
//import com.home.findMinFunction.LineSegment;
//import com.home.optimizations.functions.FunctionFactory;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//
//public class DichotomyTest {
//  @Test
//  public void minimumFoundCorrectly()
//  throws Exception {
//    final Dichotomy dichotomy = new Dichotomy();
//    final LineSegment min = dichotomy.findMin(-5.0, 5, FunctionFactory.parabola());
//    assertEquals(min.x, 0.0, 0.0001);
//    assertEquals(min.y, 0.0, 0.0001);
//  }
//
//  @Test
//  public void minimumFoundCorrectlyForAlignedParabola()
//  throws Exception {
//    final Dichotomy dichotomy = new Dichotomy();
//    final LineSegment min = dichotomy.findMin(-10.0, 10, FunctionFactory.parabolaAligned());
//    assertEquals(min.x, 0, 0.0001);
//    assertEquals(min.y, 5, 0.0001);
//  }
//}