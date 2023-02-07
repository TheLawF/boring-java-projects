package meaningless;

public abstract class AbstractQuarantineMintaqa implements ICoronaQuarantine{

    protected static final Oblast oblast = new Oblast();
    public AbstractQuarantineMintaqa(Oblast oblastIn) {
    }

    protected abstract boolean setSilent();
}
