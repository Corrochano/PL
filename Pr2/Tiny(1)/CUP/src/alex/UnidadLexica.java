package alex;

import java_cup.runtime.Symbol;

public abstract class UnidadLexica extends Symbol{
   private int fila;
   private int columna;
   public UnidadLexica(int fila, int columna, int clase, String lexema) {
     super(clase, lexema);
     this.fila = fila;
     this.columna = columna;
   }
   public abstract String lexema();
   public int fila() {return fila;}
   public int columna() {return columna;}
   public int clase() {return sym;}
}
