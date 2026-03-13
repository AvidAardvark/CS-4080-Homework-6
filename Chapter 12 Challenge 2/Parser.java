private Stmt.Function function(String kind) {
  Token name = consume(IDENTIFIER, "Expect " + kind + " name.");

  List<Token> parameters = null;

  // Allow omitting the parameter list entirely in method getters.
  if (!kind.equals("method") || check(LEFT_PAREN)) {
    consume(LEFT_PAREN, "Expect '(' after " + kind + " name.");
    parameters = new ArrayList<>();
    if (!check(RIGHT_PAREN)) {
      do {
        if (parameters.size() >= 255) {
          error(peek(), "Can't have more than 255 parameters.");
        }

        parameters.add(consume(IDENTIFIER, "Expect parameter name."));
      } while (match(COMMA));
    }
    consume(RIGHT_PAREN, "Expect ')' after parameters.");
  }

  consume(LEFT_BRACE, "Expect '{' before " + kind + " body.");
  List<Stmt> body = block();
  return new Stmt.Function(name, parameters, body);
}
