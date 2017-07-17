package com.home.optimizations.functions;

public class FunctionFactory {
  public static MathFunction parabola() {
    return new MathFunction() {
      @Override
      public double calculateY(final double x) {
        return x * x;
      }
    };
  }

  public static MathFunction parabolaAligned() {
    return new MathFunction() {
      @Override
      public double calculateY(final double x) {
        return x * x + 5;
      }
    };
  }
}
