import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      try {
        runPrompt();
      } catch (IOException e) {
        System.err.println("Error reading input: " + e.getMessage());
        System.exit(1);
      }
    }
    if (args.length < 2) {
      System.err.println("Usage: ./your_program.sh tokenize <filename>");
      System.exit(1);
    }

    String command = args[0];
    String filename = args[1];

    if (!command.equals("tokenize")) {
      System.err.println("Unknown command: " + command);
      System.exit(1);
    }

    String fileContents = "";
    try {
      fileContents = Files.readString(Path.of(filename));
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      System.exit(1);
    }

    if (fileContents.length() > 0) {
      Scanner scanner = new Scanner(fileContents);
      List<Token> tokens = scanner.scanTokens();
      for (Token token : tokens) {
        System.out.println(token);
      }
    } else {
      System.out.println("EOF  null"); // Placeholder, remove this line when implementing the scanner
    }
    
    if (hadError) {
      System.exit(errorCode);
    }
  }

  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    for (;;) {
      System.out.print("> ");
      String line = reader.readLine();
      if (line == null)
        break;
      run(line);
    }
  }

  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));
  }

  private static void run(String source) {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();
    // For now, just print the tokens.
    for (Token token : tokens) {
      System.out.println(token);
    }
  }

  static boolean hadError = false;
  static int errorCode = 0;

  static void error(int line, String message, int code) {
    errorCode = code;
    report(line, "", message);
  }
  private static void report(int line, String where,
      String message) {
    System.err.println(
        "[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }

}
