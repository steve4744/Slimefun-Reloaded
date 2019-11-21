package optic_fusion1.slimefunreloaded.util.collection;

import java.util.Map;

public class Pair<P, S> {

  private P firstValue;
  private S secondValue;

  public Pair(P a, S b) {
    this.firstValue = a;
    this.secondValue = b;
  }

  public Pair(Map.Entry<P, S> mapEntry) {
    this(mapEntry.getKey(), mapEntry.getValue());
  }

  public Pair(OptionalPair<P, S> pair) {
    this(pair.getFirstValue().orElse(null), pair.getSecondValue().orElse(null));
  }

  public P getFirstValue() {
    return firstValue;
  }

  public S getSecondValue() {
    return secondValue;
  }

}
