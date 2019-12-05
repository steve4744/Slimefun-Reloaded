package optic_fusion1.slimefunreloaded.util.material;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.Tag;

@Deprecated
public final class MaterialTools {

  // This is a pure Utility class, we do not want any instantiation to happen!
  private MaterialTools() {
  }

  private static final MaterialCollection breakableByShovel;

  static {
    Set<Material> shovel = new HashSet<>();
    shovel.addAll(Arrays.asList(
     Material.SNOW, Material.SNOW_BLOCK, Material.FARMLAND, Material.SOUL_SAND,
     Material.CLAY, Material.GRAVEL, Material.GRASS_PATH
    ));

    for (Material mat : Material.values()) {
      if (Tag.DIRT_LIKE.isTagged(mat) || Tag.SAND.isTagged(mat)) {
        shovel.add(mat);
      }
    }

    breakableByShovel = new MaterialCollection(shovel);
  }

  public static MaterialCollection getBreakableByShovel() {
    return breakableByShovel;
  }

}
