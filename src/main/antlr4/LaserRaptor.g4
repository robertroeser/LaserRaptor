grammar LaserRaptor;

options {
    language = Java;
}

@header {
package laser.raptor.antlr;
}

laser_raptor
 : namespace (message)* service
 ;

namespace : NAMESPACE QUALIFIED_IDENTIFIER SEMI_COLON ;

NAMESPACE : 'namespace' ;

message
 : MESSAGE message_name L_CURLY message_field (message_field | message)* R_CURLY
 ;

MESSAGE : 'message' ;

message_name : IDENTIFIER ;

message_field : MESSAGE_TYPE IDENTIFIER SEMI_COLON ;

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

fragment BYTE_LITERAL : 'byte' ;
fragment SHORT_LITERAL : 'short' ;
fragment INT_LITERAL : 'int' ;
fragment LONG_LITERAL : 'long' ;
fragment FLOAT_LITERAL : 'float';
fragment DOUBLE_LITERAL : 'double' ;
fragment STRING_LITERAL : 'string' ;
fragment LIST_LITERAL : 'list' ;
fragment MAP_LITERAL : 'map' ;
fragment BINARY_LITERAL : 'binary' ;
//-- Laser Raptor Types --

service
   : SERVICE service_name L_CURLY service_definition (service_definition)* R_CURLY
   ;

SERVICE : 'service' ;

service_name : IDENTIFIER ;

service_definition
    : service_func_returns
    | service_func_void
    ;

service_func_returns
    : 'request' IDENTIFIER '(' IDENTIFIER ')' RETURNS '(' IDENTIFIER ')' SEMI_COLON
    | 'requestN' IDENTIFIER '(' IDENTIFIER ')' RETURNS '(' IDENTIFIER ')' SEMI_COLON
    | 'subscribe' IDENTIFIER '(' IDENTIFIER ')' RETURNS '(' IDENTIFIER ')' SEMI_COLON
    | 'channel' IDENTIFIER '(' IDENTIFIER ')' RETURNS '(' IDENTIFIER ')' SEMI_COLON
    ;

service_func_void : 'fire' IDENTIFIER '(' IDENTIFIER ')' RETURNS '(' IDENTIFIER ')' SEMI_COLON ;

RETURNS : 'returns' ;
SEMI_COLON : ';' ;
L_CURLY : '{' ;
R_CURLY : '}' ;
L_PAREN : '(' ;
R_PAREN : ')' ;

IDENTIFIER : '_'* ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;
QUALIFIED_IDENTIFIER : IDENTIFIER ('.' IDENTIFIER)+ ;

WS
    :   (' ' | '\r' | '\t' | '\u000C' | '\n') -> channel(HIDDEN)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~('\n' | '\r')* '\r'? '\n' -> channel(HIDDEN)
    ;