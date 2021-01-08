package it.smallcode.smallpets.cmds;
/*

Class created by SmallCode
30.08.2020 15:03

*/

import it.smallcode.smallpets.core.SmallPetsCommons;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum SubCommandType {

    ADMIN("admin", 1, true),
    DEBUG("debug", 1,  SmallPetsCommons.DEBUG),
    NONE("", 0, true);

    private String name;
    private int minArgs;
    private boolean active;

    SubCommandType(String name, int minArgs, boolean active){

        this.name = name;
        this.minArgs = minArgs;
        this.active = active;

    }

    public String getName() {
        return name;
    }

    public int getMinArgs() {
        return minArgs;
    }

    public boolean isActive() {
        return active;
    }

    public static List<String> handleAutoComplete(CommandSender s, String[] args){

        List<String> options = new LinkedList<>();

        Arrays.stream(SubCommandType.values())
                .filter(subCommandType -> (args.length <= subCommandType.getMinArgs() && subCommandType.active))
                .forEach(subCommandType -> options.add(subCommandType.getName())
        );

        return options;

    }

}
