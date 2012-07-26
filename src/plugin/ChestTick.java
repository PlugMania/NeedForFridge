package plugin;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ChestTick{
	
	HashMap<Chest,Integer> chests = new HashMap<Chest,Integer>();
	Server server = null;
	Plugin plugin = null;
	
	public ChestTick(Server s, Plugin p){
		server = s;
		plugin = p;
		
		server.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				for(Chest c:chests.keySet()){
					if(Utility.containsFood(c.getInventory())){
						int value = chests.get(c);
						value = value - Utility.getRotValue(c.getLocation().getBlock().getBiome());
						while(((value + 100) <= 3600) && (c.getInventory().contains(Material.SNOW_BALL))){
							value = value + 100;
							ItemStack is = c.getInventory().getItem(c.getInventory().first(Material.SNOW_BALL));
							is.setAmount(is.getAmount()-1);
						}
						while(((value + 1000) <= 3600) && (c.getInventory().contains(Material.SNOW_BLOCK))){
							value = value + 1000;
							ItemStack is = c.getInventory().getItem(c.getInventory().first(Material.SNOW_BLOCK));
							is.setAmount(is.getAmount()-1);
						}
						while(((value + 2400) <= 3600) && (c.getInventory().contains(Material.ICE))){
							value = value + 2400;
							ItemStack is = c.getInventory().getItem(c.getInventory().first(Material.ICE));
							is.setAmount(is.getAmount()-1);
						}
						chests.put(c, value);
						if(value <= 0){
							Utility.rotFood(c.getInventory(), c.getLocation().getBlock().getBiome());
						}
					}
				}
			}
		}, 72000, 72000); // 72000 = 60 Minutes
	}
	
}