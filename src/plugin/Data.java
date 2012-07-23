package plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

public class Data {
	
	public static List<Material> getFood(){
		List<Material> food = new ArrayList<Material>();
		food.add(Material.APPLE);
		food.add(Material.BREAD);
		food.add(Material.BROWN_MUSHROOM);
		food.add(Material.CAKE);
		food.add(Material.COOKED_BEEF);
		food.add(Material.COOKED_CHICKEN);
		food.add(Material.COOKED_FISH);
		food.add(Material.COOKIE);
		food.add(Material.EGG);
		food.add(Material.GRILLED_PORK);
		food.add(Material.MELON);
		food.add(Material.MILK_BUCKET);
		food.add(Material.MUSHROOM_SOUP);
		food.add(Material.PORK);
		food.add(Material.PUMPKIN);
		food.add(Material.RAW_BEEF);
		food.add(Material.RAW_CHICKEN);
		food.add(Material.RAW_FISH);
		food.add(Material.RED_MUSHROOM);
		return food;
	}
	
	public static HashMap<Material,ItemStack> getRot(Biome b){
		HashMap<Material,ItemStack> rot = new HashMap<Material,ItemStack>();
		if(b == Biome.MUSHROOM_ISLAND || b == Biome.MUSHROOM_SHORE){
			rot.put(Material.APPLE, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.BREAD, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.BROWN_MUSHROOM, new ItemStack(Material.BROWN_MUSHROOM,2));
			rot.put(Material.CAKE, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.COOKED_BEEF, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.COOKED_CHICKEN, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.COOKED_FISH, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.COOKIE, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.EGG, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.GRILLED_PORK, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.MELON, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.MILK_BUCKET, new ItemStack(Material.BUCKET,1));
			rot.put(Material.MUSHROOM_SOUP, new ItemStack(Material.BOWL,1));
			rot.put(Material.PORK, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.PUMPKIN, new ItemStack(Material.BROWN_MUSHROOM,1));
			rot.put(Material.RAW_BEEF, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.RAW_CHICKEN, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.RAW_FISH, new ItemStack(Material.RED_MUSHROOM,1));
			rot.put(Material.RED_MUSHROOM, new ItemStack(Material.RED_MUSHROOM,2));
		}else{
			rot.put(Material.APPLE, new ItemStack(Material.DEAD_BUSH,1));
			rot.put(Material.BREAD, new ItemStack(Material.WEB,1));
			rot.put(Material.BROWN_MUSHROOM, new ItemStack(Material.DEAD_BUSH,2));
			rot.put(Material.CAKE, new ItemStack(Material.WEB,1));
			rot.put(Material.COOKED_BEEF, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.COOKED_CHICKEN, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.COOKED_FISH, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.COOKIE, new ItemStack(Material.WEB,1));
			rot.put(Material.EGG, new ItemStack(Material.WEB,1));
			rot.put(Material.GRILLED_PORK, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.MELON, new ItemStack(Material.DEAD_BUSH,1));
			rot.put(Material.MILK_BUCKET, new ItemStack(Material.BUCKET,1));
			rot.put(Material.MUSHROOM_SOUP, new ItemStack(Material.BOWL,1));
			rot.put(Material.PORK, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.PUMPKIN, new ItemStack(Material.DEAD_BUSH,1));
			rot.put(Material.RAW_BEEF, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.RAW_CHICKEN, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.RAW_FISH, new ItemStack(Material.ROTTEN_FLESH,1));
			rot.put(Material.RED_MUSHROOM, new ItemStack(Material.DEAD_BUSH,2));
		}
		return rot;
	}
	
	public static HashMap<Biome,Float> getBiome(){
		HashMap<Biome,Float> biomes = new HashMap<Biome,Float>();
		biomes.put(Biome.BEACH, 1.00F);
		biomes.put(Biome.DESERT, 2.00F);
		biomes.put(Biome.DESERT_HILLS, 1.90F);
		biomes.put(Biome.EXTREME_HILLS, 0.90F);
		biomes.put(Biome.FOREST, 0.80F);
		biomes.put(Biome.FOREST_HILLS, 0.75F);
		biomes.put(Biome.FROZEN_OCEAN, 0.40F);
		biomes.put(Biome.FROZEN_RIVER, 0.45F);
		biomes.put(Biome.HELL, 3.00F);
		biomes.put(Biome.ICE_DESERT, 0.50F);
		biomes.put(Biome.ICE_MOUNTAINS, 0.40F);
		biomes.put(Biome.ICE_PLAINS, 0.50F);
		biomes.put(Biome.JUNGLE, 1.75F);
		biomes.put(Biome.JUNGLE_HILLS, 1.60F);
		biomes.put(Biome.MUSHROOM_ISLAND, 3.00F);
		biomes.put(Biome.MUSHROOM_SHORE, 3.00F);
		biomes.put(Biome.OCEAN, 0.90F);
		biomes.put(Biome.PLAINS, 1.00F);
		biomes.put(Biome.RAINFOREST, 1.50F);
		biomes.put(Biome.RIVER, 0.80F);
		biomes.put(Biome.SAVANNA, 2.00F);
		biomes.put(Biome.SEASONAL_FOREST, 0.80F);
		biomes.put(Biome.SHRUBLAND, 1.00F);
		biomes.put(Biome.SKY, 0.50F);
		biomes.put(Biome.SMALL_MOUNTAINS, 1.00F);
		biomes.put(Biome.SWAMPLAND, 1.60F);
		biomes.put(Biome.TAIGA, 0.40F);
		biomes.put(Biome.TUNDRA, 0.50F);
		return biomes;
	}
	
}