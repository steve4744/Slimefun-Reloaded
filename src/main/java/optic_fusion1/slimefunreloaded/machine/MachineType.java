package optic_fusion1.slimefunreloaded.machine;

public enum MachineType {

  CAPACITOR("Capacitor"),
  GENERATOR("Generator"),
  MACHINE("Machine");

  private String descriptor;

  private MachineType(String descriptor) {
    this.descriptor = descriptor;
  }

  public String getDescriptor() {
    return descriptor;
  }

}
