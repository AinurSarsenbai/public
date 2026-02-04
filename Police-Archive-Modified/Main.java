
public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseHandler db = DatabaseHandler.getInstance();
        CaseManager caseManager = new CaseManager(db);
        caseManager.getFullCaseDescription(1);
    }
}
