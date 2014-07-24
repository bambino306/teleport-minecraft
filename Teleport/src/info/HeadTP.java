package info;

import javax.sound.midi.MidiDevice.Info;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HeadTP implements Listener {
	
	private Info plugin;

	public HeadTP(Info info) {
		this.setPlugin(info);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getMaterial() ==Material.WATCH) {
				Inventory inv = Bukkit.createInventory(null, 54, "§4all players");
				
				for(Player players: Bukkit.getOnlinePlayers()) {
					if(players != e.getPlayer()) {
						ItemStack item =new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
						ItemMeta meta =item.getItemMeta();
						meta.setDisplayName("§r§l§o" + players.getName());
						item.setItemMeta(meta);
						
						inv.addItem(item);
					}
				}
				e.getPlayer().openInventory(inv);
			}
		}
	}

	public Info getPlugin() {
		return plugin;
	}

	public void setPlugin(Info plugin) {
		this.plugin = plugin;
	}
}
