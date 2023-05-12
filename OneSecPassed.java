

import tage.ai.behaviortrees.BTCondition;

public class OneSecPassed  extends BTCondition {
    /**
     * Constructs a <code>BTCondition</code>.
     *
     * @param toNegate TRUE if the value returned by <code>check()</code> should be NOTed; otherwise FALSE.
     */
    NPC npc;
    NPCcontroller npcc;
    public OneSecPassed( NPCcontroller c, NPC n, boolean toNegate) {
        super(toNegate);
        npcc = c; npc = n;
    }

    @Override
    protected boolean check() {
        return npcc.getNearFlag();
    }
}
