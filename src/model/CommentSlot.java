package model;

public class CommentSlot extends Slot{

    private String comment;

    public CommentSlot(String s) {
        comment = s;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public String editorString() {
        return comment;
    }

    @Override
    public String toString() {
        return comment.substring(1);

    }
}
