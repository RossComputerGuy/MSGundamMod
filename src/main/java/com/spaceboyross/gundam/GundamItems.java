package com.spaceboyross.gundam;

import com.spaceboyross.gundam.items.armor.CharAznableMaskItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitHelmetItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitPantsItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitShoesItem;
import com.spaceboyross.gundam.items.armor.SpaceSuitTorsoItem;
import com.spaceboyross.gundam.items.materials.ECarbonIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumAlphaIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumBetaIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumEpsilonIngotItem;
import com.spaceboyross.gundam.items.materials.GundariumGammaIngotItem;
import com.spaceboyross.gundam.items.materials.LunaTitaniumIngotItem;
import com.spaceboyross.gundam.items.materials.NanolaminateArmorItem;
import com.spaceboyross.gundam.items.materials.PhaseShiftArmorItem;
import com.spaceboyross.gundam.items.materials.PortableVernierItem;
import com.spaceboyross.gundam.items.materials.SteelIngotItem;
import com.spaceboyross.gundam.items.materials.SuperHardSteelIngotItem;
import com.spaceboyross.gundam.items.materials.TransPhaseArmorItem;
import com.spaceboyross.gundam.items.materials.VariablePhaseShiftArmorItem;
import com.spaceboyross.gundam.items.music.GundamMusicItem;
import com.spaceboyross.gundam.items.tools.GControllerItem;
import com.spaceboyross.gundam.items.tools.WrenchItem;
import com.spaceboyross.gundam.items.weapons.MobileSuitArmamentItem;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundamItems {
	
	@GameRegistry.ObjectHolder("gundam:music_ai_senshi")
	public static GundamMusicItem aiSenshiMusic;

	@GameRegistry.ObjectHolder("gundam:music_anime_ja_nai")
	public static GundamMusicItem animeJaNaiMusic;
	
	@GameRegistry.ObjectHolder("gundam:ms_armament_beam_saber")
	public static MobileSuitArmamentItem beamSaberArmament;

	@GameRegistry.ObjectHolder("gundam:music_beleive")
	public static GundamMusicItem beleiveMusic;

	@GameRegistry.ObjectHolder("gundam:music_beyond_the_time")
	public static GundamMusicItem beyondTheTimeMusic;
	
	@GameRegistry.ObjectHolder("gundam:char_aznable_mask")
	public static CharAznableMaskItem charAznableMask;
	
	@GameRegistry.ObjectHolder("gundam:music_dreams")
	public static GundamMusicItem dreamsMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_flying_in_the_sky")
	public static GundamMusicItem flyingInTheSkyMusic;
	
	@GameRegistry.ObjectHolder("gundam:ecarbon_ingot")
	public static ECarbonIngotItem ecarbonIngot;
	
	@GameRegistry.ObjectHolder("gundam:g_controller")
	public static GControllerItem gController;
	
	@GameRegistry.ObjectHolder("gundam:music_godfinger")
	public static GundamMusicItem godfingerMusic;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_alpha_ingot")
	public static GundariumAlphaIngotItem gundariumAlphaIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_beta_ingot")
	public static GundariumBetaIngotItem gundariumBetaIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_epsilon_ingot")
	public static GundariumEpsilonIngotItem gundariumEpsilonIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_gamma_ingot")
	public static GundariumGammaIngotItem gundariumGammaIngot;
	
	@GameRegistry.ObjectHolder("gundam:music_invoke")
	public static GundamMusicItem invokeMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_just_communication")
	public static GundamMusicItem justCommunicationMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_last_impression")
	public static GundamMusicItem lastImpressionMusic;
	
	@GameRegistry.ObjectHolder("gundam:luna_titanium_ingot")
	public static LunaTitaniumIngotItem lunaTitaniumIngot;
	
	@GameRegistry.ObjectHolder("gundam:music_moment")
	public static GundamMusicItem momentMusic;
	
	@GameRegistry.ObjectHolder("gundam:nanolaminate_armor")
	public static NanolaminateArmorItem nanolaminateArmor;
	
	@GameRegistry.ObjectHolder("gundam:phase_shift_armor")
	public static PhaseShiftArmorItem phaseShiftArmor;
	
	@GameRegistry.ObjectHolder("gundam:portable_vernier")
	public static PortableVernierItem portableVernier;
	
	@GameRegistry.ObjectHolder("gundam:music_realize")
	public static GundamMusicItem realizeMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_rhythm_emotion")
	public static GundamMusicItem rhythmEmotionMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_shine_through_the_storm")
	public static GundamMusicItem shineThroughTheStormMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_stand_up_to_the_victory")
	public static GundamMusicItem standUpToTheVictoryMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_the_wings_of_a_boy_that_killed_adolescence")
	public static GundamMusicItem theWingsOfABoyThatKilledAdolescenceMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_the_winner")
	public static GundamMusicItem theWinnerMusic;
	
	@GameRegistry.ObjectHolder("gundam:music_turn_a_turn")
	public static GundamMusicItem turnATurnMusic;
	
	@GameRegistry.ObjectHolder("gundam:spacesuit_helmet")
	public static SpaceSuitHelmetItem spacesuitHelmet;
	
	@GameRegistry.ObjectHolder("gundam:spacesuit_pants")
	public static SpaceSuitPantsItem spacesuitPants;
	
	@GameRegistry.ObjectHolder("gundam:spacesuit_shoes")
	public static SpaceSuitShoesItem spacesuitShoes;
	
	@GameRegistry.ObjectHolder("gundam:spacesuit_torso")
	public static SpaceSuitTorsoItem spacesuitTorso;
	
	@GameRegistry.ObjectHolder("gundam:steel_ingot")
	public static SteelIngotItem steelIngot;
	
	@GameRegistry.ObjectHolder("gundam:super_hard_steel_ingot")
	public static SuperHardSteelIngotItem superHardSteelIngot;
	
	@GameRegistry.ObjectHolder("gundam:music_tobe_gundam")
	public static GundamMusicItem tobeGundamMusic;
	
	@GameRegistry.ObjectHolder("gundam:trans_phase_armor")
	public static TransPhaseArmorItem transPhaseArmor;
	
	@GameRegistry.ObjectHolder("gundam:music_white_reflection")
	public static GundamMusicItem whiteReflectionMusic;
	
	@GameRegistry.ObjectHolder("gundam:wrench")
	public static WrenchItem wrench;
	
	@GameRegistry.ObjectHolder("gundam:variable_phase_shift_armor")
	public static VariablePhaseShiftArmorItem variablePhaseShiftArmor;
	
	@GameRegistry.ObjectHolder("gundam:ms_armament_vulcans")
	public static MobileSuitArmamentItem vulcanGunArmament;
	
	@GameRegistry.ObjectHolder("gundam:music_z_toki_wo_koete")
	public static GundamMusicItem zTokiWoKoeteMusic;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		GundamItems.aiSenshiMusic.initModel();
		GundamItems.animeJaNaiMusic.initModel();
		GundamItems.beamSaberArmament.initModel();
		GundamItems.beleiveMusic.initModel();
		GundamItems.beyondTheTimeMusic.initModel();
		GundamItems.charAznableMask.initModel();
		GundamItems.dreamsMusic.initModel();
		GundamItems.ecarbonIngot.initModel();
		GundamItems.flyingInTheSkyMusic.initModel();
		GundamItems.gController.initModel();
		GundamItems.godfingerMusic.initModel();
		GundamItems.gundariumAlphaIngot.initModel();
		GundamItems.gundariumBetaIngot.initModel();
		GundamItems.gundariumEpsilonIngot.initModel();
		GundamItems.gundariumGammaIngot.initModel();
		GundamItems.invokeMusic.initModel();
		GundamItems.justCommunicationMusic.initModel();
		GundamItems.lastImpressionMusic.initModel();
		GundamItems.lunaTitaniumIngot.initModel();
		GundamItems.momentMusic.initModel();
		GundamItems.nanolaminateArmor.initModel();
		GundamItems.phaseShiftArmor.initModel();
		GundamItems.portableVernier.initModel();
		GundamItems.realizeMusic.initModel();
		GundamItems.rhythmEmotionMusic.initModel();
		GundamItems.shineThroughTheStormMusic.initModel();
		GundamItems.standUpToTheVictoryMusic.initModel();
		GundamItems.theWingsOfABoyThatKilledAdolescenceMusic.initModel();
		GundamItems.theWinnerMusic.initModel();
		GundamItems.turnATurnMusic.initModel();
		GundamItems.spacesuitHelmet.initModel();
		GundamItems.spacesuitPants.initModel();
		GundamItems.spacesuitShoes.initModel();
		GundamItems.spacesuitTorso.initModel();
		GundamItems.steelIngot.initModel();
		GundamItems.superHardSteelIngot.initModel();
		GundamItems.tobeGundamMusic.initModel();
		GundamItems.transPhaseArmor.initModel();
		GundamItems.whiteReflectionMusic.initModel();
		GundamItems.wrench.initModel();
		GundamItems.variablePhaseShiftArmor.initModel();
		GundamItems.vulcanGunArmament.initModel();
		GundamItems.zTokiWoKoeteMusic.initModel();
	}
}
