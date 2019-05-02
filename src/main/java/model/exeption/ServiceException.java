package model.exeption;

public class ServiceException extends RuntimeException {

    public ServiceException(String wrongData) {
        super(wrongData);
    }

    public ServiceException() {}
}
