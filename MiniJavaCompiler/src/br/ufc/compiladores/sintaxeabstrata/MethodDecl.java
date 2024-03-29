package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class MethodDecl {
	public Type type;
	public Identifier identifier;
	public FormalList formalList;
	public VarDeclList varDeclList;
	public StatementList statementList;
	public Exp exp;

	public MethodDecl(Type at, Identifier ai, FormalList afl, VarDeclList avl,
			StatementList asl, Exp ae) {
		type = at;
		identifier = ai;
		formalList = afl;
		varDeclList = avl;
		statementList = asl;
		exp = ae;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}
