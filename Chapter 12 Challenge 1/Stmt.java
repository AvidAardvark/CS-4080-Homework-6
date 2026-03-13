static class Class extends Stmt {
  Class(Token name, Expr.Variable superclass,
        List<Stmt.Function> methods, 
        List<Stmt.Function> classMethods)
  final List<Stmt.Function> methods;
  final List<Stmt.Function> classMethods;
}
  
