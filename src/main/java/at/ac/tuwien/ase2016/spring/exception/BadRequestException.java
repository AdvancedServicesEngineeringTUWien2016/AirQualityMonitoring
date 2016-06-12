package at.ac.tuwien.ase2016.spring.exception;

/**
 * Created by DanielHofer on 12.06.2016.
 */

public class BadRequestException extends Exception
{
    public BadRequestException() {}

    public BadRequestException(String message)
    {
        super(message);
    }
}