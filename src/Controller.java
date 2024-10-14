import java.io.BufferedReader;
import java.io.FileWriter;

public interface Controller {
    void add(String input_amount, String input_type, FileWriter fileWriter );

    static void show(BufferedReader fileReader) {

    }

    static void outcome(BufferedReader fileReader) {

    }
}
