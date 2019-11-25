package optic_fusion1.slimefunreloaded.machine;

public enum MachineTier {

  BASIC("&eBasic"),
  AVERAGE("&6Average"),
  MEDIUM("&aMedium"),
  GOOD("&2Good"),
  ADVANCED("&6Advanced"),
  END_GAME("&4End-Game");


  private final String prefix;

  private MachineTier(String prefix) {
    this.prefix = prefix;
  }

  public String getPrefix() {
    return prefix;
  }

  public String and(MachineType type) {
    return this.getPrefix() + " " + type.getDescriptor();
  }

}
