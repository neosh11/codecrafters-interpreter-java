enum TokenType {
    // Single-character tokens.
    SEMICOLON, SLASH, LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    COMMA, MINUS, PLUS, STAR, DOT,
    // One or two character tokens.
    EQUAL, EQUAL_EQUAL,
    // Literals.
    IDENTIFIER, STRING, NUMBER,
    // Keywords.
    VAR,
    
    EOF
}
