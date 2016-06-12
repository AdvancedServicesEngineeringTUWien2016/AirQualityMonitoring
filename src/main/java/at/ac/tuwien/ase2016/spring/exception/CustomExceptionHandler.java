package at.ac.tuwien.ase2016.spring.exception;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Daniel Hofer on 12.06.2016.
 */

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleGenericException(final Exception exception) {
        logException(exception);
        return "Unknown error occurred";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public String handleServletRequestBindingException(final ServletRequestBindingException exception) {
        logException(exception);
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String handleRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException exception) {
        logException(exception);
        return "Request Method Not Supported";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public String handleBadRequestException(final BadRequestException exception) {
        logException(exception);
        return exception.getMessage();
    }


    private void logException(final Exception exception) {
        logger.error(exception);
        exception.printStackTrace();
    }

}