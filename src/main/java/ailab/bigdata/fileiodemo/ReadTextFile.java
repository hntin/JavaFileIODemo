package ailab.bigdata.fileiodemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTextFile {
    public ArrayList readNumberFromLine(String fileName) {
        ArrayList fileReadingResult = new ArrayList();
        double sum = 0;
        int countLineOfNumber = 0;
        int countLineNotNumber = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String lineContent;
            while ((lineContent = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(lineContent);
                    sum += num;
                    countLineOfNumber++;
                }
                catch (NumberFormatException e) {
                    countLineNotNumber++;
                }
            } 
            fileReadingResult.add(sum);
            fileReadingResult.add(countLineOfNumber);
            fileReadingResult.add(countLineNotNumber);
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fileReadingResult;
    }
}
