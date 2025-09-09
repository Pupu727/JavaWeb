package com.lirui.Exception;

/**
 * 自定义异常：当班级下有学生时抛出
 */
public class ClazzHasStudentsException extends RuntimeException {

    public ClazzHasStudentsException() {
        super();
    }

    public ClazzHasStudentsException(String message) {
        super(message);
    }

    public ClazzHasStudentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClazzHasStudentsException(Throwable cause) {
        super(cause);
    }

    protected ClazzHasStudentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
