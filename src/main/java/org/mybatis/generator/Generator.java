package org.mybatis.generator;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {

	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		Set<String> fullyqualifiedTables = new HashSet<String>();
		Set<String> contexts = new HashSet<String>();

		try {
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(Generator.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));

			DefaultShellCallback shellCallback = new DefaultShellCallback(true);

			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);

			ProgressCallback progressCallback = new VerboseProgressCallback();

			myBatisGenerator.generate(progressCallback, contexts, fullyqualifiedTables);

		} catch (XMLParserException e) {
			writeLine(getString("Progress.3"));
			writeLine();
			for (String error : e.getErrors()) {
				writeLine(error);
			}

			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (InvalidConfigurationException e) {
			writeLine(getString("Progress.16"));
			for (String error : e.getErrors()) {
				writeLine(error);
			}
			return;
		} catch (InterruptedException e) {
			// ignore (will never happen with the DefaultShellCallback)
		}

		for (String warning : warnings) {
			writeLine(warning);
		}

		if (warnings.size() == 0) {
			writeLine(getString("Progress.4"));
		} else {
			writeLine();
			writeLine(getString("Progress.5"));
		}
	}

	private static void usage() {
		String lines = getString("Usage.Lines");
		int intLines = Integer.parseInt(lines);
		for (int i = 0; i < intLines; i++) {
			String key = "Usage." + i;
			writeLine(getString(key));
		}
	}

	private static void writeLine(String message) {
		System.out.println(message);
	}

	private static void writeLine() {
		System.out.println();
	}
}
