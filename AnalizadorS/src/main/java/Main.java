import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fuente.txt"));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line).append("\n");
            }
            reader.close();

            AnalizadorLex lexer = new AnalizadorLex(jsonContent.toString());
            Parser parser = new Parser(lexer);
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}