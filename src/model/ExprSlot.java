package model;

import expr.Expr;

public class ExprSlot extends Slot{

    private Sheet sheet;
    private Expr value;

    public ExprSlot(Expr value, Sheet sheet) {
        this.sheet = sheet;
        this.value = value;
    }

    public Expr getExpr() {
        return value;
    }

    @Override
    public double getValue() {
        return value.value(sheet);
    }

    @Override
    public String editorString() {
        return value.toString();
    }

    @Override
    public String toString() {

        return String.valueOf(value.value(sheet)) ;
    }
}