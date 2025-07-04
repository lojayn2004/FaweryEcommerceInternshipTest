public class NonExpiryStrategy implements IExpiryStrategy {
    @Override
    public boolean IsExpired() {
        return false;
    }
}
