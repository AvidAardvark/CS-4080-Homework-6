private void resolveFunction(Stmt.Function function, FunctionType type) {
  FunctionType enclosingFunction = currentFunction;
  currentFunction = type;

  beginScope();
  if (function.params != null) {
    for (Token param : function.params) {
      declare(param);
      define(param);
    }
  }
  resolve(function.body);
  endScope();
  currentFunction = enclosingFunction;
}
