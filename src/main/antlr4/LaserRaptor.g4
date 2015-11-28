grammar LaserRaptor;

options {
    language = Java;
}

@header {
package laser.raptor.antlr.generated;
}

laserRaptor
    : namespaceDeclaration? messageDeclaration* serviceDeclaration EOF
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
    | 'boolean'
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

serviceDeclaration
    :   'service' Identifier
        serviceBody
    ;

serviceBody : '{' serviceBodyDeclaration* '}' ;

serviceBodyDeclaration
    : Request Identifier Identifier 'returns' Identifier ';'
    | RequestN Identifier Identifier 'returns' Identifier ';'
    | Subscribe Identifier Identifier 'returns' Identifier ';'
    | Channel Identifier Identifier 'returns' Identifier ';'
    | Fire Identifier Identifier 'returns' Identifier ';'
    ;

Request : 'request' ;
RequestN : 'requestN' ;
Subscribe : 'subscribe' ;
Channel : 'channel' ;
Fire : 'fire' ;

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
