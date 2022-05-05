package asint;


public class TinyASint {
    public enum TNodo {SUMA,RESTA,MUL,DIV,NEG,AND,OR,NOT,MEN,MENIG,MAY,MAYIG,EQUIV,NOEQUIV,NUMREAL,NUMENTERO,VERDADERO,FALSO,
        DECLARACIONES_MUCHAS,DECLARACIONES_UNA,DECLARACION_UNA,PROGRAMA, REAL, BOOL, ENTERO, ASIGNACIONES_MUCHAS,ASIGNACIONES_UNA, ASIGNACION_UNA, ID} ;


        public static abstract class Nodo {
            @Override
            public abstract String toString();
            public abstract TNodo tipo();
        }
        
        public static abstract class Exp extends Nodo {
            public Exp() {}   
            public abstract TNodo tipo();
            public Exp arg0() {throw new UnsupportedOperationException("arg0");}
            public Exp arg1() {throw new UnsupportedOperationException("arg1");}
            public StringLocalizado id() {throw new UnsupportedOperationException("id");}
            public StringLocalizado num() {throw new UnsupportedOperationException("num");}
        }

        private static abstract class ExpUna extends Exp {
        protected Exp arg0;
        public ExpUna(Exp arg0) {
            super();
            this.arg0 = arg0;
        }
        public Exp arg0() {return arg0;}
        }

        private static abstract class ExpBin extends Exp {
        protected Exp arg0;
        protected Exp arg1;
        public ExpBin(Exp arg0, Exp arg1) {
            super();
            this.arg0 = arg0;
            this.arg1 = arg1;
        }
        public Exp arg0() {return arg0;}
        public Exp arg1() {return arg1;}
        }

        public static class Suma extends ExpBin {

            public Suma(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.SUMA;
            }

