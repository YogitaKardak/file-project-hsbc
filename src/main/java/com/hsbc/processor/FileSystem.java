package com.hsbc.processor;


import java.io.IOException;
import java.nio.file.Path;

public interface FileSystem {
	
	String readFile(Path path) throws IOException;

	void writeFile(Path path, String content) throws IOException;

}
