public class Main {
    public static void main(String[] args){
        UseCaseBundle bundle = new UseCaseBundle();
        AbstractController c = new MainEntryController(bundle);
        c.run();
    }
}
