package exception;

public class MailIsNotInSendFolderException extends  Exception {
    public MailIsNotInSendFolderException(String message) {
        super(message);
    }
}
