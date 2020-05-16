grammar MathGrammar;

//expression : number (Operand number)+;

expression : number Operand number;

number : Digit+;

Digit : [0-9];

Operand: '+'|'-'|'*'|'/';