package de.lmu.ifi.dbs.elki.math.statistics;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2013
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import de.lmu.ifi.dbs.elki.utilities.optionhandling.AbstractParameterizer;

/**
 * Triangular kernel density estimator.
 * 
 * @author Erich Schubert
 */
public final class TriangularKernelDensityFunction implements KernelDensityFunction {
  /**
   * Static instance.
   */
  public static final TriangularKernelDensityFunction KERNEL = new TriangularKernelDensityFunction();

  /**
   * Canonical bandwidth.
   */
  public static final double CANONICAL_BANDWIDTH = Math.sqrt(6) / 9.;

  /**
   * Private, empty constructor. Use the static instance!
   */
  private TriangularKernelDensityFunction() {
    // Nothing to do.
  }

  @Override
  public double density(double delta) {
    if (delta < 1) {
      return 1 - delta;
    }
    return 0;
  }

  @Override
  public double canonicalBandwidth() {
    return CANONICAL_BANDWIDTH;
  }

  /**
   * Parameterization stub.
   * 
   * @author Erich Schubert
   * 
   * @apiviz.exclude
   */
  public static class Parameterizer extends AbstractParameterizer {
    @Override
    protected TriangularKernelDensityFunction makeInstance() {
      return KERNEL;
    }
  }
}
