public abstract class AbstractController {
    private UseCaseBundle bundle;


    public AbstractController(UseCaseBundle bundle) {this.bundle = bundle;}

    public abstract  AbstractController run();

    public UseCaseBundle getBundle() {
        return bundle;
    }
}
