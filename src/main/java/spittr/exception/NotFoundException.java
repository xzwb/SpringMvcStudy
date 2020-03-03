package spittr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "没找到嘛， 哪里有那么多原因")
public class NotFoundException extends RuntimeException {
}
