package com.test;

import com.test.antlr.MathGrammarLexer;
import com.test.antlr.MathGrammarParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MathParser {

    public static Expression parse(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Lexer lexer = new MathGrammarLexer(getCharStream(inputStream));
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        MathGrammarParser parser = new MathGrammarParser(commonTokenStream);

        MathListener listener = new MathListener();
        ParseTree parseTree = parser.expression();
        ParseTreeWalker.DEFAULT.walk(listener, parseTree);
        return listener.getExpression();
    }

    private static CharStream getCharStream(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        try {
            return CharStreams.fromStream(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
