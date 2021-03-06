grammar RetroScript;


/****************** LEXER  ******************/

comment
  : '#' rest_of_line
  ;

  docComment
    :  '###' rest_of_line
    ;
NativeModifier: 'NATIVE';

EntityDataType: 'ENTITY';

Colon: ':';

Function: 'FUNCTION';

NumberDataType: 'NUMBER';

Comma: ',';

ReturnKeyword: 'RETURN';

End: 'END';

Define: 'DEF';

OpenBracket: '(';
CloseBracket: ')';


WS: [ \n\t\r]+ -> skip;



INT
   : '0' .. '9'+
   ;
Quotes: '"';

Equals: '=';
NL      : '\r'? '\n' | '\r';
/** ADD MORE SYMBOLS*/
StringLiteral: Quotes (( 'a' .. 'z' | 'A' .. 'Z' ) | ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '.' | ',')*) Quotes;
rest_of_line
 : ~NL* // match any token other than a line break zero or more times
 ;
dataType: ID | 'NUMBER' | 'STRING' | 'ENTITY' | 'BOOLEAN';

True: 'TRUE';
False: 'FALSE';

Use: 'USE';
ID
   : ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '_')*
   ;



/****************** PARSER  ******************/
sourceFile: (module+ | useStatement+)*;

module: moduleDefinition (entity | function)* endClause;

moduleDefinition: Define NativeModifier? 'MODULE' ID;

useStatement: 'USE' ID;

entity: comment* entityDefinition (function | propertyDefinition | propertyAssignment)* endClause;
entityDefinition: Define EntityDataType ID Colon dataType;

functionDefinition: comment* Define Function Colon ID OpenBracket definitionArgumentSpec* CloseBracket (Colon dataType)?;
definitionArgumentSpec: ID Colon dataType Comma?;

endClause: End;

statement: returnStatement | functionCall;

returnStatement: ReturnKeyword expression;

functionBody: statement*;

function: functionDefinition functionBody endClause;



entityComponent: function | propertyDefinition | propertyAssignment;

propertyDefinition: Define mandatoryModifier? 'PROPERTY' ID Colon dataType Equals expression;

propertyAssignment: ID '=' expression;

mandatoryModifier: 'MANDATORY';

assignment: Equals expression;
functionCall: ID OpenBracket argumentSpec* CloseBracket;

argumentSpec: expression Comma?;

arithmeticOperator: Addition | Minus | Times | Devision;

expression: atom (arithmeticExpressionComponent)*;
arithmeticExpressionComponent: arithmeticOperator atom;
atom: INT | functionCall | StringLiteral | ID | True | False;

Addition: '+';
Minus: '-';
Times: '*';
Devision: '/';