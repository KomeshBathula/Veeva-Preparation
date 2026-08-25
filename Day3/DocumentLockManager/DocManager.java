package Day3.DocumentLockManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class DocManager {

    private static HashMap<String, Document> documents = new HashMap<>();

    static { 
        documents.put("doc12345", new Document("Salary.docx","doc12345" ));
        documents.put("doc21345", new Document("Bonus.docx", "doc21345"));
        documents.put("doc31245", new Document("Salary2.docx", "doc31245"));
        documents.put("doc41235", new Document("Bonus2.docx", "doc41235"));

    }

    private static void requestLock(String docId, String userId, long timeStamp) {
        Document doc = documents.get(docId);

        if (doc == null) {
            System.out.println("Error !! Nothing found");
            return;
        }

        if (!doc.isLocked) {
            doc.isLocked = true;
            doc.accessingUser = userId;
            doc.timeStamp = timeStamp;
            System.out.println("Doc is Locked now");
        }
        else {
            System.out.println("Doc is already locked by another user");
            return;
        }
    }

    private static void releaseLock(String docId, String userId) {
        Document doc = documents.get(docId);

        if (doc == null) {
            System.out.println("Error !! Nothing found");
            return;
        }

        if (!doc.isLocked) {
            System.out.println("It is not locked by any user");
        }

        else {
            if (doc.accessingUser.equals(userId)) {
                doc.isLocked = false;
                doc.accessingUser = "";
            }

            else {
                System.out.println("You are not authorized");
            }
        }
    }

    private static void cleanExpiredLocks(long currTime, int duration) {
        long durationInMs = duration * 1000;
        
        for (Document doc : documents.values()) {
            if (doc.isLocked) {
                long timeElapsed = currTime - doc.timeStamp;

                if (timeElapsed > durationInMs) {
                    doc.isLocked = false;
                    doc.accessingUser = "";
                    doc.timeStamp = 0;
                    System.out.println("Release lock for "+doc.docId);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. Request Lock");
            System.out.println("2. Release Lock");
            System.out.println("3. Clean Expired Locks");
            System.out.println("4. Exit");

            int ch = sc.nextInt();
            if (ch == 1) {
                String docId = sc.next();
                String userId = sc.next();
                Date date = new Date();
                long timeStamp = date.getTime();

                requestLock(docId, userId, timeStamp);
            } else if (ch == 2) {
                String docId = sc.next();
                String userId = sc.next();

                releaseLock(docId, userId);
            } else if (ch == 3) {
                int duration = sc.nextInt();
                Date date = new Date();
                long currTime = date.getTime();

                cleanExpiredLocks(currTime, duration);
            } else if (ch == 4) {
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Enter valid Choice !!!");
            }
        }
    }
}
