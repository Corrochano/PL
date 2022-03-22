
package asint;

import alex.UnidadLexica;
import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import errors.GestionErroresTiny;
import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintacticoTiny {
   private UnidadLexica anticipo;
   private AnalizadorLexicoTiny alex;
   private GestionErroresTiny errores;
   public AnalizadorSintacticoTiny(Reader input) {
     
      try {
         errores = new GestionErroresTiny();
         alex = new AnalizadorLexicoTiny(input);
      } catch (IOException e) {
         errores.errorFatal(e);
      }
      sigToken();
   }

   public void Sp(){
      S();
      empareja(ClaseLexica.EOF);
   }

   public void S(){
     switch(anticipo.clase()){
      case TENT:
      case TREAL:
      case TBOOL:
         D0();
         empareja(ClaseLexica.SEPARADOR);
         A0();
         break;
        
      default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
     }

     // empareja(ClaseLexica.EOF);
   }
   public void D0(){
      switch(anticipo.clase()){
         case TENT:
         case TREAL:
         case TBOOL:
            D1();
            D0_1();
            break;
            default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
      }
   }
   public void D0_1(){
      switch(anticipo.clase()){
         case PUNTOCOMA: 
            empareja(ClaseLexica.PUNTOCOMA);
            D1();
            D0_1();
            break;
         case SEPARADOR:
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOCOMA, ClaseLexica.SEPARADOR);
      }
   }
   public void D1(){
      switch(anticipo.clase()){
         case TENT:
            empareja(ClaseLexica.TENT);
            empareja(ClaseLexica.IDEN);
            break;
         case TREAL:
            empareja(ClaseLexica.TREAL);
            empareja(ClaseLexica.IDEN);
            break;
         case TBOOL:
            empareja(ClaseLexica.TBOOL);
            empareja(ClaseLexica.IDEN);
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
      }
   }
   public void A0(){
      switch(anticipo.clase()){
         case IDEN: 
            A1();
            A0_1();
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IDEN);
      }
   }
   public void A0_1(){
      switch(anticipo.clase()){
         case PUNTOCOMA: 
         empareja(ClaseLexica.PUNTOCOMA);
            A1();
            A0_1();
            break;
         case EOF:
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOCOMA, ClaseLexica.EOF);
      }
   }
   public void A1(){
      switch(anticipo.clase()){
         case IDEN:
            empareja(ClaseLexica.IDEN);
            empareja(ClaseLexica.IGUAL);
            E0(); 
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IDEN);
      }
   }
   public void E0(){
      switch(anticipo.clase()){
         case MAS:
         case MENOS:
         case AND:
         case OR:
         case MENOR:
         case MENORI:
         case MAYOR:
         case MAYORI:
         case IGIG:
         case NOIG:
         case NOT:
         case DIV:
         case POR:
         case REAL:
         case ENT:
         case IDEN:
         case BOOL:
         case PAP:
            E1();
            E0_1();
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR, 
                                          ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, ClaseLexica.IGIG, ClaseLexica.NOIG,
                                          ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
      }
   }
   public void E0_1(){
      switch(anticipo.clase()){
         case MAS:
            empareja(ClaseLexica.MAS);
            E0(); 
            break;
         case MENOS:
            empareja(ClaseLexica.MENOS);
            E1();
            break;
         case PUNTOCOMA:
         case EOF:
         case PCIERRE:
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.PUNTOCOMA, ClaseLexica.EOF, 
                                          ClaseLexica.PCIERRE);
      }
   }
   public void E1(){
      switch(anticipo.clase()){
         case AND:
         case OR:
         case MENOR:
         case MENORI:
         case MAYOR:
         case MAYORI:
         case IGIG:
         case NOIG:
         case NOT:
         case DIV:
         case POR:
         case REAL:
         case ENT:
         case IDEN:
         case BOOL:
         case PAP:
            E2();
            E1_1();
            break;
            default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR, 
            ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, ClaseLexica.IGIG, ClaseLexica.NOIG,
            ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, 
            ClaseLexica.PAP);
      }
   }
   public void E1_1(){
      switch(anticipo.clase()){
         case AND: empareja(ClaseLexica.AND); E2(); E1_1(); break;
         case OR: empareja(ClaseLexica.OR); E2(); E1_1(); break;
         case MAS:
         case MENOS:
         case PUNTOCOMA:
         case PCIERRE:
         case EOF:
         break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS, 
                                          ClaseLexica.PUNTOCOMA, ClaseLexica.PCIERRE);
      }
   }
   public void E2(){
      switch(anticipo.clase()){
         case MENOR:
         case MENORI:
         case MAYOR:
         case MAYORI:
         case IGIG:
         case NOIG:
         case MENOS:
         case NOT:
         case DIV:
         case POR:
         case REAL:
         case ENT:
         case IDEN:
         case BOOL:
         case PAP:
            E3();
            E2_1();
         break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, 
                                          ClaseLexica.IGIG, ClaseLexica.NOIG, ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, 
                                          ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
      }
   }
   public void E2_1(){
      switch(anticipo.clase()){
         case MENOR: empareja(ClaseLexica.MENOR); E3(); E2_1(); break;
         case MENORI: empareja(ClaseLexica.MENORI); E3(); E2_1(); break;
         case MAYOR: empareja(ClaseLexica.MAYOR); E3(); E2_1(); break;
         case MAYORI: empareja(ClaseLexica.MAYORI); E3(); E2_1(); break;
         case IGIG: empareja(ClaseLexica.IGIG); E3(); E2_1(); break;
         case NOIG: empareja(ClaseLexica.NOIG); E3(); E2_1(); break;
         case MAS:
         case MENOS:
         case AND:
         case OR:
         case PUNTOCOMA:
         case PCIERRE:
         case EOF:
          break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, 
                                          ClaseLexica.IGIG, ClaseLexica.NOIG, ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.PUNTOCOMA, 
                                          ClaseLexica.PCIERRE);
      }
   }
   public void E3(){
      switch(anticipo.clase()){
         case MENOS:
         case NOT:
         case POR:
         case REAL:
         case ENT:
         case IDEN:
         case BOOL:
         case PAP:
            E4();
            E3_0();
         break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.POR, ClaseLexica.REAL, 
                                          ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
      }
   }
   public void E3_0(){
      switch(anticipo.clase()){
         case DIV: empareja(ClaseLexica.DIV); E4(); break;
         case POR: empareja(ClaseLexica.POR); E4(); break;
         case MENOR:
         case MENORI:
         case MAYOR:
         case MAYORI:
         case IGIG:
         case NOIG:
         case AND:
         case OR:
         case MAS:
         case MENOS:
         case PUNTOCOMA:
         case PCIERRE:
         case EOF:
         break;
         
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.MENOR, ClaseLexica.MENORI, 
                                          ClaseLexica.MAYOR, ClaseLexica.MAYORI, ClaseLexica.IGIG, ClaseLexica.NOIG, ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, 
                                          ClaseLexica.MENOS, ClaseLexica.PUNTOCOMA, ClaseLexica.PCIERRE);
      }
   }
   public void E4(){
      switch(anticipo.clase()){
         case MENOS: empareja(ClaseLexica.MENOS); E5(); break;
         case NOT: empareja(ClaseLexica.NOT); E4(); break;
         case PAP: 
         case ENT:
         case REAL:
         case BOOL:
         case IDEN:
            E5(); 
            break;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, ClaseLexica.NOT);
      }
   }
   public void E5(){
      switch(anticipo.clase()){
         case REAL: empareja(ClaseLexica.REAL); break;
         case ENT: empareja(ClaseLexica.ENT); break;
         case IDEN: empareja(ClaseLexica.IDEN); break;
         case BOOL: empareja(ClaseLexica.BOOL); break;
         case PAP: empareja(ClaseLexica.PAP); E0(); empareja(ClaseLexica.PCIERRE); break; 

         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, 
                                          ClaseLexica.PAP);
      }
   }