            @Override
            public String toString() {
                return "Suma: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Resta extends ExpBin {

            public Resta(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.RESTA;
            }

            @Override
            public String toString() {
                return "Resta: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Mul extends ExpBin {

            public Mul(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.MUL;
            }

            @Override
            public String toString() {
                return "Mul: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Div extends ExpBin {

            public Div(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.DIV;
            }

            @Override
            public String toString() {
                return "Div: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class And extends ExpBin {

            public And(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.AND;
            }

            @Override
            public String toString() {
                return "And: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Or extends ExpBin {

            public Or(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.OR;
            }

            @Override
            public String toString() {
                return "Or: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Men extends ExpBin {

            public Men(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.MEN;
            }

            @Override
            public String toString() {
                return "Men: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Menig extends ExpBin {

            public Menig(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.MENIG;
            }

            @Override
            public String toString() {
                return "Menig: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class May extends ExpBin {

            public May(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.MAY;
            }

            @Override
            public String toString() {
                return "May: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Mayig extends ExpBin {

            public Mayig(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.MAYIG;
            }

            @Override
            public String toString() {
                return "Mayig: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Equiv extends ExpBin {

            public Equiv(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.EQUIV;
            }

            @Override
            public String toString() {
                return "Equiv: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        }  
        public static class Noequiv extends ExpBin {

            public Noequiv(Exp arg0, Exp arg1) {
                super(arg0, arg1);
            }

            @Override
            public TNodo tipo() {
                return TNodo.NOEQUIV;
            }

            @Override
            public String toString() {
                return "Noequiv: {"+ arg0.toString() + ", " + arg1.toString() + "}";
            }

        } 
        public static class Not extends ExpUna {

            public Not(Exp arg0) {
                super(arg0);            
            }

            @Override
            public TNodo tipo() {
                return TNodo.NOT;
            }

            @Override
            public String toString() {
                return "Not: {" + arg0.toString() + "}";
            }

        } 
        public static class Neg extends ExpUna {

            public Neg(Exp arg0) {
                super(arg0);            
            }

            @Override
            public TNodo tipo() {
                return TNodo.NEG;
            }

            @Override
            public String toString() {
                return "Neg: {" + arg0.toString() + "}";
            }
        }
        public static class Numreal extends Exp {

            StringLocalizado val;
            public Numreal(StringLocalizado val) {
                super();
                this.val = val;
            }

            @Override
            public TNodo tipo() {
                return TNodo.NUMREAL;
            }

            @Override
            public String toString() {
                return "NumReal: {" + val.s + "}";
            }

        } 
        public static class Numentero extends Exp {
            StringLocalizado val;
            public Numentero(StringLocalizado val) {
                super();
                this.val = val;
            }

            @Override
            public TNodo tipo() {
                return TNodo.NUMENTERO;
            }

            @Override
            public String toString() {
                return "NumEntero: {" + val.s + "}";
            }

        } 
        public static class Verdadero extends Exp {

            public Verdadero() {
                super();
            }

            @Override
            public TNodo tipo() {
                return TNodo.VERDADERO;
            }

            @Override
            public String toString() {
                return "Verdadero";
            }

        } 
        public static class Falso extends Exp {

            public Falso() {
                super();
            }

            @Override
            public TNodo tipo() {
                return TNodo.FALSO;
            }

            @Override
            public String toString() {
                return "Falso";
            }

        } 

        public static class Dec extends Nodo{
            private Tipo tipo;
            private StringLocalizado id;
            public Dec(Tipo tipo, StringLocalizado id) {
                super();
                this.id = id;
                this.tipo = tipo;
            }
            public StringLocalizado id() {return id;}
            @Override
            public String toString() {
                return "Declaracion_una{" + tipo.toString() + ", " + id + "}";
            }
            @Override
            public TNodo tipo() {
                return TNodo.DECLARACION_UNA;
            }
        }
        public static abstract class Decs extends Nodo{
            public Decs() {}   
            public abstract Dec dec();
        }
        public static class Declaraciones_muchas extends Decs{
            private Dec dec;
            private Decs decs;
            public Declaraciones_muchas(Decs decs, Dec dec) {
                super();
                this.dec = dec;
                this.decs = decs;
            }
            public TNodo tipo() {return TNodo.DECLARACIONES_MUCHAS;}; 
            public Dec dec() {
                return dec;
            }
            public Decs decs() {
                return decs;
            }
            @Override
            public String toString() {
                return "Declaraciones_muchas{" + dec.toString() +", "+ decs.toString() + "}";
            }
        } 
        public static class Declaracion_una extends Decs{
            private Dec dec; 
            public Declaracion_una(Dec dec) {
                super();
                this.dec = dec;
            }   
            public TNodo tipo() {return TNodo.DECLARACIONES_UNA;}; 
            public Dec dec() {
                return dec;
            }
            @Override
            public String toString() {
                return "Declaraciones_una{" + dec.toString() + "}";
            }
        } 
        public static class Programa extends Nodo {
            private Decs decs;
            private Asigs asigs;
            public Programa(Decs decs, Asigs asigs) {
                super();
                this.decs = decs;
                this.asigs = asigs;
            }   
            public TNodo tipo() {return TNodo.PROGRAMA;}; 
            public Decs decs() {return decs;}
            public Asigs asigs() {return asigs;}
			public String toString() {
				return "Programa{ " + decs.toString() + ", " + asigs.toString() + "}";
			}
        }
        
        public static abstract class Tipo extends Nodo{
            private StringLocalizado id;

            protected Tipo (StringLocalizado id){
                this.id = id;
            }
        }

        public static class Real extends Tipo {

            public Real(StringLocalizado id) {
                super(id);
            }

            @Override
            public String toString() {
                return "Real";
            }

            @Override
            public TNodo tipo() {
                return TNodo.REAL;
            }

        } 
        public static class Bool extends Tipo {

            public Bool(StringLocalizado id) {
                super(id);
            }

            @Override
            public String toString() {
                return "Bool";
            }

            @Override
            public TNodo tipo() {
                return TNodo.BOOL;
            }

        } 
        public static class Entero extends Tipo {

            public Entero(StringLocalizado id) {
                super(id);
            }

            @Override
            public String toString() {
                return "Entero";
            }

            @Override
            public TNodo tipo() {
                return TNodo.ENTERO;
            }

        } 

        public static class Id extends Exp{

            private StringLocalizado id;
            public Id(StringLocalizado id) {
                super();
                this.id = id;
            }

            @Override
            public TNodo tipo() {
                return TNodo.ID;
            }

            @Override
            public String toString() {
                return id.toString();
            }
            
        }

        public static abstract class Asigs{
            public Asigs() {
            }   
            public abstract Asig asig();
        }

        public static class Asig extends Nodo{
            private StringLocalizado id;
            private Exp exp;
            public Asig(StringLocalizado id, Exp exp) {
                super();
                this.id = id;
                this.exp = exp;
            }
            public StringLocalizado id() {return id;}
            @Override
            public String toString() {
                return "Asignacion_una{" + id + ", " + exp.toString() + "}";
            }
            @Override
            public TNodo tipo() {
                return TNodo.ASIGNACION_UNA;
            }
        }
        public static class Asignacion_muchas extends Asigs{
            private Asig asig;
            private Asigs asigs;
            public Asignacion_muchas(Asigs asigs, Asig asig) {
                super();
                this.asig = asig;
                this.asigs = asigs;
            }
            public TNodo tipo() {return TNodo.ASIGNACIONES_MUCHAS;}; 
            public Asig asig() {
                return asig;
            }
            public Asigs asigs() {
                return asigs;
            }
            @Override
            public String toString() {
                return "Asignaciones_muchas{" + asig.toString() +", "+ asigs.toString() + "}";
            }
        } 
        public static class Asignacion_una extends Asigs{
            private Asig asig;
            public Asignacion_una(Asig asig) {
                super();
                this.asig = asig;
            }
            public TNodo tipo() {return TNodo.ASIGNACIONES_UNA;}; 
            public Asig asig() {
                return asig;
            }

            @Override
            public String toString() {
                return "Asignacion_una{" + asig.toString() + "}";
            }
        } 

        public static class StringLocalizado {
            private String s;
            private int fila;
            private int col;
            public StringLocalizado(String s, int fila, int col) {
                this.s = s;
                this.fila = fila;
                this.col = col;
            }
            public int fila() {return fila;}
            public int col() {return col;}
            public String toString() {
            return s;
            }
            public boolean equals(Object o) {
                return (o == this) || (
                        (o instanceof StringLocalizado) &&
                        (((StringLocalizado)o).s.equals(s)));                
            }
            public int hashCode() {
                return s.hashCode();
            }
        }
}
        








// ---------------------------------------------------------------------------- PROFE ----------------------------------------------------------------------------
/*
    public static class StringLocalizado {
     private String s;
     private int fila;
     private int col;
     public StringLocalizado(String s, int fila, int col) {
         this.s = s;
         this.fila = fila;
         this.col = col;
     }
     public int fila() {return fila;}
     public int col() {return col;}
     public String toString() {
       return s;
     }
     public boolean equals(Object o) {
         return (o == this) || (
                (o instanceof StringLocalizado) &&
                (((StringLocalizado)o).s.equals(s)));                
     }
     public int hashCode() {
         return s.hashCode();
     }
  }

    
    public static class Dec  {
        private StringLocalizado id;
        private StringLocalizado val;
        public Dec(StringLocalizado id, StringLocalizado val) {
            this.id = id;
            this.val = val;
        }
        public TNodo tipo() {return TNodo.DEC;}
        public StringLocalizado id() {return id;}
        public StringLocalizado val() {return val;}
    }
    public static abstract class Decs {
       public Decs() {
       }   
       public abstract TNodo tipo(); 
       public Decs decs() {throw new UnsupportedOperationException("decs");}
       public Dec dec() {throw new UnsupportedOperationException("dec");}
    }
    public static class Decs_una extends Decs {
       private Dec dec; 
       public Decs_una(Dec dec) {
          super();
          this.dec = dec;
       }   
       public TNodo tipo() {return TNodo.DECS_UNA;}; 
       public Dec dec() {
           return dec;
       }
    }
    public static class Decs_muchas extends Decs {
       private Dec dec;
       private Decs decs;
       public Decs_muchas(Decs decs, Dec dec) {
          super();
          this.dec = dec;
          this.decs = decs;
       }
       public TNodo tipo() {return TNodo.DECS_MUCHAS;}; 
       public Dec dec() {
           return dec;
       }
       public Decs decs() {
           return decs;
       }
    }
    public static abstract class Prog  {
       public Prog() {
       }   
       public abstract TNodo tipo();  
       public  Exp exp() {throw new UnsupportedOperationException("exp");};
       public Decs decs() {throw new UnsupportedOperationException("decs");};;
    }
    public static class Prog_sin_decs extends Prog {
      private Exp exp;
       public Prog_sin_decs(Exp exp) {
          super();
          this.exp = exp;
       }   
       public TNodo tipo() {return TNodo.PROG_SIN_DECS;}; 
       public Exp exp() {return exp;}
    }
    public static class Prog_con_decs extends Prog {
      private Exp exp;
      private Decs decs;
       public Prog_con_decs(Exp exp, Decs decs) {
          super();
          this.exp = exp;
          this.decs = decs;
       }   
       public TNodo tipo() {return TNodo.PROG_CON_DECS;}; 
       public Exp exp() {return exp;}
       public Decs decs() {return decs;}
    }

     // Constructoras    
    public Prog prog_con_decs(Exp exp, Decs decs) {
        return new Prog_con_decs(exp,decs);
    }
    public Prog prog_sin_decs(Exp exp) {
        return new Prog_sin_decs(exp);
    }
    public Exp suma(Exp arg0, Exp arg1) {
        return new Suma(arg0,arg1);
    }
    public Exp resta(Exp arg0, Exp arg1) {
        return new Resta(arg0,arg1);
    }
    public Exp mul(Exp arg0, Exp arg1) {
        return new Mul(arg0,arg1);
    }
    public Exp div(Exp arg0, Exp arg1) {
        return new Div(arg0,arg1);
    }
    public Exp num(StringLocalizado num) {
        return new Num(num);
    }
    public Exp id(StringLocalizado num) {
        return new Id(num);
    }
    public Dec dec(StringLocalizado id, StringLocalizado val) {
        return new Dec(id,val);
    }
    public Decs decs_una(Dec dec) {
        return new Decs_una(dec);
    }
    public Decs decs_muchas(Decs decs, Dec dec) {
        return new Decs_muchas(decs,dec);
    }
    public StringLocalizado str(String s, int fila, int col) {
        return new StringLocalizado(s,fila,col);
    }
}
*/