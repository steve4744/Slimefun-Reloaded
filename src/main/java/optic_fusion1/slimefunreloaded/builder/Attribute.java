package optic_fusion1.slimefunreloaded.builder;

import java.util.UUID;

public class Attribute {

  private String name;
  private int amount;
  private AttributeOperation operation;
  private UUID uuid;
  private AttributeSlot slot;

  public Attribute(String name, int amount, AttributeOperation opteration, UUID uuid, AttributeSlot slot) {
    this.name = name;
    this.amount = amount;
    this.operation = opteration;
    this.uuid = uuid;
    this.slot = slot;
  }

  public String getName() {
    return name;
  }

  public int getAmount() {
    return amount;
  }

  public AttributeOperation getOperation() {
    return operation;
  }

  public UUID getUniqueId() {
    return uuid;
  }

  public AttributeSlot getSlot() {
    return slot;
  }

  public enum AttributeOperation {

    AMOUNT(0),
    PERCENTAGE(1),
    MULTIPLICATIVE(2);

    private int value;

    AttributeOperation(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

  }

  public enum AttributeSlot {

    ANY("ANY"),
    MAIN_HAND("mainhand"),
    OFF_HAND("offhand"),
    FEET("feet"),
    LEGS("legs"),
    CHEST("chest"),
    HEAD("head");

    private String value;

    AttributeSlot(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

  }

}
