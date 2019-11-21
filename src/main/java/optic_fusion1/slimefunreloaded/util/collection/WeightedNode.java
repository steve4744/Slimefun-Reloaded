package optic_fusion1.slimefunreloaded.util.collection;

import java.util.Objects;

public class WeightedNode<T> {

  private float weight;

  private T object;

  public WeightedNode(float weight, T object) {
    Objects.requireNonNull(object);
    this.weight = weight;
    this.object = object;
  }

  @Override
  public int hashCode() {
    return object.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    Object compared = obj;
    if (obj instanceof WeightedNode) {
      compared = ((WeightedNode<?>) obj).getObject();
    }

    return obj != null && object.getClass().isInstance(compared) && compared.hashCode() == hashCode();
  }

  public T getObject() {
    return object;
  }

  public float getWeight() {
    return weight;
  }
  
  public void setWeight(float weight){
    this.weight = weight;
  }

}
