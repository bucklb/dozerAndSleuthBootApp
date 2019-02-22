package me.bucklb.simpleBootdemo.Exception;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppErrorHandler {

    private Logger logger = LoggerFactory.getLogger(AppErrorHandler.class);

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleInternalError(Exception e) {
        logger.error("internal server error", e);
        if(MDC.get("X-B3-TraceId").equals(MDC.get("X-B3-SpanId"))){
            return String.format("Internal Server Error (traceId: %s)", MDC.get("X-B3-TraceId"));
        } else {
            return String.format("Internal Server Error (traceId: %s and spanId: %s)", MDC.get("X-B3-TraceId"), MDC.get("X-B3-SpanId"));
        }




    }

}
