
import tage.ai.behaviortrees.BTCondition;

public class GetBig  extends BTCondition {
    /**
     * Constructs a <code>BTCondition</code>.
     *
     * @param toNegate TRUE if the value returned by <code>check()</code> should be NOTed; otherwise FALSE.
     */
    NPC npcc;
    public GetBig(NPC n) {
        super(false);
        npcc = n;
    }

    @Override
    protected boolean check() {
        return true;
    }
}
