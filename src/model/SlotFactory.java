package model;

import expr.Expr;
import expr.ExprParser;

import java.io.IOException;
import java.util.Optional;

public class SlotFactory {

    private ExprParser parser;

    public SlotFactory() {
        parser = new ExprParser();
    }

    public Slot slot(String s,Sheet sheet) throws IOException {

        if(s.startsWith("#")) {
            return new CommentSlot(s);
        }

        Expr e = parser.build(s);
        return new ExprSlot(e,sheet);

    }
    public Slot slot() {
        return new SpecialSlot();
    }


}
