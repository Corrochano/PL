package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.IDEN,
                                         alex.lexema()); 
  } 

   public UnidadLexica unidadReal() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL); 
   }

   public UnidadLexica unidadEnt() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENT); 
   }

   public UnidadLexica unidadCadena() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadBool() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
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
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadMenor() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadMayorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadMenorI() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadIgIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadNoIg() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadOr() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadNot() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadAnd() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadPAp() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
   }

   public UnidadLexica unidadPCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
   }

   public UnidadLexica unidadCap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadCCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadLap() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadLCierre() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtCadena() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtEnt() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtBool() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtReal() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtPointer() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadtArray() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadPuntocoma() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadSepseccion() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadModulo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadPunto() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadFlecha() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadAmpersand() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadNull() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadProc() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadIf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadThen() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadElse() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadEndif() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadWhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadDo() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadEndwhile() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadCall() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadRecord() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadOf() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadNew() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadDelete() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadRead() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadWrite() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadNl() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadVar() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadType() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
   }

   public UnidadLexica unidadEof() {
	     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
   }

   public void error() {
      System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
   }

  

  
}
