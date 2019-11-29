package optic_fusion1.slimefunreloaded.builder;

public enum ItemFlag {

  ENCHANTMENTS(1),
  MODIFIERS(2),
  UNBREAKABLE(4),
  CAN_DESTROY(8),
  CAN_PLACE_ON(16),
  HIDE_OTHERS(32);
  
  private int value;
  
  ItemFlag(int value){
    this.value = value;
  }
  
  public int getValue(){
    return value;
  }
  
}
