public Void visitClassStmt(Stmt.Class stmt) {

  Map<String, LoxFunction> classMethods = new HashMap<>();
  for (Stmt.Function method : stmt.classMethods) {
    LoxFunction function = new LoxFunction(method, environment, false);
    classMethods.put(method.name.lexeme, function);
  }

  Map<String, LoxFunction> methods = new HashMap<>();
  for (Stmt.Function method : stmt.methods) {
    LoxFunction function = new LoxFunction(method, environment,
        method.name.lexeme.equals("init"));
    methods.put(method.name.lexeme, function);
  }

  LoxClass klass = new LoxClass(stmt.name.lexeme, (LoxClass)superclass, methods, classMethods);
  environment.assign(stmt.name, klass);
  return null;
}

public Object visitGetExpr(Expr.Get expr) {
  Object object = evaluate(expr.object);
  if (object instanceof LoxInstance) {
    return ((LoxInstance) object).get(expr.name);
  }

  throw new RuntimeError(expr.name,
      "Only instances have properties.");
}

  
