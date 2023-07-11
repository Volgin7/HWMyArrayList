package sky.myarraylist.exception;

import java.io.IOException;

public class OutOfArrayLimitsException extends IOException {
    public OutOfArrayLimitsException(String message) {
        super(message);
    }
}
