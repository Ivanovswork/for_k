import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Income implements Controller{
    @Override
    public void add(String inputAmount, String inputType, FileWriter fileWriter) {
        Element_of_record element = new In(inputAmount, inputType);
        ObjectMapper mapper = new ObjectMapper();

        String jsonRecord;
        try {
            jsonRecord = mapper.writeValueAsString(element);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("", e);
        }

        try {
            fileWriter.write(jsonRecord + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }


    public static void show(BufferedReader fileReader) {

        try {
            String line;
            while ((line = fileReader.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();

                try {
                    In income = mapper.readValue(line, In.class);
                    income.show();
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("", e);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }

    public static void outcome(BufferedReader fileReader) {
        try {
            String line;
            int result = 0;
            while ((line = fileReader.readLine()) != null) {

                ObjectMapper mapper = new ObjectMapper();

                try {
                    In income = mapper.readValue(line, In.class);
                    result += Integer.parseInt(income.getAmount());
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("", e);
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }
}
