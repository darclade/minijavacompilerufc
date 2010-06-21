/* Generated By:JavaCC: Do not edit this line. MiniJavaParser.java */
package br.ufc.compiladores.analisadorlexico;

import java.io.FileInputStream;
import java.io.IOException;
import br.ufc.compiladores.sintaxeabstrata.*;

public class MiniJavaParser implements MiniJavaParserConstants {
  public static void main(String args []) throws ParseException, IOException
  {
            FileInputStream fileInputStream = new FileInputStream("JavaFiles/teste.java");
    MiniJavaParser parser = new MiniJavaParser(fileInputStream);
    System.out.println("Lendo arquivo teste.java, do diret\u00f3rio ../JavaFiles");

    try
    {
      MiniJavaParser.program();
      System.out.println("OK!");
    }
    catch (Exception e)
    {
      System.out.println("NOK.");
      System.out.println(e.getMessage());
    }
    catch (Error e)
    {
      System.out.println("Oops.");
      System.out.println(e.getMessage());
    }
  }

  static final public Program program() throws ParseException {
  MainClass main;
  ClassDecl classDeclaration;
  ClassDeclList classList = new ClassDeclList();
    main = mainClass();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      classDeclaration = classDeclaration();
                                          classList.addElement(classDeclaration);
    }
    {if (true) return new Program(main, classList);}
    throw new Error("Missing return statement in function");
  }

  static final public MainClass mainClass() throws ParseException {
  Statement statement;
  Token classId, argsId;
    jj_consume_token(CLASS);
    classId = jj_consume_token(ID);
    jj_consume_token(LBRACES);
    jj_consume_token(PUBLIC);
    jj_consume_token(STATIC);
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING);
    jj_consume_token(LBRACKET);
    jj_consume_token(RBRACKET);
    argsId = jj_consume_token(ID);
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACES);
    statement = statement();
    jj_consume_token(RBRACES);
    jj_consume_token(RBRACES);
    {if (true) return new MainClass(new Identifier(classId.toString()), new Identifier(argsId.toString()), statement);}
    throw new Error("Missing return statement in function");
  }

  static final public ClassDecl classDeclaration() throws ParseException {
  Token classId;
  ClassDecl classDeclaration;
    jj_consume_token(CLASS);
    classId = jj_consume_token(ID);
    classDeclaration = classDeclarationTail(classId);
    {if (true) return classDeclaration;}
    throw new Error("Missing return statement in function");
  }

  static final public ClassDecl classDeclarationTail(Token classId) throws ParseException {
  Token superId;
  VarDeclList vars = new VarDeclList();
  MethodDeclList methods = new MethodDeclList();
  VarDecl var;
  MethodDecl method;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACES:
      jj_consume_token(LBRACES);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT:
        case INTARRAY:
        case BOOLEAN:
        case ID:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        var = varDeclaration();
                           vars.addElement(var);
      }
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PUBLIC:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        method = methodDeclaration();
                                 methods.addElement(method);
      }
      jj_consume_token(RBRACES);
    {if (true) return new ClassDeclSimple(new Identifier(classId.toString()), vars, methods);}
      break;
    case EXTENDS:
      jj_consume_token(EXTENDS);
      superId = jj_consume_token(ID);
      jj_consume_token(LBRACES);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT:
        case INTARRAY:
        case BOOLEAN:
        case ID:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_4;
        }
        var = varDeclaration();
                           vars.addElement(var);
      }
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PUBLIC:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_5;
        }
        method = methodDeclaration();
                                 methods.addElement(method);
      }
      jj_consume_token(RBRACES);
    {if (true) return new ClassDeclExtends(new Identifier(classId.toString()), new Identifier(superId.toString()), vars, methods);}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public VarDecl varDeclaration() throws ParseException {
  Token typeId;
  Token varId;
  VarDecl var;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      typeId = jj_consume_token(ID);
      varId = jj_consume_token(ID);
      jj_consume_token(SEMICOLON);
      {if (true) return new VarDecl(new IdentifierType(typeId.toString()), new Identifier(varId.toString()));}
      break;
    case INT:
    case INTARRAY:
    case BOOLEAN:
      var = varDeclarationNoID();
                              {if (true) return var;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public VarDecl varDeclarationNoID() throws ParseException {
  Type type;
  Token varId;
    type = typeNoID();
    varId = jj_consume_token(ID);
    jj_consume_token(SEMICOLON);
    {if (true) return new VarDecl(type, new Identifier(varId.toString()));}
    throw new Error("Missing return statement in function");
  }

  static final public MethodDecl methodDeclaration() throws ParseException {
  Token methodId;
  Type returnType;
  FormalList parameters;
  VarDeclList vars = new VarDeclList();
  StatementList statements = new StatementList();
  Exp returnExpression;
    jj_consume_token(PUBLIC);
    returnType = type();
    methodId = jj_consume_token(ID);
    jj_consume_token(LPAREN);
    parameters = parameterList();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACES);
    methodLoop(vars, statements);
    jj_consume_token(RETURN);
    returnExpression = expression();
    jj_consume_token(SEMICOLON);
    jj_consume_token(RBRACES);
    {if (true) return new MethodDecl(returnType, new Identifier(methodId.toString()), parameters, vars, statements, returnExpression);}
    throw new Error("Missing return statement in function");
  }

  static final public void methodLoop(VarDeclList vars, StatementList statements) throws ParseException {
  Token startingId;
  Statement statement;
  VarDecl var;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      startingId = jj_consume_token(ID);
      identifierStartedLine(startingId, vars, statements);
      break;
    case INT:
    case INTARRAY:
    case BOOLEAN:
      var = varDeclarationNoID();
                             vars.addElement(var);
      methodLoop(vars, statements);
      break;
    case LBRACES:
    case IF:
    case WHILE:
    case SYSOUT:
      statement = statementNoID();
                              statements.addElement(statement);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACES:
        case IF:
        case WHILE:
        case SYSOUT:
        case ID:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_6;
        }
        statement = statement();
                                                                                            statements.addElement(statement);
      }
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  static final public void identifierStartedLine(Token startingId, VarDeclList vars, StatementList statements) throws ParseException {
  Token varId;
  Statement statement;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      varId = jj_consume_token(ID);
      jj_consume_token(SEMICOLON);
                               vars.addElement(new VarDecl(new IdentifierType(startingId.toString()), new Identifier(varId.toString())));
      methodLoop(vars, statements);
      break;
    case EQUAL:
    case LBRACKET:
      statement = identifierStartedStatement(startingId);
                                                     statements.addElement(statement);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACES:
        case IF:
        case WHILE:
        case SYSOUT:
        case ID:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_7;
        }
        statement = statement();
                                                                                                                   statements.addElement(statement);
      }
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Statement identifierStartedStatement(Token startingId) throws ParseException {
  Exp expression1;
  Exp expression2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUAL:
      jj_consume_token(EQUAL);
      expression1 = expression();
      jj_consume_token(SEMICOLON);
                                                     {if (true) return new Assign(new Identifier(startingId.toString()), expression1);}
      break;
    case LBRACKET:
      jj_consume_token(LBRACKET);
      expression1 = expression();
      jj_consume_token(RBRACKET);
      jj_consume_token(EQUAL);
      expression2 = expression();
      jj_consume_token(SEMICOLON);
                                                                                                        {if (true) return new ArrayAssign(new Identifier(startingId.toString()), expression1, expression2);}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Statement statement() throws ParseException {
  Token startingId;
  Statement statement;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      startingId = jj_consume_token(ID);
      statement = identifierStartedStatement(startingId);
      break;
    case LBRACES:
    case IF:
    case WHILE:
    case SYSOUT:
      statement = statementNoID();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return statement;}
    throw new Error("Missing return statement in function");
  }

  static final public FormalList parameterList() throws ParseException {
  FormalList parameters = new FormalList();
  Formal parameter;
  Type type;
  Token id;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case INTARRAY:
    case BOOLEAN:
    case ID:
      type = type();
      id = jj_consume_token(ID);
                            parameters.addElement(new Formal(type, new Identifier(id.toString())));
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[13] = jj_gen;
          break label_8;
        }
        parameter = parameterListTail();
                                                                                                                                        parameters.addElement(parameter);
      }
      break;
    default:
      jj_la1[14] = jj_gen;

    }
    {if (true) return parameters;}
    throw new Error("Missing return statement in function");
  }

  static final public Formal parameterListTail() throws ParseException {
  Type type;
  Token id;
    jj_consume_token(COMMA);
    type = type();
    id = jj_consume_token(ID);
                                    {if (true) return new Formal(type, new Identifier(id.toString()));}
    throw new Error("Missing return statement in function");
  }

  static final public Type type() throws ParseException {
  Token typeId;
  Type type;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      typeId = jj_consume_token(ID);
                    {if (true) return new IdentifierType(typeId.toString());}
      break;
    case INT:
    case INTARRAY:
    case BOOLEAN:
      type = typeNoID();
                      {if (true) return type;}
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Type typeNoID() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
              {if (true) return new IntegerType();}
      break;
    case INTARRAY:
      jj_consume_token(INTARRAY);
                   {if (true) return new IntArrayType();}
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
                  {if (true) return new BooleanType();}
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Statement statementNoID() throws ParseException {
  StatementList blockStatements = new StatementList();
  Statement statement1, statement2;
  Exp expression;
  { }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACES:
      jj_consume_token(LBRACES);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACES:
        case IF:
        case WHILE:
        case SYSOUT:
        case ID:
          ;
          break;
        default:
          jj_la1[17] = jj_gen;
          break label_9;
        }
        statement1 = statement();
                                         blockStatements.addElement(statement1);
      }
      jj_consume_token(RBRACES);
                                                                                                    {if (true) return new Block(blockStatements);}
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(LPAREN);
      expression = expression();
      jj_consume_token(RPAREN);
      statement1 = statement();
      jj_consume_token(ELSE);
      statement2 = statement();
                                                                                                                {if (true) return new If(expression, statement1, statement2);}
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(LPAREN);
      expression = expression();
      jj_consume_token(RPAREN);
      statement1 = statement();
                                                                                   {if (true) return new While(expression, statement1);}
      break;
    case SYSOUT:
      jj_consume_token(SYSOUT);
      jj_consume_token(LPAREN);
      expression = expression();
      jj_consume_token(RPAREN);
      jj_consume_token(SEMICOLON);
                                                                           {if (true) return new Print(expression);}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp expression() throws ParseException {
  Exp firstExp;
  Exp completeExp;
  Token intLiteral;
  Token identifier;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT_LITERAL:
      intLiteral = jj_consume_token(INT_LITERAL);
      completeExp = expressionRecursion(new IntegerLiteral(new Integer(intLiteral.toString())));
                                                                                                                      {if (true) return completeExp;}
      break;
    case TRUE:
      jj_consume_token(TRUE);
      completeExp = expressionRecursion(new True());
                                                         {if (true) return completeExp;}
      break;
    case FALSE:
      jj_consume_token(FALSE);
      completeExp = expressionRecursion(new False());
                                                           {if (true) return completeExp;}
      break;
    case ID:
      identifier = jj_consume_token(ID);
      completeExp = expressionRecursion(new IdentifierExp(identifier.toString()));
                                                                                                {if (true) return completeExp;}
      break;
    case THIS:
      jj_consume_token(THIS);
      completeExp = expressionRecursion(new This());
                                                         {if (true) return completeExp;}
      break;
    case NEW:
      jj_consume_token(NEW);
      firstExp = newStartedExpression();
      completeExp = expressionRecursion(firstExp);
                                                                                      {if (true) return completeExp;}
      break;
    case NOT:
      jj_consume_token(NOT);
      firstExp = expression();
      completeExp = expressionRecursion(new Not(firstExp));
                                                                                     {if (true) return completeExp;}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      firstExp = expression();
      jj_consume_token(RPAREN);
      completeExp = expressionRecursion(firstExp);
                                                                                          {if (true) return completeExp;}
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp newStartedExpression() throws ParseException {
  Exp arraySize;
  Token classId;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      jj_consume_token(LBRACKET);
      arraySize = expression();
      jj_consume_token(RBRACKET);
                                                             {if (true) return new NewArray(arraySize);}
      break;
    case ID:
      classId = jj_consume_token(ID);
      jj_consume_token(LPAREN);
      jj_consume_token(RPAREN);
                                         {if (true) return new NewObject(new Identifier(classId.toString()));}
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp expressionRecursion(Exp firstExp) throws ParseException {
  Exp secondExp;
  Exp completeExp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      secondExp = expression();
      completeExp = expressionRecursion(new Plus(firstExp, secondExp));
                                                                                                   {if (true) return completeExp;}
      break;
    case AND:
      jj_consume_token(AND);
      secondExp = expression();
      completeExp = expressionRecursion(new And(firstExp, secondExp));
                                                                                                 {if (true) return completeExp;}
      break;
    case LESSTHAN:
      jj_consume_token(LESSTHAN);
      secondExp = expression();
      completeExp = expressionRecursion(new LessThan(firstExp, secondExp));
                                                                                                           {if (true) return completeExp;}
      break;
    case MINUS:
      jj_consume_token(MINUS);
      secondExp = expression();
      completeExp = expressionRecursion(new Minus(firstExp, secondExp));
                                                                                                     {if (true) return completeExp;}
      break;
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
      secondExp = expression();
      completeExp = expressionRecursion(new Times(firstExp, secondExp));
                                                                                                        {if (true) return completeExp;}
      break;
    case LBRACKET:
      jj_consume_token(LBRACKET);
      secondExp = expression();
      jj_consume_token(RBRACKET);
      completeExp = expressionRecursion(new ArrayLookup(firstExp, secondExp));
                                                                                                                           {if (true) return completeExp;}
      break;
    case DOT:
      jj_consume_token(DOT);
      secondExp = dotStartedExpressionRecursion(firstExp);
      completeExp = expressionRecursion(secondExp);
                                                                                                         {if (true) return completeExp;}
      break;
    default:
      jj_la1[21] = jj_gen;
    {if (true) return firstExp;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp dotStartedExpressionRecursion(Exp firstExp) throws ParseException {
  Token methodId;
  ExpList parameters;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LENGTH:
      jj_consume_token(LENGTH);
               {if (true) return new ArrayLength(firstExp);}
      break;
    case ID:
      methodId = jj_consume_token(ID);
      jj_consume_token(LPAREN);
      parameters = expressionList();
      jj_consume_token(RPAREN);
                                                                      {if (true) return new Call(firstExp, new Identifier(methodId.toString()), parameters);}
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpList expressionList() throws ParseException {
  Exp e;
  ExpList expressions = new ExpList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
    case LPAREN:
    case TRUE:
    case FALSE:
    case THIS:
    case NEW:
    case INT_LITERAL:
    case ID:
      e = expression();
                   expressions.addElement(e);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[23] = jj_gen;
          break label_10;
        }
        e = expressionListTail();
                                                                           expressions.addElement(e);
      }
                                                                                                             {if (true) return expressions;}
      break;
    default:
      jj_la1[24] = jj_gen;
    {if (true) return expressions;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp expressionListTail() throws ParseException {
  Exp e;
    jj_consume_token(COMMA);
    e = expression();
                             {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MiniJavaParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x2000000,0x0,0x2000000,0x80100000,0x0,0x100000,0x100000,0x100000,0x60000,0x60000,0x100000,0x8000,0x0,0x0,0x0,0x100000,0x100000,0x18402000,0x0,0x51f00,0x0,0x8000,0x18402000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x20,0x11c00,0x0,0x11c00,0x0,0x0,0x11c00,0x1001a,0x11c1a,0x1001a,0x10000,0x0,0x1001a,0x0,0x11c00,0x11c00,0x1c00,0x1001a,0x1a,0x180c0,0x10400,0x0,0x10100,0x0,0x180c0,};
   }

  /** Constructor with InputStream. */
  public MiniJavaParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MiniJavaParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MiniJavaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MiniJavaParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MiniJavaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MiniJavaParser(MiniJavaParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MiniJavaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[49];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 49; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
