package optic_fusion1.slimefunreloaded.util.block;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
import org.bukkit.Material;

public class MaterialCollection implements Iterable<Material> {

  private final Material[] asArray;

  public MaterialCollection(Collection<Material> materials) {
    this(materials.stream());
  }

  public MaterialCollection(Material... materials) {
    this(Arrays.stream(materials));
  }

  public MaterialCollection(Stream<Material> stream) {
    Objects.requireNonNull(stream);
    this.asArray = stream
     .distinct()
     .filter(Objects::nonNull)
     .toArray(Material[]::new);
  }

  public MaterialCollection merge(MaterialCollection collection) {
    Objects.requireNonNull(collection);
    return new MaterialCollection(Stream.concat(stream(), collection.stream()));
  }

  public Stream<Material> stream() {
    return Arrays.stream(asArray);
  }

  public int size() {
    return asArray.length;
  }

  public boolean isEmpty() {
    return asArray.length == 0;
  }

  public Material get(int index) {
    return asArray[index];
  }
  
  public Material[] getArray(){
    return asArray;
  }

  public boolean contains(Material type) {
    if (type == null) {
      return false;
    }
    return stream().anyMatch(material -> material == type);
  }

  public boolean containsAll(Collection<Material> materials) {
    Objects.requireNonNull(materials);
    return materials.stream().allMatch(this::contains);
  }

  public boolean containsAll(MaterialCollection materials) {
    Objects.requireNonNull(materials);
    return materials.stream().allMatch(this::contains);
  }

  @Override
  public Iterator<Material> iterator() {
    return stream().iterator();
  }

}
