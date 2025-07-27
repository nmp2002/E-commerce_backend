package com.ttisv.common.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

public class CSVUtils {
	public static void writeLine(final Writer writer, final List<String> list) throws IOException {
		writeLine(writer, list, '|', ' ');
	}

	public static void writeLine(final Writer writer, final List<String> list, final char c) throws IOException {
		writeLine(writer, list, c, ' ');
	}

	private static String a(String replace) {
		if (replace.contains("\"")) {
			replace = replace.replace("\"", "\"\"");
		}
		return replace;
	}

	public static void writeLine(final Writer writer, final List<String> list, char c, final char c2)
			throws IOException {
		int n = 1;
		if (c == ' ') {
			c = '|';
		}
		final StringBuilder sb = new StringBuilder();
		for (final String s : list) {
			if (n == 0) {
				sb.append(c);
			}
			if (c2 == ' ') {
				sb.append(a(s));
			} else {
				sb.append(c2).append(a(s)).append(c2);
			}
			n = 0;
		}
		sb.append(System.lineSeparator());
		writer.append((CharSequence) sb.toString());
	}

	public static void writeLine(StringBuilder result, final List<String> list, final char c) throws IOException {
		writeLine(result, list, c, ' ');
	}

	public static void writeLine(StringBuilder result, final List<String> list, char c, final char c2)
			throws IOException {
		int n = 1;
		if (c == ' ') {
			c = '|';
		}
		final StringBuilder sb = new StringBuilder();
		for (final String s : list) {
			if (n == 0) {
				sb.append(c);
			}
			if (c2 == ' ') {
				sb.append(a(s));
			} else {
				sb.append(c2).append(a(s)).append(c2);
			}
			n = 0;
		}
		sb.append(System.lineSeparator());
		result.append((CharSequence) sb.toString());
	}

	public static String readAllContentCsvFile(String string) throws IOException {
		InputStream inputStream = null;
		try {
			string = IOUtils.toString(inputStream = new FileInputStream(string), "UTF-8");
			inputStream.close();
		} catch (Exception ex) {
			if (inputStream != null) {
				inputStream.close();
			}
			throw ex;
		}
		return string;
	}

	public static Vector<String> readAllContentCsvFileToCollection(String line) throws IOException {
		final Vector<String> vector = new Vector<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(line));
			while ((line = bufferedReader.readLine()) != null) {
				vector.add(line);
			}
			try {
				bufferedReader.close();
				return vector;
			} catch (IOException ex4) {
				return vector;
			}
		} catch (FileNotFoundException ex) {
			throw ex;
		} catch (IOException ex2) {
			throw ex2;
		} catch (Exception ex3) {
			throw ex3;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex5) {
				}
			}
		}
	}
}