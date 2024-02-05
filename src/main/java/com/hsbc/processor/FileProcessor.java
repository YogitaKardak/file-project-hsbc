package com.hsbc.processor;


import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {
	    private final FileSystem fileSystem;

	    public FileProcessor(FileSystem fileSystem) {
	        this.fileSystem = fileSystem;
	    }

	    public String readFromFile(Path filePath) throws IOException {
	        return fileSystem.readFile(filePath);
	    }
	    
	    public void writeToFile(Path outputFilePath, String reversedContent) {
	    	try {
				fileSystem.writeFile(outputFilePath, reversedContent);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		

}
