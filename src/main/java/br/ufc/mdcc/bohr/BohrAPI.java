package br.ufc.mdcc.bohr;

import java.util.Collection;

import br.ufc.mdcc.bohr.model.AoCSuite;
import br.ufc.mdcc.bohr.model.Dataset;
import spoon.Launcher;
import spoon.SpoonAPI;

public class BohrAPI {

	private static SpoonAPI spoon;

	public static Collection<AoCSuite> searchAoC(String sourceCodePath) {
		build(sourceCodePath);
		configure();
		process();
		return Dataset.list();
	}

	
	public static Collection<AoCSuite> searchAoC(String sourceCodePath, String[] finders) {
		build(sourceCodePath);
		configure(finders);
		process();
		return Dataset.list();
	}

	private static void build(String sourceCodePath) {
		spoon = new Launcher();
		spoon.addInputResource(sourceCodePath);
		spoon.buildModel();
	}

	private static void configure() {
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.PreAndPostIncrementDecrementFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.ConditionalOperatorFinder");
		//spoon.addProcessor("br.ufc.mdcc.bohr.finder.InfixOperatorPrecedenceFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.OmittedCurlyBracesFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.LogicAsControlFlowFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.ArithmeticAsLogicFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.ChangeOfLiteralEncodingFinder");
		spoon.addProcessor("br.ufc.mdcc.bohr.finder.TypeConversionFinder");
	}

	private static void configure(String[] finders) {
		for (String finder : finders) {
			spoon.addProcessor(finder);
		}
	}

	private static void process() {
		spoon.process();
	}
	
	public static void clean() {
		Dataset.clear();
	}
	
}