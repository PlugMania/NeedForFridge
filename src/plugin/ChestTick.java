package plugin;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ChestTick{
	
	HashMap<InventoryHolder,Integer> chests = new HashMap<InventoryHolder,Integer>();
	Server server = null;
	Plugin plugin = null;
	
	public ChestTick(Server s, Plugin p){
		server = s;
		plugin = p;
		
		server.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				for(InventoryHolder i:chests.keySet()){
					if(Utility.containsFood(i.getInventory())){
						int value = chests.get(i);
						if(i instanceof Chest){
							Chest c = (Chest)i;
							value = value - Utility.getRotValue(c.getLocation().getBlock().getBiome());
						}else{
							DoubleChest c = (DoubleChest)i;
							value = value - Utility.getRotValue(c.getLocation().getBlock().getBiome());
						}
						while(((value + 100) <= 3600) && (i.getInventory().contains(Material.SNOW_BALL))){
							value = value + 100;
							ItemStack is = i.getInventory().getItem(i.getInventory().first(Material.SNOW_BALL));
							is.setAmount(is.getAmount()-1);
						}
						while(((value + 1000) <= 3600) && (i.getInventory().contains(Material.SNOW_BLOCK))){
							value = value + 1000;
							ItemStack is = i.getInventory().getItem(i.getInventory().first(Material.SNOW_BLOCK));
							is.setAmount(is.getAmount()-1);
						}
						while(((value + 2400) <= 3600) && (i.getInventory().contains(Material.ICE))){
							value = value + 2400;
							ItemStack is = i.getInventory().getItem(i.getInventory().first(Material.ICE));
							is.setAmount(is.getAmount()-1);
						}
						chests.put(i, value);
						if(value <= 0){
							if(i instanceof Chest){
								Chest c = (Chest)i;
								Utility.rotFood(i.getInventory(), c.getLocation().getBlock().getBiome());
							}else{
								DoubleChest c = (DoubleChest)i;
								Utility.rotFood(i.getInventory(), c.getLocation().getBlock().getBiome());
							}
						}
					}
				}
			}
		}, 72000, 72000); // 72000 = 60 Minutes
	}
	
}