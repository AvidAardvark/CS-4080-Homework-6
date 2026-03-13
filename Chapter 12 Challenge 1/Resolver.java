beginScope();
scopes.peek().put("this", true);

for (Stmt.Function method : stmt.classMethods) { resolveFunction() }

endScope();

for (Stmt.Function method : stmt.classMethods) {
  resolveFunction(method, FunctionType.METHOD);
}
