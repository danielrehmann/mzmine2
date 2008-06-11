/*
 * Copyright 2006-2008 The MZmine Development Team
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package net.sf.mzmine.modules.peakpicking.twostep.massdetection.exactmass;

import java.text.NumberFormat;

import net.sf.mzmine.data.Parameter;
import net.sf.mzmine.data.ParameterType;
import net.sf.mzmine.data.impl.SimpleParameter;
import net.sf.mzmine.data.impl.SimpleParameterSet;
import net.sf.mzmine.main.MZmineCore;

public class ExactMassDetectorParameters extends SimpleParameterSet {

	public static final String peakModelNames[] = { "Gaussian",
		"Lorentzian" };

	public static final String peakModelClasses[] = {
		"net.sf.mzmine.modules.peakpicking.twostep.peakmodel.impl.GaussPeak",
		"net.sf.mzmine.modules.peakpicking.twostep.peakmodel.impl.LorentzianPeak" };

	public static final NumberFormat percentFormat = NumberFormat
			.getPercentInstance();

	public static final Parameter noiseLevel = new SimpleParameter(
			ParameterType.FLOAT, "Noise level",
			"Intensities less than this value are interpreted as noise",
			"absolute", new Float(10.0), new Float(0.0), null, MZmineCore
					.getIntensityFormat());

	public static final Parameter resolution = new SimpleParameter(
			ParameterType.INTEGER,
			"Mass Resolution",
			"Mass resolution is the dimensionless ratio of the mass of the peak divided by its width."
					+ " Peak width is taken as the full width at half maximum intensity, (fwhm).",
			null, new Integer(60000), new Integer(0), null, NumberFormat
					.getIntegerInstance());

	public static final Parameter cleanLateral = new SimpleParameter(
			ParameterType.BOOLEAN,
			"Remove FTMS shoulder peaks",
			"Remove lateral peaks encontered under the shape of simulated peak by \"Model peak function\"",
			null, new Boolean(false), null, null, null);

	public static final Parameter peakModel = new SimpleParameter(
			ParameterType.STRING,
			"Model peak function",
			"This model calculates a simulated peak using the oiginal peak's intensity, m/z and resolution.",
			null, peakModelNames);


	public ExactMassDetectorParameters() {
		super(new Parameter[] { noiseLevel, resolution, cleanLateral, peakModel	});

	}

}
