package exception;

public class MailIsNotInDraftFolderException extends Exception {

    public MailIsNotInDraftFolderException(String message)
    {
        super(message);
    }
}
