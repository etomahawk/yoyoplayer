package com.chinacnd.framework.util;

import java.text.MessageFormat;

/**
 * MessageFormat use "'" (single quote) as format char,
 * Don't use e.g. "can't find {0}" as message format, use "can not"
 *
 * @author Hades
 */
public class MessageFormatRuntimeException extends RuntimeException {
    public MessageFormatRuntimeException(String pattern, Object... arguments) {
        super(MessageFormat.format(pattern, (Object[]) arguments));
    }

    public MessageFormatRuntimeException(String pattern, Throwable cause, Object... arguments) {
        super(MessageFormat.format(pattern, (Object[]) arguments), cause);
    }

    public MessageFormatRuntimeException(Throwable cause) {
        super(cause);
    }
}
