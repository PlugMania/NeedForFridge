package plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SilverfishTick{
	
	List<Location> chests = new ArrayList<Location>();
	Server server = null;
	Plugin plugin = null;
	
	public SilverfishTick(Server s, Plugin p){
		server = s;
		plugin = p;
		
		server.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				if(chests.size() > 0){
					for(Location l:chests){
						if(l.getBlock().getType() == Material.CHEST){
							l.add(0,1,0);
							l.getWorld().spawnEntity(l, EntityType.SILVERFISH);
						}else{
							chests.remove(l);
						}
					}
				}
				
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
						l.getWorld().spawnEntity(l, EntityType.SILVERFISH);
					}
				}
			}
		}, 1200, 1200); // 1200 = 1 Minute
	}
	
}