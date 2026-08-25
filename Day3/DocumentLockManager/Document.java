package Day3.DocumentLockManager;

public class Document {
    String name;
    boolean isLocked;
    String accessingUser;
    String docId;
    long timeStamp;

    Document(String _name, String _docId) {
        name = _name;
        docId = _docId;
    }

}
