package com.java.learning.lambdasinaction.examples.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExecuteAround {

	private static String FILE_PATH = System.getProperty("user.dir") + "\\ws_dir\\kol.txt";
	public static void main(String... args) throws IOException {

		System.out.println("File Path: " + FILE_PATH);
		if (createFile(FILE_PATH)) {
			writeFile(FILE_PATH, "This\n is\n an\n example\n");
			System.out.println("*********** file has been created **************");
		}

		// method we want to refactor to make more flexible
		String result = processFileLimited();
		System.out.println(result);

		System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);
	}

	private static void writeFile(String pFileName, String pFileContent) throws IOException {
		FileWriteable out = () -> {
			// creates a FileWriter Object
			FileWriter writer = new FileWriter(pFileName); 

			// Writes the content to the file
			writer.write(pFileContent);

			writer.flush();
			writer.close();
			System.out.println("DONE");
		};
		out.write();
	}

	private static boolean createFile(String pFilePath) throws IOException {
		File file = new File(pFilePath);
		if (file.exists()) {
			return true;
		}
		return file.createNewFile();
	}

	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor {
		public String process(BufferedReader b) throws IOException;

	}

	public interface FileWriteable {
		public void write() throws IOException;

	}
}