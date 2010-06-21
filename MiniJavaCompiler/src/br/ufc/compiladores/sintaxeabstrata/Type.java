package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.Visitor;
import br.ufc.compiladores.visitors.TypeVisitor;

public abstract class Type {
  public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
}
