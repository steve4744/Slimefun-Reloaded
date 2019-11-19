package optic_fusion1.slimefunreloaded.updater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class UpdateDownloader {

    private static UpdateDownloader instance = new UpdateDownloader();

    public static UpdateDownloader getInstance() {
        return instance;
    }

    private UpdateDownloader() {
    }

    public void checkAutoDownload(JavaPlugin plugin, int resourceId) {
        Updater updater = new Updater(plugin, resourceId, false);
        switch (updater.getResult()) {
            case UPDATE_AVAILABLE:
                download(plugin, resourceId);
                plugin.getLogger().info(
                        "Downloaded jar automaticly, restart to update. Note: Updates take 30-40 minutes to load");
                break;
            default:
                break;
        }
    }

    public boolean download(Plugin plugin, int resourceId) {
        try {
            download(new URL("https://api.spiget.org/v2/resources/" + resourceId + "/download"),
                    new File(Bukkit.getServer().getUpdateFolderFile(), plugin.getDescription().getName() + ".jar"));
            return true;
        } catch (IOException e) {
            plugin.getLogger().warning("Unable to download jar");
            e.printStackTrace();
            return false;
        }
    }

    private void download(URL url, File target) throws IOException {
        target.getParentFile().mkdirs();
        target.createNewFile();
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(target);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
