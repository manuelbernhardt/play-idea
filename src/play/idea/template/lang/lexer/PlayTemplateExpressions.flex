package play.idea.template.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import play.idea.template.lang.parser.PlayTemplateElementTypes;
%%

%class _PlayTemplateExpressionLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE_CHAR=[\ \n\r\t\f]
IDENTIFIER=[:jletter:] [:jletterdigit:]*

L_CUBR="{"
R_CUBR="}"
L_PAREN="("
R_PAREN=")"
AT="@"
HASH="#"
STAR="*"
DOT="."
COMMA=","
COLON=":"
AND="&"

// *{ comment }*
COMMENT = "*{" [^*] ~"}*" | "{*" "*"+ "{"



%state IN_ACTION_LINK
%state IN_COMMENT

%%
<YYINITIAL> {
  {COMMENT}                     { return PlayTemplateTokenTypes.COMMENT; }
  {AT} {L_CUBR}                 { yybegin(IN_ACTION_LINK); return PlayTemplateElementTypes.ACTION_LINK; }
}

<IN_COMMENT>
  {COMMENT}                     {return PlayTemplateTokenTypes.COMMENT;}

<IN_ACTION_LINK> {
  {IDENTIFIER}                  { return PlayTemplateTokenTypes.IDENTIFIER; }
  {DOT}                         { return PlayTemplateTokenTypes.DOT; }
  {L_PAREN}                     { return PlayTemplateTokenTypes.LPAREN; }
  {R_PAREN}                     { return PlayTemplateTokenTypes.RPAREN; }
  {COMMA}                       { return PlayTemplateTokenTypes.COMMA; }
  {R_CUBR}                      { return PlayTemplateTokenTypes.RBRACE; }
  {WHITE_SPACE_CHAR}+           { }

}


/*
  {L_PAREN}                     { return PlayTemplateTokenTypes.LPAREN; }
  {R_PAREN}                     { return PlayTemplateTokenTypes.RPAREN; }
  {L_CUBR}                      { return PlayTemplateTokenTypes.LBRACE; }
  {R_CUBR}                      { return PlayTemplateTokenTypes.RBRACE; }
  {AT}                          { return PlayTemplateTokenTypes.AT; }
  {HASH}                        { return PlayTemplateTokenTypes.HASH; }
  {STAR}                        { return PlayTemplateTokenTypes.STAR; }
  {DOT}                         { return PlayTemplateTokenTypes.DOT; }
  {COMMA}                       { return PlayTemplateTokenTypes.COMMA; }
  {COLON}                       { return PlayTemplateTokenTypes.COLON; }
  {AMP}                         { return PlayTemplateTokenTypes.AMP;}
  {DOLLAR}                      { return PlayTemplateTokenTypes.DOLLAR;}
  {IDENTIFIER}                  { return PlayTemplateTokenTypes.IDENTIFIER; }

*/

