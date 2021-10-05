import org.json.simple.parser.ParseException;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, ParseException {
        Register reg = new Register();
        var temp = reg.getInput();
        reg.writeInput(temp);
    }
}
