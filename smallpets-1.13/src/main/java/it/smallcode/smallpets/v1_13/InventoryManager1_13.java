package it.smallcode.smallpets.v1_13;
/*

Class created by SmallCode
10.07.2020 15:13

*/

import it.smallcode.smallpets.languages.LanguageManager;
import it.smallcode.smallpets.manager.InventoryCache;
import it.smallcode.smallpets.v1_15.InventoryManager1_15;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryManager1_13 extends InventoryManager1_15 {

    public InventoryManager1_13(InventoryCache inventoryCache, LanguageManager languageManager, double xpMultiplier, JavaPlugin plugin) {
        super(inventoryCache, languageManager, xpMultiplier, plugin);
    }
}
