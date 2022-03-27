package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.IDENT, alex.lexema()); 
  } 

   public UnidadLexica unidadReal() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NUMREAL, alex.lexema()); 
   }

   public UnidadLexica unidadEnt() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NUMENT, alex.lexema()); 
   }

   public UnidadLexica unidadCadena() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.CADENA, alex.lexema()); 
   }

   public UnidadLexica unidadBool() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.UNIDADBOOL, alex.lexema()); 
   }

   public UnidadLexica unidadSuma() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAS, "+"); 
   }

   public UnidadLexica unidadResta() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS, "-"); 
   }

   public UnidadLexica unidadMul() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POR, "*"); 
   }

   public UnidadLexica unidadDiv() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DIV, "/"); 
   }

   public UnidadLexica unidadIgual() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGUAL, "="); 
   }

   public UnidadLexica unidadComa() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA, ","); 
   }

   public UnidadLexica unidadMayor() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYOR, ">"); 
   }

   public UnidadLexica unidadMenor() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOR, "<"); 
   }

   public UnidadLexica unidadMayorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYORIGUAL,">="); 
   }

   public UnidadLexica unidadMenorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENORIGUAL, "<="); 
   }

   public UnidadLexica unidadIgIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EQUIV, "=="); 
   }

   public UnidadLexica unidadNoIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOEQUIV, "!="); 
   }

   public UnidadLexica unidadOr() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OR, "or"); 
   }

   public UnidadLexica unidadNot() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOT, "not"); 
   }

   public UnidadLexica unidadAnd() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AND, "and"); 
   }

   public UnidadLexica unidadPAp() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP, "("); 
   }

   public UnidadLexica unidadPCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE, ")"); 
   }

   public UnidadLexica unidadCap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CAP, "["); 
   }

   public UnidadLexica unidadCCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CCIERRE, "]"); 
   }

   public UnidadLexica unidadLap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LAP, "{"); 
   }

   public UnidadLexica unidadLCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LCIERRE, "}"); 
   }

   public UnidadLexica unidadtCadena() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.STRING, "string"); 
   }

   public UnidadLexica unidadtEnt() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.INT, "int"); 
   }

   public UnidadLexica unidadtBool() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BOOL, "bool"); 
   }

   public UnidadLexica unidadtReal() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL, "real"); 
   }

   public UnidadLexica unidadtPointer() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POINTER, "pointer"); 
   }

   public UnidadLexica unidadtArray() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ARRAY, "array"); 
   }

   public UnidadLexica unidadPuntocoma() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCOMA, ";"); 
   }

   public UnidadLexica unidadSepseccion() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEPARADOR, "&&"); 
   }

   public UnidadLexica unidadModulo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MODULO, "%"); 
   }

   public UnidadLexica unidadPunto() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO, "."); 
   }

   public UnidadLexica unidadFlecha() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FLECHA, "->"); 
   }

   public UnidadLexica unidadAmpersand() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AMP, "&"); 
   }

   public UnidadLexica unidadNull() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NULL, "NULL"); 
   }

   public UnidadLexica unidadProc() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PROC, "proc"); 
   }

   public UnidadLexica unidadIf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IF, "if"); 
   }

   public UnidadLexica unidadThen() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.THEN, "then"); 
   }

   public UnidadLexica unidadElse() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ELSE, "else"); 
   }

   public UnidadLexica unidadEndif() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDIF, "endif"); 
   }

   public UnidadLexica unidadWhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WHILE, "while"); 
   }

   public UnidadLexica unidadDo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DO, "do"); 
   }

   public UnidadLexica unidadEndwhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE, "endwhile"); 
   }

   public UnidadLexica unidadCall() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CALL, "call"); 
   }

   public UnidadLexica unidadRecord() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.RECORD, "record"); 
   }

   public UnidadLexica unidadOf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OF, "of"); 
   }

   public UnidadLexica unidadNew() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEW, "new"); 
   }

   public UnidadLexica unidadDelete() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DELETE, "delete"); 
   }

   public UnidadLexica unidadRead() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.READ, "read"); 
   }

   public UnidadLexica unidadWrite() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WRITE, "write"); 
   }

   public UnidadLexica unidadNl() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NL, "nl"); 
   }

   public UnidadLexica unidadVar() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.VAR, "var"); 
   }

   public UnidadLexica unidadType() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TYPE, "type"); 
   }

   public UnidadLexica unidadEof() {
	     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF, "<EOF>"); 
   }
   
   public UnidadLexica unidadNeg() {
	     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEG, "-"); 
   }
   
   public UnidadLexica unidadIndireccion() {
	     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.INDIRECCION, "*"); 
   }


   public void error() {
      System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
   }

  

  
}
