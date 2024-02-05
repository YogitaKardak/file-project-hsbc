package com.hsbc.processor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HSBCFileSystem implements FileSystem {

	private String fileContent;

	@Override
	public String readFile(Path path) throws IOException {
		// Check if the input file exists
		if (!Files.exists(path)) {
			System.err.println("Input file does not exist: " + path);
			return null;
		}

		fileContent = Files.readString(path);
		
		if (fileContent == null || fileContent.isEmpty()) {
            throw new IllegalArgumentException("Input file is empty or null.");
        }

        String reversedContent = Stream.of(fileContent).map(string -> new StringBuilder(string).reverse())
                .collect(Collectors.joining());
		return reversedContent;

	}

	@Override
	public void writeFile(Path path, String content) throws IOException {
		// Write the content to the output file
		try (var writer = Files.newBufferedWriter(path)) {
			writer.write(content);
		} catch (IOException e) {
			System.err.println("An error occurred during file processing: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("File processing completed successfully.");
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

}
