class LoxClass extends LoxInstance implements LoxCallable {
  final String name;
  private final Map<String, LoxFunction> methods;

  private LoxClass(String name, LoxClass superclass,
                   Map<String, LoxFunction> methods) {
      super(null);
  }
  
  LoxClass(LoxClass superclass, String name,
        Map<String, LoxFunction> methods,
        Map<String, LoxFunction> classMethods) {
    super(new LoxClass(name + " metaclass", null, classMethods));
  }
}
