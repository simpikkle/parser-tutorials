/* The name of the grammar */
grammar MathGrammar;

/* The body of the grammar */

/* Non-terminals sections */
expression : number operand number;

number : MINUS? Digit+ (POINT Digit+)?;

operand: PLUS|MINUS|MULTIPLY|DIVIDE;

/* Terminals sections */
Digit : [0-9];

PLUS : '+';
MINUS : '-';
MULTIPLY : '*';
DIVIDE : '/';
POINT : '.';