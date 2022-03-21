package alex;

import java.io.FileInputStream;
import java.io.Reader;

import java.io.InputStreamReader;
import java.io.IOException;

public class AnalizadorLexicoTiny {

   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
    INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_IGUAL,
    REC_MAS, REC_MENOS, REC_ID, REC_ENT, REC_0, REC_IDEC, REC_DEC, REC_EOF, REC_MENOR,
    REC_MENORIGUAL, REC_MAYOR, REC_MAYORIGUAL, REC_IGIG, REC_EXCLAM, REC_NOIG, REC_AMP, REC_SEPARADOR,
    REC_PUNTOCOMA, REC_PUNTO, REC_E, REC_E0, REC_ESIGNO, REC_EXP
   }

   private Estado estado;

   public AnalizadorLexicoTiny(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }

   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INICIO;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INICIO: 
              if(hayLetra())  transita(Estado.REC_ID);
              else if (hayDigitoPos()) transita(Estado.REC_ENT);
              else if (hayCero()) transita(Estado.REC_0);
              else if (haySuma()) transita(Estado.REC_MAS);
              else if (hayResta()) transita(Estado.REC_MENOS);
              else if (hayMul()) transita(Estado.REC_POR);
              else if (hayDiv()) transita(Estado.REC_DIV);
              else if (hayPAp()) transita(Estado.REC_PAP);
              else if (hayPCierre()) transita(Estado.REC_PCIERR);
              else if (hayIgual()) transita(Estado.REC_IGUAL);
              else if (haySep()) transitaIgnorando(Estado.INICIO);
              else if (hayEOF()) transita(Estado.REC_EOF);
	          else if (hayMenor()) transita(Estado.REC_MENOR);
	          else if (hayMayor()) transita(Estado.REC_MAYOR);
	          else if (hayExcl()) transita(Estado.REC_EXCLAM);
	          else if (hayAmp()) transita(Estado.REC_AMP);
	          else if (hayPuntocoma()) transita(Estado.REC_PUNTOCOMA);
              else error();
              break;
           case REC_ID: 
              if (hayLetra() || hayDigito() || hayBarrabaja()) transita(Estado.REC_ID);
              else return unidadId();               
              break;
           case REC_ENT:
               if (hayDigito()) transita(Estado.REC_ENT);
               else if (hayPunto()) transita(Estado.REC_PUNTO);
               else if (hayE()) transita(Estado.REC_E);
               else return unidadEnt();
               break;
           case REC_0:
               if (hayPunto()) transita(Estado.REC_PUNTO);
               else if (hayE()) transita(Estado.REC_E);
               else return unidadEnt();
               break;
           case REC_MAS:
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMas();
               break;
           case REC_MENOS: 
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMenos();
               break;
           case REC_POR: return unidadPor();
           case REC_DIV: return unidadDiv();              
           case REC_PAP: return unidadPAp();
           case REC_PCIERR: return unidadPCierre();
           case REC_IGUAL:
        	   if(hayIgual()) transita(Estado.REC_IGIG);
        	   else return unidadIgual();
        	   break;
           case REC_IGIG: return unidadIGIG();
           case REC_EXCLAM:
        	   if(hayIgual()) transita(Estado.REC_NOIG);
        	   else error();
        	   break;
           case REC_NOIG: return unidadNoIg();
           case REC_PUNTOCOMA: return unidadPuntocoma();
           case REC_AMP:
        	   if(hayAmp()) transita(Estado.REC_SEPARADOR);
        	   else error();
        	   break;
           case REC_SEPARADOR: return unidadAmp();
           case REC_MENOR: 
        	   if(hayIgual()) transita(Estado.REC_MENORIGUAL);
        	   else return unidadMenor();
        	   break;
           case REC_MAYOR: 
        	   if(hayIgual()) transita(Estado.REC_MAYORIGUAL);
        	   else return unidadMayor();
        	   break;
           case REC_MENORIGUAL: return unidadMenorI();
           case REC_MAYORIGUAL: return unidadMayorI();
           case REC_EOF: return unidadEof();
           case REC_IDEC:
               if (hayDigitoPos()) transita(Estado.REC_DEC);
               else if (hayCero()) transita(Estado.REC_IDEC);
               else error();
               break;
           case REC_DEC: 
               if (hayDigitoPos()) transita(Estado.REC_DEC);
               else if (hayCero()) transita(Estado.REC_IDEC);
               else if (hayE()) transita(Estado.REC_E);
               else return unidadReal();
               break;
		case REC_E:
			if (hayCero()) transita(Estado.REC_E0);
			else if (haySuma() || hayResta()) transita(Estado.REC_ESIGNO);
			else if (hayDigitoPos()) transita(Estado.REC_EXP);
			else error();
			break;
		case REC_E0: return unidadReal();
		case REC_ESIGNO:
			if (hayCero()) transita(Estado.REC_E0);
			else if(hayDigitoPos()) transita(Estado.REC_EXP);
			else error();
			break;
		case REC_EXP:
			if(hayDigito()) transita(Estado.REC_EXP);
			else return unidadReal();
			break;
		case REC_PUNTO:
			if(hayDigito()) transita(Estado.REC_DEC);
			else error();
			break;
         }
     }    
   }
   private void transita(Estado sig) throws IOException {
     lex.append((char)sigCar);
     sigCar();         
     estado = sig;
   }
   private void transitaIgnorando(Estado sig) throws IOException {
     sigCar();         
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     estado = sig;
   }
   private void sigCar() throws IOException {
     sigCar = input.read();
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'Z';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean haySuma() {return sigCar == '+';}
   private boolean hayResta() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean hayMenor() {return sigCar == '<';}
   private boolean hayMayor() {return sigCar == '>';}
   private boolean hayExcl() {return sigCar == '!';}
   private boolean hayAmp() {return sigCar == '&';}
   private boolean hayPuntocoma() {return sigCar == ';';}
   private boolean hayBarrabaja() {return sigCar == '_';}
   private boolean hayE() {return sigCar == 'e' || sigCar == 'E';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   //private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
   private UnidadLexica unidadId() {
     switch(lex.toString()) {
         case "real":  
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TREAL);
         case "bool":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TBOOL);
         case "int":  
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TENT);
         case "and":  
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
         case "or":  
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
         case "not":  
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
         case "true":  
             return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL, lex.toString());
         case "false":  
             return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL, lex.toString());
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN,lex.toString());     
      }
   }  
   private UnidadLexica unidadEnt() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ENT,lex.toString());     
   }    
   private UnidadLexica unidadReal() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.REAL,lex.toString());     
   }    
   private UnidadLexica unidadMas() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
   }    
   private UnidadLexica unidadMenos() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
   }    
   private UnidadLexica unidadPor() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
   }    
   private UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
   }    
   private UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
   }    
   private UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
   }    
   private UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);     
   }
   private UnidadLexica unidadPuntocoma() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PUNTOCOMA);     
   }
   private UnidadLexica unidadAmp() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SEPARADOR);     
   }
   private UnidadLexica unidadMenor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
   }
   private UnidadLexica unidadMayor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
   }
   private UnidadLexica unidadMenorI() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENORI);     
   } 
   private UnidadLexica unidadMayorI() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYORI);     
   }
   private UnidadLexica unidadIGIG() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGIG);     
   } 
   private UnidadLexica unidadNoIg() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOIG);     
   } 
   private UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
   }    
   private void error() {
     System.err.println("("+filaActual+','+columnaActual+"):Caracter inexperado");  
     System.exit(1);
   }

   public static void main(String arg[]) throws IOException {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     do {
       unidad = al.sigToken();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    } 
}