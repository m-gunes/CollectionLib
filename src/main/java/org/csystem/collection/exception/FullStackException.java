package org.csystem.collection.exception;

//    EmptyStackException'a bakarak bunu tasarlayabilirsiniz
public class FullStackException extends RuntimeException {
    public FullStackException(String string)
    {
        super(string);

    }
    public FullStackException()
    {
    }
}
