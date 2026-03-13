  List<Stmt.Function> classMethods = new ArrayList<>();
  consume(LEFT_BRACE, "Expect '{' before class body.");

  while (!check(RIGHT_BRACE) && !isAtEnd()) {
    boolean isClassMethod = match(CLASS);
    (isClassMethod ? classMethods : methods).add(function("method"));
  }

  consume(RIGHT_BRACE, "Expect '}' after class body.");

  return new Stmt.Class(name, methods, classMethods);
