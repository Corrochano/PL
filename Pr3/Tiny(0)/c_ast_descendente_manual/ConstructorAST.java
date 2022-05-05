package c_ast_descendente_manual;

import java.io.IOException;
import java.io.Reader;

import asint.TinyASint;
import asint.TinyASint.*;
import semops.SemOps;


public class ConstructorAST {
   private UnidadLexica anticipo;
   private AnalizadorLexicoTiny alex;
   private GestionErrores errores;
   private SemOps sem;
   
   public ConstructorAST (Reader input) throws IOException {
	  errores = new GestionErrores();
      alex = new AnalizadorLexicoTiny(input);
      
      sigToken();
      sem = new SemOps();
   }

   public Programa Sp(){
      Programa prog = S();
      empareja(ClaseLexica.EOF);
      return prog;
   }

   private Programa S(){
     switch(anticipo.clase()){
      case TENT:
      case TREAL:
      case TBOOL:
         Decs decs = D0();
         empareja(ClaseLexica.SEPARADOR);
         Asigs asigs = A0();
         return new Programa(decs, asigs);
        
      default: 
         errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
         return null;
     }
   }
   private Decs D0(){//una
      switch(anticipo.clase()){
         case TENT:
         case TREAL:
         case TBOOL:
         Dec dec = D1();
         return D0_1(new TinyASint.Declaracion_una(dec));         
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
            return null;      
      }
   }
   private Decs D0_1(Decs decsh){//muchas
      switch(anticipo.clase()){
         case PUNTOCOMA: 
          empareja(ClaseLexica.PUNTOCOMA);
          Dec dec = D1();
          return D0_1(new TinyASint.Declaraciones_muchas(decsh, dec));
         case SEPARADOR:
              return decsh;
         default: 
          errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOCOMA);
          return null;
      }

   }
   private Dec D1(){//dec
      switch(anticipo.clase()){
         case TENT:
            UnidadLexica tkTipo = anticipo;
            empareja(ClaseLexica.TENT);
            UnidadLexica tkIden = anticipo;
            empareja(ClaseLexica.IDEN);
         
            return(new TinyASint.Dec(new TinyASint.Entero(new TinyASint.StringLocalizado("entero",tkTipo.fila(),tkTipo.columna())),
               new TinyASint.StringLocalizado(tkIden.lexema(),tkIden.fila(),tkIden.columna())));

         case TREAL:
            UnidadLexica tkTipo2 = anticipo;
            empareja(ClaseLexica.TREAL);
            UnidadLexica tkIden2 = anticipo;
            empareja(ClaseLexica.IDEN);
         
            return(new TinyASint.Dec(new TinyASint.Real(new TinyASint.StringLocalizado("real",tkTipo2.fila(),tkTipo2.columna())),
               new TinyASint.StringLocalizado(tkIden2.lexema(),tkIden2.fila(),tkIden2.columna())));

         case TBOOL:
            UnidadLexica tkTipo3 = anticipo;
            empareja(ClaseLexica.TBOOL);
            UnidadLexica tkIden3 = anticipo;
            empareja(ClaseLexica.IDEN);
         
            return(new TinyASint.Dec(new TinyASint.Bool(new TinyASint.StringLocalizado("bool",tkTipo3.fila(),tkTipo3.columna())),
               new TinyASint.StringLocalizado(tkIden3.lexema(),tkIden3.fila(),tkIden3.columna())));

         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.TENT, ClaseLexica.TREAL, ClaseLexica.TBOOL);
            return null;
      }
   }
   private Asigs A0(){
      switch(anticipo.clase()){
         case IDEN: 
            Asig asig = A1();
            return A0_1(new Asignacion_una(asig));
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IDEN);
            return null;
      }
   }
   private Asigs A0_1(Asigs asigsh){
      switch(anticipo.clase()){
         case PUNTOCOMA: 
        	 empareja(ClaseLexica.PUNTOCOMA);
             Asig asig = A1();
            return A0_1(new Asignacion_muchas(asigsh, asig));
         case EOF:
            return asigsh;
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOCOMA);
            return null;
      }
   }
   private Asig A1(){
      switch(anticipo.clase()){
         case IDEN:
            UnidadLexica iden = anticipo;
            empareja(ClaseLexica.IDEN);
            empareja(ClaseLexica.IGUAL);
            Exp exp = E0(); 
            return new TinyASint.Asig(new TinyASint.StringLocalizado(iden.lexema(), iden.fila(), iden.columna()), exp);
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IDEN);
            return null;
      }
   }
   private Exp E0(){
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
            Exp exp1 = E1();
            return E0_1(exp1);
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR, 
                                          ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, ClaseLexica.IGIG, ClaseLexica.NOIG,
                                          ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
            return null;
      }
   }
   private Exp E0_1(Exp exph){
      switch(anticipo.clase()){
         case MAS:
            String op1 = Op3();
            Exp exp1 = E0();
            return sem.exp(op1, exph, exp1);
         case MENOS:
            String op2 = Op3();
            Exp exp2 = E1();
            return sem.exp(op2, exph, exp2);
         case PUNTOCOMA:
         case EOF:
         case PCIERRE:
            return exph;
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAS, ClaseLexica.MENOS);
            return null;
      }
   }
   private Exp E1(){
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
            Exp exp1 = E2();
            return E1_1(exp1);
            default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR, 
            ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, ClaseLexica.IGIG, ClaseLexica.NOIG,
            ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, 
            ClaseLexica.PAP);
         return null;
      }
   }
   private Exp E1_1(Exp exph){
      switch(anticipo.clase()){
         case AND: 
         case OR: return sem.exp(Op0(), E2(), E1_1(exph));

         case MAS:
         case MENOS:
         case PUNTOCOMA:
         case PCIERRE:
         case EOF:
            return exph;
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR);
         return null;
      }
   }
   private Exp E2(){
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
            Exp exp1 = E3();
            return E2_1(exp1);
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, 
                                          ClaseLexica.IGIG, ClaseLexica.NOIG, ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.DIV, ClaseLexica.POR, ClaseLexica.REAL, 
                                          ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
            return null;
      }
   }
   private Exp E2_1(Exp exph){
      switch(anticipo.clase()){
         case MENOR: 
         case MENORI: 
         case MAYOR: 
         case MAYORI: 
         case IGIG: 
         case NOIG: return sem.exp(Op1(), E3(), E2_1(exph));

         case MAS:
         case MENOS:
         case AND:
         case OR:
         case PUNTOCOMA:
         case PCIERRE:
         case EOF:
            return exph;
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MENORI, ClaseLexica.MAYOR, ClaseLexica.MAYORI, 
                                          ClaseLexica.IGIG, ClaseLexica.NOIG);
            return null;
      }
   }
   private Exp E3(){
      switch(anticipo.clase()){
         case MENOS:
         case NOT:
         case POR:
         case REAL:
         case ENT:
         case IDEN:
         case BOOL:
         case PAP:
            Exp exp1 = E4();
            return E3_0(exp1);
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.POR, ClaseLexica.REAL, 
                                          ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, ClaseLexica.PAP);
            return null;
      }
   }
   private Exp E3_0(Exp exph){
      switch(anticipo.clase()){
         case DIV: 
         case POR: return sem.exp(Op2(), exph, E4());

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
            return exph;
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.DIV, ClaseLexica.POR);
            return null;
      }
   }
   private Exp E4(){
      switch(anticipo.clase()){
         case MENOS: empareja(ClaseLexica.MENOS); return new TinyASint.Neg(E5()); 
         case NOT: empareja(ClaseLexica.NOT); return new TinyASint.Not(E4()); 
         case PAP: 
         case ENT:
         case REAL:
         case BOOL:
         case IDEN:
            return E5();
         default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, ClaseLexica.NOT);
         return null;
      }
   }
   private Exp E5(){
      switch(anticipo.clase()){
         case REAL: 
            UnidadLexica tkReal = anticipo;
            empareja(ClaseLexica.REAL);
            TinyASint.StringLocalizado slr = new TinyASint.StringLocalizado(tkReal.lexema(), tkReal.fila(), tkReal.columna());
            return new TinyASint.Numreal(slr);
         case ENT: 
            UnidadLexica tkEnt = anticipo;
            empareja(ClaseLexica.ENT);
            TinyASint.StringLocalizado sle = new TinyASint.StringLocalizado(tkEnt.lexema(), tkEnt.fila(), tkEnt.columna());
            return new TinyASint.Numreal(sle);

         case IDEN: 
            UnidadLexica tkIden = anticipo;
            empareja(ClaseLexica.IDEN);
            TinyASint.StringLocalizado sli = new TinyASint.StringLocalizado(tkIden.lexema(), tkIden.fila(), tkIden.columna());
            return new TinyASint.Id(sli);

         case BOOL:
            UnidadLexica tkBool = anticipo;
            empareja(ClaseLexica.BOOL);
            if (tkBool.lexema() == "true") return new TinyASint.Verdadero();
            if (tkBool.lexema() == "false") return new TinyASint.Falso();
            return null;

         case PAP: 
            empareja(ClaseLexica.PAP); 
            Exp exp = E0(); 
            empareja(ClaseLexica.PCIERRE); 
            return exp;
         default: 
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.REAL, ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.BOOL, 
                                          ClaseLexica.PAP);
            return null;
         
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

   private String Op3() {
      switch(anticipo.clase()) {
          case MAS: empareja(ClaseLexica.MAS); return "+";  
          case MENOS: empareja(ClaseLexica.MENOS); return "-";  
          default:    
               errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.MAS,ClaseLexica.MENOS);
               return "?";
      }  
   }
   private String Op0() {
      switch(anticipo.clase()) {
          case AND: empareja(ClaseLexica.AND); return "and";  
          case OR: empareja(ClaseLexica.OR); return "or";  
          default:    
               errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.MAS,ClaseLexica.MENOS);
               return "?";
      }  
   }
   private String Op1() {
      switch(anticipo.clase()) {
          case MENOR: empareja(ClaseLexica.MENOR); return "<";  
          case MENORI: empareja(ClaseLexica.MENORI); return "<=";  
          case MAYOR: empareja(ClaseLexica.MAYOR); return ">";  
          case MAYORI: empareja(ClaseLexica.MAYORI); return ">=";  
          case IGIG: empareja(ClaseLexica.IGIG); return "==";  
          case NOIG: empareja(ClaseLexica.NOIG); return "!=";  
          default:    
               errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.MAS,ClaseLexica.MENOS);
               return "?";
      }  
   }
   private String Op2() {
      switch(anticipo.clase()) {
          case DIV: empareja(ClaseLexica.DIV); return "/";  
          case POR: empareja(ClaseLexica.POR); return "*";  
          default:    
               errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                       ClaseLexica.MAS,ClaseLexica.MENOS);
               return "?";
      }  
   }

}



