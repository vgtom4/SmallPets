package it.smallcode.smallpets.v1_15.listener;
/*

Class created by SmallCode
05.07.2020 14:40

*/

import it.smallcode.smallpets.events.PetLevelUpEvent;
import it.smallcode.smallpets.languages.LanguageManager;
import it.smallcode.smallpets.manager.PetMapManager;
import it.smallcode.smallpets.manager.UserManager;
import it.smallcode.smallpets.text.CenteredText;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PetLevelUpListener implements Listener {

    private LanguageManager languageManager;

    public PetLevelUpListener(LanguageManager languageManager){

        this.languageManager = languageManager;

    }

    @EventHandler
    public void onLevelUP(PetLevelUpEvent e){

        Player p = e.getPet().getOwner();

        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

        p.sendMessage("§2----------------------------------------------------");

        p.sendMessage(CenteredText.sendCenteredMessage(languageManager.getLanguage().getStringFormatted("experienceSummary"), 154));
        p.sendMessage("");
        p.sendMessage(CenteredText.sendCenteredMessage(languageManager.getLanguage().getStringFormatted("levelupText")
                .replaceAll("%pet_level%", "" + e.getPet().getLevel()), 154));

        if(e.getPet().getLevel() != 100)
            p.sendMessage(CenteredText.sendCenteredMessage(languageManager.getLanguage().getStringFormatted("nextLevel")
                    .replaceAll("%exp_next_level%", "" + (e.getPet().getExpForNextLevel() - e.getPet().getXp() +1))
                    .replaceAll("%pet_next_level%", "" + (e.getPet().getLevel() +1)), 154));

        p.sendMessage("");

        p.sendMessage("§2----------------------------------------------------");

    }

}
