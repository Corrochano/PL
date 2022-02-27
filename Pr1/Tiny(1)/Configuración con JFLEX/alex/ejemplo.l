package alex;

%%
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)

parteDecimal = (({digito}*{digitoPositivo})|0)
parteExponencial = [e|E]{ent}

identificador = {letra}({letra}|{digito}|_)*
ent = ([\+|\-]?({digitoPositivo}{digito}*)|0)
real = {ent}((\.{parteDecimal}|{parteExponencial})|(\.{parteDecimal}{parteExponencial}))
cadena = \"[^\"|\n|\b|\r]*\"
comentario = #[^\n]*

true = true
false = false

or = or
not = not
and = and

tCadena = string
tent = int
tbool = bool
treal = real
tPointer = pointer
tArray = array

null = null
proc = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
of = of
new = new
delete = delete
read = read
write = write
nl = nl
var = var
type = type

mas = \+
menos = \-
por = \*
div = \/

igual = \=
coma  = \,
mayor = \>
menor = \<
mayori = \>\=
menori = \<\=
igig = \=\=
noig = \!\=

pap = \(
pCierre = \)
cap = \[
cCierre = \]
lap = \{
lCierre = \}

puntocoma = \;
sepseccion = \&\&

modulo = \%
punto = \.
flecha = \-\>
ampersand = \&

separador = [ |\t|\r|\b|\n]

%%

{separador}                { } 
{comentario}               { }

{or}                       { return ops.unidadOr(); }
{not}                      { return ops.unidadNot(); }
{and}                      { return ops.unidadAnd(); }

{var}                      { return ops.unidadVar(); }
{type}                     { return ops.unidadType(); }
{proc}                     { return ops.unidadProc(); }
{if}                       { return ops.unidadIf(); }
{then}                     { return ops.unidadThen(); }
{else}                     { return ops.unidadElse(); }
{endif}                    { return ops.unidadEndif(); }
{while}                    { return ops.unidadWhile(); }
{do}                       { return ops.unidadDo(); }
{endwhile}                 { return ops.unidadEndwhile(); }
{call}                     { return ops.unidadCall(); }
{record}                   { return ops.unidadRecord(); }
{of}                       { return ops.unidadOf(); }
{new}                      { return ops.unidadNew(); } 
{delete}                   { return ops.unidadDelete(); } 
{read}                     { return ops.unidadRead(); }
{write}                    { return ops.unidadWrite(); }
{nl}                       { return ops.unidadNl(); }
{null}                     { return ops.unidadNull(); }

{tCadena}                  { return ops.unidadtCadena(); }
{tent}                     { return ops.unidadtEnt(); }
{tbool}                    { return ops.unidadtBool(); }
{treal}                    { return ops.unidadtReal(); }
{tPointer}                 { return ops.unidadtPointer(); }  
{tArray}                   { return ops.unidadtArray(); }
{true}                     { return ops.unidadBool(); }
{false}                    { return ops.unidadBool(); }

{real}                     { return ops.unidadReal(); }
{ent}                      { return ops.unidadEnt(); }
{cadena}                   { return ops.unidadCadena(); }

{identificador}            { return ops.unidadId(); }

{flecha}                   { return ops.unidadFlecha(); }
{sepseccion}               { return ops.unidadSepseccion(); }

{mas}                      { return ops.unidadSuma(); }
{menos}                    { return ops.unidadResta(); }
{por}                      { return ops.unidadMul(); }
{div}                      { return ops.unidadDiv(); }
{igual}                    { return ops.unidadIgual(); }
{coma}                     { return ops.unidadComa(); }
{mayor}                    { return ops.unidadMayor(); }
{menor}                    { return ops.unidadMenor(); }
{mayori}                   { return ops.unidadMayorI(); }
{menori}                   { return ops.unidadMenorI(); }
{igig}                     { return ops.unidadIgIg(); }
{noig}                     { return ops.unidadNoIg(); }
{pap}                      { return ops.unidadPAp(); }
{pCierre}                  { return ops.unidadPCierre(); }
{cap}                      { return ops.unidadCap(); }
{cCierre}                  { return ops.unidadCCierre(); }
{lap}                      { return ops.unidadLap(); }
{lCierre}                  { return ops.unidadLCierre(); }
{puntocoma}                { return ops.unidadPuntocoma(); }
{ampersand}                { return ops.unidadAmpersand(); }
{modulo}                   { return ops.unidadModulo(); }
{punto}                    { return ops.unidadPunto(); }

/*{letra}                    {  }
{digitoPositivo}           {  }
{digito}                   {  }

{parteDecimal}             {  } 
{parteExponencial}         {  }*/

[^]                       {ops.error();}  