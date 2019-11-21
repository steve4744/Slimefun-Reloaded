package optic_fusion1.slimefunreloaded.util.collection;

import java.util.Map;
import java.util.Optional;

public class OptionalPair<P, S> {

  private Optional<P> firstValue = Optional.empty();
  private Optional<S> secondValue = Optional.empty();

  public OptionalPair(P a, S b) {
    this.firstValue = Optional.ofNullable(a);
    this.secondValue = Optional.ofNullable(b);
  }

  public OptionalPair(Map.Entry<P, S> mapEntry) {
    this(mapEntry.getKey(), mapEntry.getValue());
  }

  public OptionalPair(Pair<P, S> pair) {
    this(pair.getFirstValue(), pair.getSecondValue());
  }

  public Optional<P> getFirstValue() {
    return firstValue;
  }

  public Optional<S> getSecondValue() {
    return secondValue;
  }

}
