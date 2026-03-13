@Override
public Object call(Interpreter interpreter, List<Object> arguments) {
  Environment environment = new Environment(closure);
  if (declaration.params != null) {
    for (int i = 0; i < declaration.params.size(); i++) {
      environment.define(declaration.params.get(i).lexeme,
          arguments.get(i));
    }
  }
  try {
    interpreter.executeBlock(declaration.body, environment);
  } catch (Return returnValue) {
    if (isInitializer) return closure.getAt(0, "this");
    return returnValue.value;
  }
  if (isInitializer) return closure.getAt(0, "this");
  return null;
  // ...
}
