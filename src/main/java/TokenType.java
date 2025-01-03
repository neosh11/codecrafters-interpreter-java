enum TokenType {
    // Single-character tokens.
    SEMICOLON, SLASH, LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    COMMA, MINUS, PLUS, STAR, DOT,
    // One or two character tokens.
    EQUAL, EQUAL_EQUAL,
    BANG, BANG_EQUAL,
    LESS, LESS_EQUAL, GREATER, GREATER_EQUAL,
    // Literals.
    IDENTIFIER, STRING, NUMBER,
    // Keywords.
    AND, CLASS, ELSE, FALSE, FOR, FUN, IF, NIL, OR, PRINT, RETURN, SUPER, THIS, TRUE, VAR, WHILE,
    EOF
}
