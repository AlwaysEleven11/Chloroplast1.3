grammar Syntax;
chunk:
     func* EOF
     ;
func:name'{'stmt'}';
stmt:var;

var: 'var' ID '=' expr;
name:ID;
expr : expr NUL expr    # Mul
     | expr ADD expr    # Add
     | expr DIV expr    # Div
     | expr MIN expr    # Min
     | INT              # Int
     ;
NUL : '*';
ADD : '+';
DIV : '/';
MIN : '-';
INT : Digit+;
Digit : [0-9];
WS : [ \t\u000C\r\n]+ -> skip;
SHEBANG : '#' '!' ~('\n'|'\r')* -> channel(HIDDEN);
ID:[a-zA-z]*;