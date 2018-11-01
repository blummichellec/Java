package homework2_OS;
import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    private static final String OUTPUT_FILE_NAME = "logs.txt";
    private FileWriter writer;

    public Logger() {
        initFileWriter();
    }

    private void initFileWriter() {
        try {
            writer = new FileWriter(OUTPUT_FILE_NAME);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line) {
        try {
            System.out.println(line);
            writer.write(line);
            writer.write(System.getProperty( "line.separator" ));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}