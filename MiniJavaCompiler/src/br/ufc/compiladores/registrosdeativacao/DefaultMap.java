package br.ufc.compiladores.registrosdeativacao;

public class DefaultMap implements TempMap {
	public String tempMap(Temp t) {
		return t.toString();
	}

	public DefaultMap() {
	}
}
