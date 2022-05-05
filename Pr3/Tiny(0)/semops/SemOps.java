package semops;

import asint.TinyASint;

public class SemOps extends TinyASint {
   public Exp exp(String op, Exp arg0, Exp arg1) {
       switch(op) {
           case "+": return new Suma(arg0,arg1);
           case "-": return new Resta(arg0,arg1);
           case "*": return new Mul(arg0,arg1);
           case "/": return new Div(arg0,arg1);
           case "and": return new And(arg0, arg1);
           case "or": return new Or(arg0, arg1);
           case "<": return new Men(arg0, arg1);
           case "<=": return new Menig(arg0, arg1);
           case ">": return new May(arg0, arg1);
           case ">=": return new Mayig(arg0, arg1);
           case "==": return new Equiv(arg0, arg1);
           case "!=": return new Noequiv(arg0, arg1);
       }
       throw new UnsupportedOperationException("exp "+op);
   }  
   public Programa prog(Decs decs, Asigs asigs) {
       return prog(decs, asigs);
   }     
}
