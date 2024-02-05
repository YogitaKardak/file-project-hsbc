import org.junit.Test;
import org.mockito.Mockito;

import com.hsbc.processor.FileProcessor;
import com.hsbc.processor.FileSystem;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FileProcessorTest {
	
	@Test
    public void testReadFile() throws IOException {
        FileSystem fileSystem = mock(FileSystem.class);
        when(fileSystem.readFile(any(Path.class))).thenReturn("CBA");
        FileProcessor fileProcessor = new FileProcessor(fileSystem);
        Path inputFilePath = Paths.get("testInput.txt");
        when(fileProcessor.readFromFile(inputFilePath)).thenReturn("CBA");
        String result = fileProcessor.readFromFile(inputFilePath);
        // Assert
        assertEquals("CBA", result);
        verify(fileSystem, times(1)).readFile(eq(Paths.get("testInput.txt")));
    }
	
	@Test
    public void testWriteFile() throws IOException {
        FileSystem fileSystem = mock(FileSystem.class);
        FileProcessor fileProcessor = new FileProcessor(fileSystem);
        fileProcessor.writeToFile(Paths.get("testOutput.txt"), "ABC");
        verify(fileSystem, times(1)).writeFile(eq(Paths.get("testOutput.txt")), eq("ABC"));
    }
	

}

