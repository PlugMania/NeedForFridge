package plugin;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Utility {
	
	public static boolean containsFood(Inventory i){
		List<Material> food = Data.getFood();
		for(int a=0;a<food.size()-1;a++){
			if(i.contains(food.get(a))){
				return true;
			}
		}
		return false;
	}
	
	public static void rotFood(Inventory i, Biome b){	
		HashMap<Material,ItemStack> rot = Data.getRot(b);
		for(Material m:rot.keySet()){
			while(i.contains(m)){
				i.removeItem(new ItemStack(m,1));
				i.addItem(rot.get(m));
			}
		}
	}
	
	public static int getRotValue(Biome b){
		float value = 100;
		HashMap<Biome, Float> biome = Data.getBiome();
		value = value * biome.get(b);
		int v = (int)value;
		return v;
	}
	
}