// ---------------------------------------------------------------------------- PROFE ----------------------------------------------------------------------------
/*
  public Prog Init() {
      Prog prog = Prog();
      empareja(ClaseLexica.EOF);
      return prog;
   }
   
   private Prog Prog() {
     switch(anticipo.clase()) {
         case EVALUA:          
              empareja(ClaseLexica.EVALUA);
              Exp exp = E0();
              Decs decs = PDonde();
              return sem.prog(exp,decs);
         default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.EVALUA);     
              return null;
   }
   }
   
   private Decs PDonde() {
      switch(anticipo.clase()) {
          case DONDE:
              empareja(ClaseLexica.DONDE);
              return Decs();
          case EOF: return null;
          default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.DONDE,ClaseLexica.EOF);
                   return null;
      } 
   }
   
   private Decs Decs() {
      switch(anticipo.clase()) {
       case IDEN:    
           Dec dec = Dec();
           return RDecs(sem.decs_una(dec));
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                                      
                 return null;
   }
   }   
   
   private Decs RDecs(Decs decsh) {
      switch(anticipo.clase()) {
       case COMA:    
           empareja(ClaseLexica.COMA);
           Dec dec = Dec();
           return RDecs(sem.decs_muchas(decsh,dec));
       case EOF: return decsh;    
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.COMA, ClaseLexica.EOF);                                
                 return null;        
      }          
   }  
   
   private   Dec() {
     switch(anticipo.clase()) {       
       case IDEN:   
        UnidadLexica tkIden = anticipo;
        empareja(ClaseLexica.IDEN);
        empareja(ClaseLexica.IGUAL);
        UnidadLexica tkNum = anticipo;
        empareja(ClaseLexica.NUM);
        return sem.dec(sem.str(tkIden.lexema(),tkIden.fila(),tkIden.columna()),
                       sem.str(tkNum.lexema(),tkNum.fila(),tkNum.columna()));
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.IDEN);                 
                return null;
     }
   }
   

   private Exp E0() {
     switch(anticipo.clase()) {
         case IDEN: case NUM: case PAP:
             Exp exp1 = E1();
             return RE0(exp1);
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.NUM,
                                           ClaseLexica.PAP);
                   return null; 
     }  
   }
   private Exp RE0(Exp exph) {
      switch(anticipo.clase()) {
          case MAS: case MENOS: 
             char op = Op0();
             Exp exp1 = E1();
             return RE0(sem.exp(op, exph,exp1));
          case DONDE: case PCIERRE: case EOF: case COMA: return exph;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);
                      return null;
      } 
   }
   private Exp E1() {
     switch(anticipo.clase()) {
         case IDEN: case NUM: case PAP:
             Exp exp2 = E2();
             return RE1(exp2);
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.IDEN,ClaseLexica.NUM,
                                           ClaseLexica.PAP);                                   
             return null;
     }  
   }
   private Exp RE1(Exp exph) {
      switch(anticipo.clase()) {
          case POR: case DIV: 
             char op = Op1();
             Exp exp2 = E2();
             return RE1(sem.exp(op, exph, exp2));
          case DONDE: case PCIERRE: case EOF: case MAS: case MENOS: case COMA: return exph;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV,
                                      ClaseLexica.MAS, ClaseLexica.MENOS);                                 
              return null;
      } 
   }
   private Exp E2() {
      switch(anticipo.clase()) {
          case NUM: UnidadLexica tkNum = anticipo;
                    empareja(ClaseLexica.NUM); 
                    return sem.num(sem.str(tkNum.lexema(), tkNum.fila(), 
                                           tkNum.columna()));
          case IDEN: UnidadLexica tkIden = anticipo;
                     empareja(ClaseLexica.IDEN); 
                     return sem.id(sem.str(tkIden.lexema(), tkIden.fila(), 
                                           tkIden.columna()));
          case PAP: 
               empareja(ClaseLexica.PAP); 
               Exp exp = E0(); 
               empareja(ClaseLexica.PCIERRE); 
               return exp;
          default:     
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.NUM,
                                      ClaseLexica.PAP);
                      return null;
   }   
   }
   private char Op0() {
     switch(anticipo.clase()) {
         case MAS: empareja(ClaseLexica.MAS); return '+';  
         case MENOS: empareja(ClaseLexica.MENOS); return '-';  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);
              return '?';
     }  
   }
   private char Op1() {
     switch(anticipo.clase()) {
         case POR: empareja(ClaseLexica.POR); return '*';  
         case DIV: empareja(ClaseLexica.DIV); return '/';  
         default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.POR,ClaseLexica.DIV);
              return '?';
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
