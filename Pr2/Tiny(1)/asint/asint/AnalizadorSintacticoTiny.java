/* AnalizadorSintacticoTiny.java */
/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package asint;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {

  final public void Sp() throws ParseException {
    S();
    jj_consume_token(0);
}

  final public void S() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case var:
    case type:
    case proc:{
      D0();
      jj_consume_token(42);
      I0();
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void D0() throws ParseException {
    D1();
    D0_1();
}

  final public void D0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 43:{
      jj_consume_token(43);
      D1();
      D0_1();
      break;
      }
    default:
      jj_la1[1] = jj_gen;

    }
}

  final public void D1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case var:{
      DV0();
      break;
      }
    case type:{
      DT0();
      break;
      }
    case proc:{
      DP0();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void DV0() throws ParseException {
    jj_consume_token(var);
    T0();
    jj_consume_token(ident);
}

  final public void DT0() throws ParseException {
    jj_consume_token(type);
    T0();
    jj_consume_token(ident);
}

  final public void DP0() throws ParseException {
    jj_consume_token(proc);
    jj_consume_token(ident);
    jj_consume_token(44);
    PFS0();
    jj_consume_token(45);
    B0();
}

  final public void PFS0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ent:
    case real:
    case bool:
    case string:
    case array:
    case record:
    case pointer:
    case ident:{
      PF1();
      PFS0_1();
      break;
      }
    default:
      jj_la1[3] = jj_gen;

    }
}

  final public void PFS0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 46:{
      jj_consume_token(46);
      PF1();
      PFS0_1();
      break;
      }
    default:
      jj_la1[4] = jj_gen;

    }
}

  final public void PF1() throws ParseException {
    T0();
    FT0();
}

  final public void FT0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ident:{
      jj_consume_token(ident);
      break;
      }
    case 47:{
      jj_consume_token(47);
      jj_consume_token(ident);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void B0() throws ParseException {
    jj_consume_token(48);
    Flap();
}

  final public void Flap() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case cadena:
    case numEnt:
    case numReal:
    case var:
    case type:
    case proc:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      S();
      jj_consume_token(49);
      break;
      }
    case 49:{
      jj_consume_token(49);
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void T0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ent:
    case real:
    case bool:
    case string:{
      TB0();
      break;
      }
    case ident:{
      jj_consume_token(ident);
      break;
      }
    case array:{
      TA0();
      break;
      }
    case record:{
      TR0();
      break;
      }
    case pointer:{
      TP0();
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void TB0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ent:{
      jj_consume_token(ent);
      break;
      }
    case real:{
      jj_consume_token(real);
      break;
      }
    case bool:{
      jj_consume_token(bool);
      break;
      }
    case string:{
      jj_consume_token(string);
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void TA0() throws ParseException {
    jj_consume_token(array);
    jj_consume_token(50);
    jj_consume_token(numEnt);
    jj_consume_token(51);
    jj_consume_token(of);
    T0();
}

  final public void TR0() throws ParseException {
    jj_consume_token(record);
    jj_consume_token(48);
    C0();
    jj_consume_token(49);
}

  final public void C0() throws ParseException {
    C1();
    C0_1();
}

  final public void C0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 43:{
      jj_consume_token(43);
      C1();
      C0_1();
      break;
      }
    default:
      jj_la1[9] = jj_gen;

    }
}

  final public void C1() throws ParseException {
    T0();
    jj_consume_token(ident);
}

  final public void TP0() throws ParseException {
    jj_consume_token(pointer);
    T0();
}

  final public void I0() throws ParseException {
    I1();
    I0_1();
}

  final public void I0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 43:{
      jj_consume_token(43);
      I1();
      I0_1();
      break;
      }
    default:
      jj_la1[10] = jj_gen;

    }
}

  final public void I1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case cadena:
    case numEnt:
    case numReal:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 55:{
      IA0();
      break;
      }
    case iif:{
      jj_consume_token(iif);
      Fif_2();
      break;
      }
    case wwhile:{
      IW0();
      break;
      }
    case read:{
      IL0();
      break;
      }
    case write:{
      IE0();
      break;
      }
    case nl:{
      INL0();
      break;
      }
    case nnew:{
      IRM0();
      break;
      }
    case delete:{
      ILM0();
      break;
      }
    case call:{
      IIP0();
      break;
      }
    case 48:{
      IC0();
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Fif_2() throws ParseException {
    E0();
    FE0_3();
}

  final public void FE0_3() throws ParseException {
    jj_consume_token(then);
    Fthen_2();
}

  final public void Fthen_2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endif:{
      jj_consume_token(endif);
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      FI0_1();
      break;
      }
    case eelse:{
      jj_consume_token(eelse);
      Felse();
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void FI0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endif:{
      jj_consume_token(endif);
      break;
      }
    case eelse:{
      FI0();
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void IA0() throws ParseException {
    E0();
    jj_consume_token(52);
    E0();
}

  final public void IIT0() throws ParseException {
    jj_consume_token(iif);
    Fif();
}

  final public void Fif() throws ParseException {
    E0();
    FE0();
}

  final public void FE0() throws ParseException {
    jj_consume_token(then);
    Fthen();
}

  final public void Fthen() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endif:{
      jj_consume_token(endif);
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      jj_consume_token(endif);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void IITE0() throws ParseException {
    jj_consume_token(iif);
    Fif_1();
}

  final public void Fif_1() throws ParseException {
    E0();
    FE0_1();
}

  final public void FE0_1() throws ParseException {
    jj_consume_token(then);
    Fthen_1();
}

  final public void Fthen_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case eelse:{
      jj_consume_token(eelse);
      Felse();
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      FI0();
      break;
      }
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void Felse() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endif:{
      jj_consume_token(endif);
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      jj_consume_token(endif);
      break;
      }
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void FI0() throws ParseException {
    jj_consume_token(eelse);
    Felse_1();
}

  final public void Felse_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endif:{
      jj_consume_token(endif);
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      jj_consume_token(endif);
      break;
      }
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void IW0() throws ParseException {
    jj_consume_token(wwhile);
    Fwhile();
}

  final public void Fwhile() throws ParseException {
    E0();
    FE0_2();
}

  final public void FE0_2() throws ParseException {
    jj_consume_token(ddo);
    Fdo();
}

  final public void Fdo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case endwhile:{
      jj_consume_token(endwhile);
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case iif:
    case wwhile:
    case read:
    case write:
    case nl:
    case nnew:
    case delete:
    case call:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 48:
    case 55:{
      I0();
      jj_consume_token(endwhile);
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void IL0() throws ParseException {
    jj_consume_token(read);
    E0();
}

  final public void IE0() throws ParseException {
    jj_consume_token(write);
    E0();
}

  final public void INL0() throws ParseException {
    jj_consume_token(nl);
}

  final public void IRM0() throws ParseException {
    jj_consume_token(nnew);
    E0();
}

  final public void ILM0() throws ParseException {
    jj_consume_token(delete);
    E0();
}

  final public void IIP0() throws ParseException {
    jj_consume_token(call);
    Fcall();
}

  final public void Fcall() throws ParseException {
    jj_consume_token(ident);
    Fident();
}

  final public void Fident() throws ParseException {
    jj_consume_token(44);
    Fpap();
}

  final public void Fpap() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case cadena:
    case numEnt:
    case numReal:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 55:{
      PR0();
      jj_consume_token(45);
      break;
      }
    case 45:{
      jj_consume_token(45);
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void PR0() throws ParseException {
    PR1();
    PR0_1();
}

  final public void PR0_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 46:{
      jj_consume_token(46);
      PR1();
      PR0_1();
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case not:
    case ttrue:
    case ffalse:
    case ident:
    case 44:
    case 55:{
      PR1();
      jj_consume_token(53);
      E0();
      break;
      }
    default:
      jj_la1[20] = jj_gen;

    }
}

  final public void PR1() throws ParseException {
    E0();
}

  final public void IC0() throws ParseException {
    B0();
}

  final public void E0() throws ParseException {
    E1();
    FE1();
}

  final public void FE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 54:{
      jj_consume_token(54);
      E0();
      break;
      }
    case 55:{
      jj_consume_token(55);
      E1();
      break;
      }
    default:
      jj_la1[21] = jj_gen;

    }
}

  final public void E1() throws ParseException {
    E2();
    E1_1();
}

  final public void E1_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:{
      jj_consume_token(and);
      E2();
      E1_1();
      break;
      }
    case or:{
      jj_consume_token(or);
      E2();
      E1_1();
      break;
      }
    default:
      jj_la1[22] = jj_gen;

    }
}

  final public void E2() throws ParseException {
    E3();
    E2_1();
}

  final public void E2_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 56:{
      jj_consume_token(56);
      E3();
      E2_1();
      break;
      }
    case 57:{
      jj_consume_token(57);
      E3();
      E2_1();
      break;
      }
    case 58:{
      jj_consume_token(58);
      E3();
      E2_1();
      break;
      }
    case 59:{
      jj_consume_token(59);
      E3();
      E2_1();
      break;
      }
    case 60:{
      jj_consume_token(60);
      E3();
      E2_1();
      break;
      }
    case 61:{
      jj_consume_token(61);
      E3();
      E2_1();
      break;
      }
    default:
      jj_la1[23] = jj_gen;

    }
}

  final public void E3() throws ParseException {
    E4();
    FE4();
}

  final public void FE4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 62:{
      jj_consume_token(62);
      E4();
      break;
      }
    case 63:{
      jj_consume_token(63);
      E4();
      break;
      }
    case 64:{
      jj_consume_token(64);
      E4();
      break;
      }
    default:
      jj_la1[24] = jj_gen;

    }
}

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 55:{
      jj_consume_token(55);
      E5();
      break;
      }
    case not:{
      jj_consume_token(not);
      E4();
      break;
      }
    case cadena:
    case numEnt:
    case numReal:
    case ttrue:
    case ffalse:
    case ident:
    case 44:{
      E5();
      break;
      }
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void E5() throws ParseException {
    E6();
    E5_1();
}

  final public void E5_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 50:{
      jj_consume_token(50);
      E0();
      jj_consume_token(51);
      E5_1();
      break;
      }
    case 65:{
      jj_consume_token(65);
      jj_consume_token(ident);
      E5_1();
      break;
      }
    case 53:{
      jj_consume_token(53);
      jj_consume_token(ident);
      E5_1();
      break;
      }
    default:
      jj_la1[26] = jj_gen;

    }
}

  final public void E6() throws ParseException {
    E7();
    E6_1();
}

  final public void E6_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 63:{
      jj_consume_token(63);
      E6_1();
      break;
      }
    default:
      jj_la1[27] = jj_gen;

    }
}

  final public void E7() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case numReal:{
      jj_consume_token(numReal);
      break;
      }
    case numEnt:{
      jj_consume_token(numEnt);
      break;
      }
    case cadena:{
      jj_consume_token(cadena);
      break;
      }
    case ident:{
      jj_consume_token(ident);
      break;
      }
    case ttrue:{
      jj_consume_token(ttrue);
      break;
      }
    case ffalse:{
      jj_consume_token(ffalse);
      break;
      }
    case 44:{
      jj_consume_token(44);
      E0();
      jj_consume_token(45);
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  /** Generated Token Manager. */
  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[29];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	   jj_la1_init_2();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0xc8807e00,0x0,0x7000,0x6f8000,0x0,0x0,0xc8807e00,0x6f8000,0x78000,0x0,0x0,0xc8800e00,0xcd800e00,0x5000000,0xcc800e00,0xc9800e00,0xcc800e00,0xcc800e00,0xe8800e00,0xe00,0xe00,0x0,0x0,0x0,0x0,0xe00,0x0,0x0,0xe00,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x8113cf,0x800,0x0,0x200,0x4000,0x8200,0x8313cf,0x200,0x0,0x800,0x800,0x8113cf,0x8113cf,0x0,0x8113cf,0x8113cf,0x8113cf,0x8113cf,0x8113cf,0x8033c0,0x8053c0,0xc00000,0x30,0x3f000000,0xc0000000,0x8013c0,0x240000,0x80000000,0x1380,};
	}
	private static void jj_la1_init_2() {
	   jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x2,0x0,0x0,};
	}

  /** Constructor with InputStream. */
  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalizadorSintacticoTiny(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalizadorSintacticoTiny(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[66];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 29; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		   if ((jj_la1_2[i] & (1<<j)) != 0) {
			 la1tokens[64+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 66; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

                                       }
