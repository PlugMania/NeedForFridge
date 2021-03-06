package plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SilverfishTick{
	
	List<Location> chests = new ArrayList<Location>();
	List<Item> items = new ArrayList<Item>();
	Server server = null;
	Plugin plugin = null;
	Random random = null;
	
	public SilverfishTick(Server s, Plugin p){
		server = s;
		plugin = p;
		random = new Random();
		
		server.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				int r = random.nextInt(3);
				switch (r){
					case 0:
						if(chests.size() > 0){
							List<Location> del = new ArrayList<Location>(); 
							for(Location l:chests){
								if(l.getBlock().getType() == Material.CHEST){
									l.add(0,1,0);
									l.getWorld().spawnCreature(l, EntityType.SILVERFISH);
								}else{
									del.add(l);
								}
							}
							if(del.size() > 0){
								for(Location l:del){
									if(chests.contains(l)){
										chests.remove(l);
									}
								}
								del.clear();
							}
						}
						return;
						
					case 1:
						List<Item> del = new ArrayList<Item>();
						if(items.size() > 0){
							for(Item i:items){
								i.getWorld().spawnCreature(i.getLocation(), EntityType.SILVERFISH);
								i.remove();
								del.add(i);
							}
							if(del.size() > 0){
								for(Item i:del){
									if(items.contains(i)){
										items.remove(i);
									}
								}
								del.clear();
							}
						}
						return;
						
					case 2:
						Player player[] = server.getOnlinePlayers();
						List<Location> location = new ArrayList<Location>();
						for(Player p:player){
							if(p.getInventory().contains(Material.ROTTEN_FLESH)){
								location.add(p.getLocation());
							}
						}
						if(location.size() > 0){
							for(Location l:location){
								l.add(0,1,0);
								l.getWorld().spawnCreature(l, EntityType.SILVERFISH);
							}
						}
						return;
				}
			}
		}, 1200, 1200); // 1200 = 1 Minute
	}
	
}