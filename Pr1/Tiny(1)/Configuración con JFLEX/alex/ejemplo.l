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
signo = \+|\-

parteDecimal = ({digito}* {digitoPositivo}|0)
parteExponencial = (e|E)numeroEntero

separador = [ \t\r\b\n]
comentario = #[^\n]* 

identificador = {letra}({letra}|{digito})*
real = ent\.{parteDecimal} {parteExponencial}
ent = ([signo]?(digitoPositivo {digito}*)|0)
cadena = \" [^\"\n\b\r]* \"
bool = (true|false)

mas = \+
menos = \-
por = \*+
div = \/

igual = \=
coma  = \,
mayor = \>
menor = \<
mayori = \>\=
menori = \<\=
igig = \=\=
noig = \!\=
or = or
not = not
and = and

pap = \(
pCierre = \)
cap = \[
cCierre = \]
lap = \{
lCierre = \}

tCadena = string
tent = int
tbool = bool
treal = real
tPointer = pointer
tArray = array

puntocoma = \;
sepseccion = &&

modulo = \%
punto = \.
flecha = \->
ampersand = &

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
record = trecord
of = of
new = new
delete = delete
read = read
write = write
nl = nl
var = var
type = type




%%

{separador} =                { } 
{comentario} =               { }

{letra}  =                   { }
{digitoPositivo} =           { }
{digito} =                   { }
{signo} =                    { }
{parteDecimal} =             { }
{parteExponencial} =         { }

{identificador} =            { return ops.unidadId(); }
{real} =                     { return ops.unidadReal(); }
{ent} =                      { return ops.unidadEnt(); }
{cadena} =                   { return ops.unidadCadena(); }
{bool} =                     { return ops.unidadBool(); }
{mas} =                      { return ops.unidadSuma(); }
{menos} =                    { return ops.unidadResta(); }
{por} =                      { return ops.unidadMul(); }
{div} =                      { return ops.unidadDiv(); }
{igual} =                    { return ops.unidadIgual(); }
{coma}  =                    { return ops.unidadComa(); }
{mayor} =                    { return ops.unidadMayor(); }
{menor} =                    { return ops.unidadMenor(); }
{mayori} =                   { return ops.unidadMayorI(); }
{menori} =                   { return ops.unidadMenorI(); }
{igig} =                     { return ops.unidadIgIg(); }
{noig} =                     { return ops.unidadNoIg(); }
{or} =                       { return ops.unidadOr(); }
{not} =                      { return ops.unidadNot(); }
{and} =                      { return ops.unidadAnd(); }
{pap} =                      { return ops.unidadPAp(); }
{pCierre} =                  { return ops.unidadPCierre(); }
{cap} =                      { return ops.unidadCap(); }
{cCierre} =                  { return ops.unidadCCierre(); }
{lap} =                      { return ops.unidadLap(); }
{lCierre} =                  { return ops.unidadLCierre(); }
{tCadena} =                  { return ops.unidadtCadena(); }
{tent} =                     { return ops.unidadtEnt(); }
{tbool} =                    { return ops.unidadtBool(); }
{treal} =                    { return ops.unidadtReal(); }
{tPointer} =                 { return ops.unidadtPointer(); }  
{tArray} =                   { return ops.unidadtArray(); }
{puntocoma} =                { return ops.unidadPuntocoma(); }
{sepseccion} =               { return ops.unidadSepseccion(); }
{modulo} =                   { return ops.unidadModulo(); }
{punto} =                    { return ops.unidadPunto(); }
{flecha} =                   { return ops.unidadFlecha(); }
{ampersand} =                { return ops.unidadAmpersand(); } 
{null} =                     { return ops.unidadNull(); }
{proc} =                     { return ops.unidadProc(); }
{if} =                       { return ops.unidadIf(); }
{then} =                     { return ops.unidadThen(); }
{else} =                     { return ops.unidadElse(); }
{endif} =                    { return ops.unidadEndif(); }
{while} =                    { return ops.unidadWhile(); }
{do} =                       { return ops.unidadDo(); }
{endwhile} =                 { return ops.unidadEndwhile(); }
{call} =                     { return ops.unidadCall(); }
{record} =                   { return ops.unidadRecord(); }
{of} =                       { return ops.unidadOf(); }
{new} =                      { return ops.unidadNew(); } 
{delete} =                   { return ops.unidadDelete(); } 
{read} =                     { return ops.unidadRead(); }
{write} =                    { return ops.unidadWrite(); }
{nl} =                       { return ops.unidadNl(); }
{var} =                      { return ops.unidadVar(); }
{type} =                     { return ops.unidadType(); }

[^]                       {ops.error();}  