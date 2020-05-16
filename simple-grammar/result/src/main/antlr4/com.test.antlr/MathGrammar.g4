/* The name of the grammar */
grammar MathGrammar;

/* The body of the grammar */

/* Non-terminals sections */
expression : number Operand number;

number : Digit+;

/* Terminals sections */
Digit : [0-9];

Operand: '+'|'-'|'*'|'/';