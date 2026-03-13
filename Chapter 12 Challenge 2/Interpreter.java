@Override
public Object visitGetExpr(Expr.Get expr) {
  Object object = evaluate(expr.object);
  if (object instanceof LoxInstance) {
    Object result = ((LoxInstance) object).get(expr.name);
    if (result instanceof LoxFunction &&
        ((LoxFunction) result).isGetter()) {
      result = ((LoxFunction) result).call(this, null);
    }

    return result;
  }

  throw new RuntimeError(expr.name,
      "Only instances have properties.");
}