private void empareja(ClaseLexica claseEsperada) {
   if (anticipo.clase() == claseEsperada)
         sigToken();
   else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
}
private void sigToken() {
   try {
      anticipo = alex.sigToken();
   }
   catch(IOException e) {
      errores.errorFatal(e);
      }
   }   

}

















/*
   
   public void Sp() {
      S();
      empareja(ClaseLexica.EOF);
   }
   private void S() {
     switch(anticipo.clase()) {
         case EVALUA:          
              empareja(ClaseLexica.EVALUA);
              E0();
              Ds();
              break;
         default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.EVALUA);                                            
   }
   }
   private void Ds() {
      switch(anticipo.clase()) {
          case EOF: break;
          default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.EOF);                                       
      } 
   }
   private void LDs() {
      switch(anticipo.clase()) {
       case IDEN:    
           D();
           RLDs();
           break;
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                                       
   }
   }    
   private void RLDs() {
      switch(anticipo.clase()) {
       case EOF: break;    
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.EOF);                                       
      }          
   }   
   private void D() {
     switch(anticipo.clase()) {       
       case IDEN:   
        empareja(ClaseLexica.IDEN);
        empareja(ClaseLexica.IGUAL);
        E0();
        break;
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                                       
     }
   }
   private void E0() {
     switch(anticipo.clase()) {
         case IDEN: case ENT: case REAL: case PAP:
             E1();
             RE0();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.ENT,
                                           ClaseLexica.REAL, ClaseLexica.PAP);                                    
     }  
   }
   private void RE0() {
      switch(anticipo.clase()) {
          case MAS: case MENOS: 
             Op0();
             E1();
             RE0();
             break;
          case PCIERRE: case EOF: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);                                              
      } 
   }
   private void E1() {
     switch(anticipo.clase()) {
         case IDEN: case ENT: case REAL: case PAP:
             E2();
             RE1();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.ENT,
                                           ClaseLexica.REAL, ClaseLexica.PAP);                                    
     }  
   }
   private void RE1() {
      switch(anticipo.clase()) {
          case POR: case DIV: 
             Op1();
             E2();
             RE1();
             break;
          case PCIERRE: case EOF: case MAS: case MENOS: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV,
                                      ClaseLexica.MAS, ClaseLexica.MENOS);                                              
      } 
   }
   private void E2() {
      switch(anticipo.clase()) {
          case ENT: empareja(ClaseLexica.ENT); break;
          case REAL: empareja(ClaseLexica.REAL); break; 
          case IDEN: empareja(ClaseLexica.IDEN); break;
          case PAP: 
               empareja(ClaseLexica.PAP); 
               E0(); 
               empareja(ClaseLexica.PCIERRE); 
               break;
          default:     
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.ENT,ClaseLexica.REAL,
                                      ClaseLexica.PAP);
   }   
   }
   private void Op0() {
     switch(anticipo.clase()) {
         case MAS: empareja(ClaseLexica.MAS); break;  
         case MENOS: empareja(ClaseLexica.MENOS); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);
     }  
   }
   private void Op1() {
     switch(anticipo.clase()) {
         case POR: empareja(ClaseLexica.POR); break;  
         case DIV: empareja(ClaseLexica.DIV); break;  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV);
     }  
   }
   
   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
   }
   private void sigToken() {
      try {
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
  */ 
