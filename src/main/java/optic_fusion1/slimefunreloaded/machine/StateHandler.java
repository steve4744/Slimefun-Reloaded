package optic_fusion1.slimefunreloaded.machine;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import org.bukkit.Location;
import org.bukkit.block.Block;

import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;
import optic_fusion1.slimefunreloaded.component.machine.SlimefunReloadedMachine;

public class StateHandler {

  private final Map<Location, MachineState> states = new HashMap<>();
  private final Multimap<Class<? extends SlimefunReloadedComponent>, MachineState> classifiedStates = HashMultimap.create();

  public void registerState(Block block, MachineState state) {
    Preconditions.checkArgument(block != null, "Cannot register state to null block");
    this.registerState(block.getLocation(), state);
  }

  public void registerState(Location location, MachineState state) {
    Preconditions.checkArgument(location != null && location.getWorld() != null, "Cannot register state to null location or null world");
    Preconditions.checkArgument(state != null, "Cannot register null state");

    this.states.put(location, state);
    this.classifiedStates.put(state.getMachine().getClass(), state);
  }

  public MachineState getState(Block block) {
    return (block != null) ? getState(block.getLocation()) : null;
  }

  public MachineState getState(Location location) {
    return states.get(location);
  }

  public Collection<MachineState> getStatesForType(Class<? extends SlimefunReloadedMachine<?>> type) {
    return Collections.unmodifiableCollection(classifiedStates.get(type));
  }

  public MachineState unregisterState(Block block) {
    Preconditions.checkArgument(block != null, "Cannot unregister state from null block");
    return unregisterState(block.getLocation());
  }

  public MachineState unregisterState(Location location) {
    Preconditions.checkArgument(location != null && location.getWorld() != null, "Cannot unregister state from null location or null world");
    return states.remove(location);
  }

  public void clearAllStates() {
    this.states.clear();
  }

}
