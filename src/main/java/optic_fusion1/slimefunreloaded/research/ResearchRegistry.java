package optic_fusion1.slimefunreloaded.research;

import org.bukkit.NamespacedKey;

import optic_fusion1.slimefunreloaded.Slimefun;
import optic_fusion1.slimefunreloaded.SlimefunReloaded;
import optic_fusion1.slimefunreloaded.component.SlimefunReloadedComponent;

public final class ResearchRegistry {

  private static final ResearchManager RESEARCH_MANAGER = Slimefun.getResearchManager();
  private static final SlimefunReloaded PLUGIN = Slimefun.getSlimefunReloaded();

  //TODO: Add items
  public static void registerResearches() {
    register(new Research(new NamespacedKey(PLUGIN, "Walking_Sticks"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Portalable_Crafter"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Fortune_Cookie"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Portable_Dustbin"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Jerkys"), 2));
    register(new Research(new NamespacedKey(PLUGIN, "Armor_Crafting"), 2));
    register(new Research(new NamespacedKey(PLUGIN, "Lumps_and_Magic"), 3));
    register(new Research(new NamespacedKey(PLUGIN, "Ender_Backpack"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Glowstone_Armor"), 3));
    register(new Research(new NamespacedKey(PLUGIN, "Ender_Armor"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Magic_Eye_of_Ender"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Magic_Sugar"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Monster_Jerky"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "Slime_Armor"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "Sword_of_Beheading"), 6));
    register(new Research(new NamespacedKey(PLUGIN, "Electric_Work"), 8));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Electricity"), 9));
    register(new Research(new NamespacedKey(PLUGIN, "Hot_Smelting"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Steel_Age"), 11));
    register(new Research(new NamespacedKey(PLUGIN, "Important_Power-Related_Items"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Your_first_Battery"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Steel_Plating"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Steel_Thruster"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Parachute"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Grappling_Hook"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Jetpacks"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Multi_Tools"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Solar_Power"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Elemental_Staves"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Grind_Stone"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Cactus_Suit"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "Gold_Pan"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "Magical_Book_Binding"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "New_Metals"), 6));
    register(new Research(new NamespacedKey(PLUGIN, "Ore_Doubling"), 6));
    register(new Research(new NamespacedKey(PLUGIN, "Bronze_Creation"), 8));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Alloys"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Carbon_Creation"), 9));
    register(new Research(new NamespacedKey(PLUGIN, "Bakery_Innovation"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Gilded_Iron_Armor"), 16));
    register(new Research(new NamespacedKey(PLUGIN, "Synthetic_Diamonds"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Pressure_Chamber"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Synthetic_Sapphires"), 16));
    register(new Research(new NamespacedKey(PLUGIN, "Damascus_Steel"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Damascus_Steel_Armor"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Reinforced_Alloy"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Black_Diamonds"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Magic_Workbench"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Wind_Staff"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Reinforced_Armor"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Ore_Washer"), 5));
    register(new Research(new NamespacedKey(PLUGIN, "Pure_Gold"), 7));
    register(new Research(new NamespacedKey(PLUGIN, "Silicon_Valley"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Fire_Staff"), 2));
    register(new Research(new NamespacedKey(PLUGIN, "Smelters_Pickaxe"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Common_Talisman"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Anvil"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Miner"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Hunter"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Lava Walker"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Water Breather"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Angel"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Firefighter"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Firey_Situation"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Magician"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Traveller"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Warrior"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Knight"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Shiny_Iron"), 11));
    register(new Research(new NamespacedKey(PLUGIN, "Fake_Gem"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Chainmail_Armor"), 8));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Whirlwind"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Talisman_of_the_Wizard"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Lumber_Axe"), 21));
    register(new Research(new NamespacedKey(PLUGIN, "Hazmat_Suit"), 21));
    register(new Research(new NamespacedKey(PLUGIN, "Radioactive"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Ore_Purification"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Redstone_Alloy"), 16));
    register(new Research(new NamespacedKey(PLUGIN, "Top_Tier_Machines"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "First_Aid"), 2));
    register(new Research(new NamespacedKey(PLUGIN, "Shiny_Armor"), 13));
    register(new Research(new NamespacedKey(PLUGIN, "Night_Vision_Goggles"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Pickaxe_of_Containment"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Hercules_Pickaxe"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Table_Saw"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Slimy_Steel_Armor"), 27));
    register(new Research(new NamespacedKey(PLUGIN, "Blade_of_Vampires"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Lazy_Mining"), 40));
    register(new Research(new NamespacedKey(PLUGIN, "Water_Staff"), 8));
    register(new Research(new NamespacedKey(PLUGIN, "Golden_City"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Mining_101"), 42));
    register(new Research(new NamespacedKey(PLUGIN, "Composting_Dirt"), 3));
    register(new Research(new NamespacedKey(PLUGIN, "Farmer_Shoes"), 4));
    register(new Research(new NamespacedKey(PLUGIN, "Explosive_Tools"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Automated_Gold_Pan"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Boots_of_the_Stomper"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Pickaxe_of_the_Seeker"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Backpacks"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Woven_Backpack"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Cruicible"), 13));
    register(new Research(new NamespacedKey(PLUGIN, "Gilded_Backpack"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Armored_Jetpack"), 27));
    register(new Research(new NamespacedKey(PLUGIN, "Ender_Talismans"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Even_more_Ores"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Magnetic_Metals"), 16));
    register(new Research(new NamespacedKey(PLUGIN, "Infused_Magnets"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Speedy_Pickaxe"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Necromancy"), 19));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Storage"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Jet_Boots"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Armored_Jet_Boots"), 27));
    register(new Research(new NamespacedKey(PLUGIN, "Seismic_Axe"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Pickaxe_of_Vein_Mining"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Weapons"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Tools"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Armor"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Drinks"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Armor"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Delicious Drinks"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Repairing Spawners"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "HO_HO_HO"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Enhanced_Furnace"), 7));
    register(new Research(new NamespacedKey(PLUGIN, "Better_Furnaces"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "High_Tier_Furnace"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Reinforced_Furnace"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Carbonado_Edged_Furnace"), 35));
    register(new Research(new NamespacedKey(PLUGIN, "Heating_up"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Block_Placer"), 17));
    register(new Research(new NamespacedKey(PLUGIN, "Lazy_Panning"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Turning_things_around"), 38));
    register(new Research(new NamespacedKey(PLUGIN, "Robin_Hood"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Sharing_with_friends"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "XP_Storage"), 13));
    register(new Research(new NamespacedKey(PLUGIN, "Withstanding_Explosions"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Happy_Easter"), 1));
    register(new Research(new NamespacedKey(PLUGIN, "Golde_potion"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Portable_Beverages"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Ancient_Altar"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Wither-Proof_Obsidian"), 21));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Solar_Cells"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Elemental_Runes"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Purple_Runes"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Infernal_Bonemeal"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Rainbow_Blocks"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Infused_Hopper"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Wither-Proof_Glass"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Duct_Tape"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Plastic"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Memory_Core"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Oil"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Fuel"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Holograms"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Tier_1_Capacitors"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Tier_2_Capacitors"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Solar Power_Plant"), 14));
    register(new Research(new NamespacedKey(PLUGIN, "Powered_Furnace"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Crushing_and_Grinding"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Heated_Pressure_Chamber"), 22));
    register(new Research(new NamespacedKey(PLUGIN, "Coal_Generator"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Bio-Reactor"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Automatic_Enchanting_and_Disenchanting"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Automatic_Anvil"), 34));
    register(new Research(new NamespacedKey(PLUGIN, "Power_Measurement"), 10));
    register(new Research(new NamespacedKey(PLUGIN, "Basic_GPS_Setup"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "GPS_Emergency_Waypoint"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Programmable_Androids"), 50));
    register(new Research(new NamespacedKey(PLUGIN, "Android_Interfaces"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "GEO-Scans"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Combustion_Reactor"), 38));
    register(new Research(new NamespacedKey(PLUGIN, "Teleporter_Base_Components"), 42));
    register(new Research(new NamespacedKey(PLUGIN, "Teleporter_Activation"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Solar_Generators"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Transmitters"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Elevators"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Full-Time_Solar_Power"), 44));
    register(new Research(new NamespacedKey(PLUGIN, "Top_Tier_Transmitter"), 44));
    register(new Research(new NamespacedKey(PLUGIN, "Energy_Networks_101"), 6));
    register(new Research(new NamespacedKey(PLUGIN, "Butcher_Androids"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Organic_Food"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Automated Feeding"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Androids"), 60));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Androids_-_Butcher"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Androids_-_Fisherman"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Animal_Growth_Manipulation"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Exp_Collector"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Organic_Fertilizer"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Crop_Growth_Acceleration"), 40));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Crop_Growth_Accelerator"), 44));
    register(new Research(new NamespacedKey(PLUGIN, "Reactor_Essentials"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Nuclear_Power_Plant"), 48));
    register(new Research(new NamespacedKey(PLUGIN, "Mr_Freeze"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Cargo_Basics"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Cargo_Setup"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Electric_Ingot_Fabrication"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Faster_Ingot_Fabrication"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Super_Fast_Ingot_Fabrication"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Automated_Crafting"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Food_Fabrication"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Reactor_Interaction"), 18));
    register(new Research(new NamespacedKey(PLUGIN, "Fluid_Pump"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Freezer"), 29));
    register(new Research(new NamespacedKey(PLUGIN, "Never-Ending_Circle"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Trash"), 8));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Output_Node"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Carbon_Press"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Electric_Smeltery"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Electric_Furnace"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Carbon Press"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Empowered_Androids"), 60));
    register(new Research(new NamespacedKey(PLUGIN, "Empowered_Androids_-_Butcher"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Empowered_Androids_-_Fisherman"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Ultimate_Carbon_Press"), 32));
    register(new Research(new NamespacedKey(PLUGIN, "Automated_Wither_Killer"), 35));
    register(new Research(new NamespacedKey(PLUGIN, "Upgraded_Heated_Pressure_Chamber"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Elytras"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Special_Elytas"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Electrified_Crucible"), 26));
    register(new Research(new NamespacedKey(PLUGIN, "Hot_Crucibles"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Electric_Smeltery"), 28));
    register(new Research(new NamespacedKey(PLUGIN, "Advanced_Androids_-_Farmer"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Lava_Generator"), 38));
    register(new Research(new NamespacedKey(PLUGIN, "Nether_Ice_Coolant"), 45));
    register(new Research(new NamespacedKey(PLUGIN, "Nether_Star_Reactor"), 60));
    register(new Research(new NamespacedKey(PLUGIN, "Blistering_Radioactivity"), 38));
    register(new Research(new NamespacedKey(PLUGIN, "Automatic_Ignition_Chamber"), 12));
    register(new Research(new NamespacedKey(PLUGIN, "Basic_Machinery_Output_Chest"), 20));
    register(new Research(new NamespacedKey(PLUGIN, "Thinned-down_Conductivity"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Radiant_Backpack"), 25));
    register(new Research(new NamespacedKey(PLUGIN, "A_Dry_Day"), 15));
    register(new Research(new NamespacedKey(PLUGIN, "Diet_Cookie"), 3));
    register(new Research(new NamespacedKey(PLUGIN, "Storm_Staff"), 30));
    register(new Research(new NamespacedKey(PLUGIN, "Soulbound_Rune"), 60));
    register(new Research(new NamespacedKey(PLUGIN, "GEO-Miner"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Lightning_Rune"), 24));
    register(new Research(new NamespacedKey(PLUGIN, "Totem_of_Undying"), 36));
    register(new Research(new NamespacedKey(PLUGIN, "Charging_Bench"), 8));
  }

  private static void register(Research research, SlimefunReloadedComponent... components) {
    RESEARCH_MANAGER.addResearch(research, components);
  }

}
