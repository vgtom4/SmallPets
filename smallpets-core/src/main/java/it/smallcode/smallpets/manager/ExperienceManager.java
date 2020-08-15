package it.smallcode.smallpets.manager;
/*

Class created by SmallCode
15.08.2020 10:26

*/

import it.smallcode.smallpets.manager.types.ExperienceTable;
import it.smallcode.smallpets.pets.PetType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ExperienceManager {

    private static final String fileName = "experienceTable";

    private JavaPlugin plugin;

    private ArrayList<ExperienceTable> experienceTables;

    public ExperienceManager(JavaPlugin plugin){

        this.plugin = plugin;

        load();

    }

    public void load(){

        experienceTables = new ArrayList<>();

        File file = new File(plugin.getDataFolder(), fileName + ".yml");

        file.getParentFile().mkdirs();

        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            writeDefaults();
            return;

        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Set<String> keys = cfg.getKeys(false);

        for(String id : keys){

            ExperienceTable experienceTable = new ExperienceTable();

            ConfigurationSection section = (ConfigurationSection) cfg.get(id);

            experienceTables.add(experienceTable.unserialize(id, section));

        }

    }

    private void writeDefaults(){

        experienceTables = new ArrayList<>();

        ExperienceTable combatTable = new ExperienceTable();

        combatTable.setPetType(PetType.combat);

        HashMap<String, Integer> combatTableExp = new HashMap<>();

        combatTableExp.put("creeper", 10);
        combatTableExp.put("skeleton", 5);
        combatTableExp.put("spider", 5);
        combatTableExp.put("zombie", 5);
        combatTableExp.put("slime", 1);
        combatTableExp.put("blaze", 5);
        combatTableExp.put("magma_cube", 5);
        combatTableExp.put("enderman", 15);
        combatTableExp.put("ghast", 30);
        combatTableExp.put("zombie_pigman", 10);
        combatTableExp.put("bat", 1);
        combatTableExp.put("guardian", 15);
        combatTableExp.put("shulker", 15);
        combatTableExp.put("vex", 10);
        combatTableExp.put("evocation_illager", 10);
        combatTableExp.put("vindication_illager", 10);
        combatTableExp.put("illusion_illager", 10);
        combatTableExp.put("husk", 5);
        combatTableExp.put("wither_skeleton", 15);
        combatTableExp.put("elder_guardian", 500);

        combatTableExp.put("ender_dragon", 1000);
        combatTableExp.put("wither", 1500);
        combatTableExp.put("ender_crystal", 50);

        combatTableExp.put("sheep", 2);
        combatTableExp.put("pig", 2);
        combatTableExp.put("cow", 2);
        combatTableExp.put("chicken", 2);

        combatTableExp.put("rabbit", -2);
        combatTableExp.put("polar_bear", -10);
        combatTableExp.put("villager", -20);

        combatTable.setExperienceTable(combatTableExp);

        experienceTables.add(combatTable);

        save();
        load();

    }

    private void save(){

        File file = new File(plugin.getDataFolder(), fileName + ".yml");

        file.getParentFile().mkdirs();

        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            writeDefaults();
            return;

        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        for(ExperienceTable experienceTable : experienceTables){

            cfg.set(experienceTable.getPetType().getId(), experienceTable.getExperienceTable());

        }

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<ExperienceTable> getExperienceTables() {
        return experienceTables;
    }
}