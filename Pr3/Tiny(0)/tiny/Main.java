package tiny;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.TinyASint.Programa;
import c_ast_descendente_manual.ConstructorAST;

public class Main {
   public static void main(String[] args) throws Exception {
    Programa prog = ejecuta_descendente_manual(args[0]); 
    System.out.println(prog.toString());
  
    //System.out.println("OK");
 }

  private static Programa ejecuta_descendente_manual(String in) throws Exception {
    Reader input = new InputStreamReader(new FileInputStream(in));
    ConstructorAST constructorast = new ConstructorAST(input);
    return constructorast.Sp();
  }
}   
   
