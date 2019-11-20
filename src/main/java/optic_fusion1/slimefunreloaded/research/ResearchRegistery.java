package optic_fusion1.slimefunreloaded.research;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;

public class ResearchRegistery {

  private static final ResearchManager RESEARCH_MANAGER = Slimefun.getResearchManager();
  private static final SlimefunReloaded PLUGIN = Slimefun.getSlimefunReloaded();

  public void registerResearches() {
    
  }

  private void register(Research research) {
    RESEARCH_MANAGER.addResearch(research);
  }

}
