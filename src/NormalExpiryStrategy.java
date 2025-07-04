import java.util.Date;

public class NormalExpiryStrategy implements IExpiryStrategy{
    private Date expiryDate;

    public NormalExpiryStrategy(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean IsExpired() {
        Date currentDate = new Date();
        return expiryDate.before(currentDate);
    }
}
