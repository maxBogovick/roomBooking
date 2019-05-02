package model.exeption;

public class ServiceException extends RuntimeException {
    /**
     * {@inheritDoc}
     */
    public ServiceException(String wrongData) {
        super(wrongData);
    }

    public ServiceException() {}
}
