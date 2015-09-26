package net.zyuiop.bungeebridgemessages;

import net.bridgesapis.bungeebridge.BungeeBridge;
import net.bridgesapis.bungeebridge.commands.CommandHelp;
import net.bridgesapis.bungeebridge.core.TasksExecutor;
import net.bridgesapis.bungeebridge.core.database.DatabaseConnector;
import net.bridgesapis.bungeebridge.core.database.Publisher;
import net.bridgesapis.bungeebridge.core.database.ServerSettings;
import net.bridgesapis.bungeebridge.core.players.PlayerDataManager;
import net.bridgesapis.bungeebridge.core.players.UUIDTranslator;
import net.bridgesapis.bungeebridge.core.proxies.NetworkBridge;
import net.bridgesapis.bungeebridge.core.servers.ServersManager;
import net.bridgesapis.bungeebridge.permissions.PermissionsBridge;
import net.md_5.bungee.api.plugin.Plugin;
import net.zyuiop.bungeebridgemessages.commands.CommandMsg;
import net.zyuiop.bungeebridgemessages.commands.CommandReply;

/**
 * @author zyuiop
 */
public class BungeeBridgeMessagesPlugin extends Plugin {
    private final PrivateMessagesManager manager = new PrivateMessagesManager(this);
    private BungeeBridge bridge;

    public void onEnable() {
        bridge = BungeeBridge.getInstance();
        bridge.getConnector().subscribe("privatemessages", new PrivateMessagesHandler(manager));

        getProxy().getPluginManager().registerCommand(this, new CommandMsg(this));
        getProxy().getPluginManager().registerCommand(this, new CommandReply(this));

        CommandHelp.addHelp("msg <player> <message>", "Sends a private message to a player");
        CommandHelp.addHelp("r <message>", "Sends a private message to the last recipient");
    }

    public String getProxyName() {
        return bridge.getProxyName();
    }

    public ServerSettings getServerSettings() {
        return bridge.getServerSettings();
    }

    public Publisher getPublisher() {
        return bridge.getPublisher();
    }

    public PermissionsBridge getPermissionsBridge() {
        return bridge.getPermissionsBridge();
    }

    public NetworkBridge getNetworkBridge() {
        return bridge.getNetworkBridge();
    }

    public ServersManager getServersManager() {
        return bridge.getServersManager();
    }

    public UUIDTranslator getUuidTranslator() {
        return bridge.getUuidTranslator();
    }

    public TasksExecutor getExecutor() {
        return bridge.getExecutor();
    }

    public DatabaseConnector getConnector() {
        return bridge.getConnector();
    }

    public PlayerDataManager getPlayerDataManager() {
        return bridge.getPlayerDataManager();
    }

    public PrivateMessagesManager getPrivateMessagesManager() {
        return manager;
    }
}
