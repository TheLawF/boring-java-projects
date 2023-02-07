package meaningless;

/**
 * What's happening
 */
public class CQ extends AbstractQuarantineMintaqa{
    protected Oblast oblast;
    protected boolean isSilent;

    public CQ(Oblast oblastIn) {
        super(oblastIn);
        this.oblast = oblastIn;
    }

    @Override
    protected boolean setSilent() {
        return isSilent = true;
    }

    @Override
    public void quarantine(int day) {
    }
}
