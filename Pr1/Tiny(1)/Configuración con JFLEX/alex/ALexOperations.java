package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.IDEN, alex.lexema()); 
  } 

   public UnidadLexica unidadReal() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL, alex.lexema()); 
   }

   public UnidadLexica unidadEnt() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.ENT, alex.lexema()); 
   }

   public UnidadLexica unidadCadena() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.CADENA, alex.lexema()); 
   }

   public UnidadLexica unidadBool() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.BOOL, alex.lexema()); 
   }

   public UnidadLexica unidadSuma() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAS); 
   }

   public UnidadLexica unidadResta() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadMul() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POR); 
   }

   public UnidadLexica unidadDiv() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DIV); 
   }

   public UnidadLexica unidadIgual() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGUAL); 
   }

   public UnidadLexica unidadComa() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA); 
   }

   public UnidadLexica unidadMayor() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYOR); 
   }

   public UnidadLexica unidadMenor() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOR); 
   }

   public UnidadLexica unidadMayorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYORI); 
   }

   public UnidadLexica unidadMenorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENORI); 
   }

   public UnidadLexica unidadIgIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGIG); 
   }

   public UnidadLexica unidadNoIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOIG); 
   }

   public UnidadLexica unidadOr() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OR); 
   }

   public UnidadLexica unidadNot() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOT); 
   }

   public UnidadLexica unidadAnd() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AND); 
   }

   public UnidadLexica unidadPAp() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
   }

   public UnidadLexica unidadPCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
   }

   public UnidadLexica unidadCap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CAP); 
   }

   public UnidadLexica unidadCCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CCIERRE); 
   }

   public UnidadLexica unidadLap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LAP); 
   }

   public UnidadLexica unidadLCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LCIERRE); 
   }

   public UnidadLexica unidadtCadena() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TCADENA); 
   }

   public UnidadLexica unidadtEnt() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TENT); 
   }

   public UnidadLexica unidadtBool() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TBOOL); 
   }

   public UnidadLexica unidadtReal() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TREAL); 
   }

   public UnidadLexica unidadtPointer() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TPOINTER); 
   }

   public UnidadLexica unidadtArray() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TARRAY); 
   }

   public UnidadLexica unidadPuntocoma() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTOCOMA); 
   }

   public UnidadLexica unidadSepseccion() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEPARADOR); 
   }

   public UnidadLexica unidadModulo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MODULO); 
   }

   public UnidadLexica unidadPunto() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO); 
   }

   public UnidadLexica unidadFlecha() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FLECHA); 
   }

   public UnidadLexica unidadAmpersand() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AMPERSAND); 
   }

   public UnidadLexica unidadNull() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NULL); 
   }

   public UnidadLexica unidadProc() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PROC); 
   }

   public UnidadLexica unidadIf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IF); 
   }

   public UnidadLexica unidadThen() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.THEN); 
   }

   public UnidadLexica unidadElse() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ELSE); 
   }

   public UnidadLexica unidadEndif() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDIF); 
   }

   public UnidadLexica unidadWhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WHILE); 
   }

   public UnidadLexica unidadDo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DO); 
   }

   public UnidadLexica unidadEndwhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE); 
   }

   public UnidadLexica unidadCall() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CALL); 
   }

   public UnidadLexica unidadRecord() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.RECORD); 
   }

   public UnidadLexica unidadOf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OF); 
   }

   public UnidadLexica unidadNew() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEW); 
   }

   public UnidadLexica unidadDelete() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DELETE); 
   }

   public UnidadLexica unidadRead() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.READ); 
   }

   public UnidadLexica unidadWrite() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WRITE); 
   }

   public UnidadLexica unidadNl() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NL); 
   }

   public UnidadLexica unidadVar() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.VAR); 
   }

   public UnidadLexica unidadType() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TYPE); 
   }

   public UnidadLexica unidadEof() {
	     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
   }


   public void error() {
      System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
   }

  

  
}
