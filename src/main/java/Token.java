public class Token {
    /** The type of the token, example: IDENTIFIER */
    final TokenType type;
    /** The actual text of the token, example: "foo" */
    final String lexeme;
    /** The literal value of the token, example: 42 */
    final Object literal;
    /** The line number where the token was found */
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }
    
    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
