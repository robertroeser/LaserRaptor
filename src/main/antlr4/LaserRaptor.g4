grammar LaserRaptor;

options {
    language = Java;
}

@header {
package laser.raptor.antlr.generated;
}

laserRaptor
    : namespaceDeclaration? messageDeclaration* EOF
    ;

namespaceDeclaration
    : 'namespace' qualifiedName ';'
    ;

messageDeclaration
    :   'message' Identifier
        messageBody
    ;

messageBody : '{' messageBodyDeclaration* '}' ;

messageBodyDeclaration
    : ';'
    | fieldDeclaration
    | messageDeclaration
    ;

fieldDeclaration
    :   type Identifier ';'
    ;

type
    : messageType*
    ;

messageType
    : 'byte'
    | 'short'
    | 'int'
    | 'long'
    | 'float'
    | 'double'
    | 'string'
    | 'list'
    | 'map'
    | 'binary'
    ;

 /*:

MESSAGE_TYPE
    : BYTE_LITERAL
    | SHORT_LITERAL
    | INT_LITERAL
    | LONG_LITERAL
    | FLOAT_LITERAL
    | DOUBLE_LITERAL
    | STRING_LITERAL
    | LIST_LITERAL
    | MAP_LITERAL
    | BINARY_LITERAL
    ;

 classBodyDeclaration
     :   ';'
     |   'static'? block
     |   modifier* memberDeclaration
     ;

 lassDeclaration
     :   'class' Identifier typeParameters?
         ('extends' type)?
         ('implements' typeList)?
         classBody
     ;
 message_name message_field (message_field | message)+ R_CURLY
    ;*/
/*

message_name : MESSAGE_LITERAL Identifier L_CURLY ;

MESSAGE_LITERAL : 'message' ;

message_field : MESSAGE_TYPE MESSAGE_FIELD_NAME SEMI_COLON ;

MESSAGE_FIELD_NAME : Identifier ;

//-- Laser Raptor Types --
MESSAGE_TYPE
    : BYTE_LITERAL
    | SHORT_LITERAL
    | INT_LITERAL
    | LONG_LITERAL
    | FLOAT_LITERAL
    | DOUBLE_LITERAL
    | STRING_LITERAL
    | LIST_LITERAL
    | MAP_LITERAL
    | BINARY_LITERAL
    ;

BYTE_LITERAL : 'byte' ;
SHORT_LITERAL : 'short' ;
INT_LITERAL : 'int' ;
LONG_LITERAL : 'long' ;
FLOAT_LITERAL : 'float';
DOUBLE_LITERAL : 'double' ;
STRING_LITERAL : 'string' ;
LIST_LITERAL : 'list' ;
MAP_LITERAL : 'map' ;
BINARY_LITERAL : 'binary' ;
//-- Laser Raptor Types --

service
   : SERVICE SERVICE_NAME L_CURLY service_definition (service_definition)* R_CURLY
   ;

SERVICE : 'service' ;

SERVICE_NAME : identifier ;

service_definition
    : service_func_returns
    | service_func_void
    ;

service_func_returns
    : 'request' Identifier '(' Identifier ')' RETURNS '(' Identifier ')' SEMI_COLON
    | 'requestN' Identifier '(' Identifier ')' RETURNS '(' Identifier ')' SEMI_COLON
    | 'subscribe' Identifier '(' Identifier ')' RETURNS '(' Identifier ')' SEMI_COLON
    | 'channel' Identifier '(' Identifier ')' RETURNS '(' Identifier ')' SEMI_COLON
    ;

service_func_void : 'fire' Identifier '(' Identifier ')' RETURNS '(' Identifier ')' SEMI_COLON ;

RETURNS : 'returns' ;
SEMI_COLON : ';' ;
L_CURLY : '{' ;
R_CURLY : '}' ;
L_PAREN : '(' ;
R_PAREN : ')' ;*/

qualifiedName
    :   Identifier ('.' Identifier)*
    ;

Identifier
    :   Letter LetterOrDigit*
    ;

fragment
Letter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
LetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;
WS
    :   (' ' | '\r' | '\t' | '\u000C' | '\n') -> channel(HIDDEN)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~('\n' | '\r')* '\r'? '\n' -> channel(HIDDEN)
    ;
