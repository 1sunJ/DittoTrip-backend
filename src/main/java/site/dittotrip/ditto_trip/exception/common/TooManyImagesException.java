package site.dittotrip.ditto_trip.exception.common;

import org.springframework.http.HttpStatus;

public class TooManyImagesException extends CustomException {

    private static final String MESSAGE = "이미지가 너무 많습니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HTTP_STATUS;
    }

}
