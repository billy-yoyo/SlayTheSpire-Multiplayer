package com.billyoyo.cardcrawl.multiplayer.helpers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.powers.*;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 27/01/2018.
 */
public class PowerLibrary {

    public static Map<String, AbstractPowerFactory> factoryMap = new HashMap<>();

    public static void register(String id, AbstractPowerFactory factory) {
        factoryMap.put(id, factory);
    }

    public static void register(AbstractPowerFactory factory) {
        register(factory.getPowerId(), factory);
    }

    private static boolean initialized = false;

    public static void ensureInitialized() {
        if (!initialized) {
            initialized = true;
            registerAll();
        }
    }

    public static void registerAll() {
        new AbsorbPowerFactory().register();
        new AccuracyPowerFactory().register();
        new AfterImagePowerFactory().register();
        new AngerPowerFactory().register();
        new AngryPowerFactory().register();
        new ArtifactPowerFactory().register();
        new AttackBurnPowerFactory().register();
        new BarricadePowerFactory().register();
        new BlurPowerFactory().register();
        new BrutalityPowerFactory().register();
        new BurstPowerFactory().register();
        new ChokePowerFactory().register();
        new CombustPowerFactory().register();
        new ConfusionPowerFactory().register();
        new ConstrictedPowerFactory().register();
        new CorruptionPowerFactory().register();
        new CuriosityPowerFactory().register();
        new CurlUpPowerFactory().register();
        new DancePowerFactory().register();
        new DarkEmbracePowerFactory().register();
        new DarknessPowerFactory().register();
        new DemonFormPowerFactory().register();
        new DexterityPowerFactory().register();
        new DoubleDamagePowerFactory().register();
        new DoubleTapPowerFactory().register();
        new DrawCardNextTurnPowerFactory().register();
        new DrawDownPowerFactory().register();
        new DrawPowerFactory().register();
        new DrawReductionPowerFactory().register();
        new ElectricFieldPowerFactory().register();
        new EnergizedPowerFactory().register();
        new EntanglePowerFactory().register();
        new EnvenomPowerFactory().register();
        new EvolvePowerFactory().register();
        new ExplosivePowerFactory().register();
        new FeelNoPainPowerFactory().register();
        new FireBreathingPowerFactory().register();
        new FlameBarrierPowerFactory().register();
        new FlightPowerFactory().register();
        new ForcefieldPowerFactory().register();
        new FrailPowerFactory().register();
        new GainStrengthPowerFactory().register();
        new GambitPowerFactory().register();
        new GeneratorPowerFactory().register();
        new GenericStrengthUpPowerFactory().register();
        new HexPowerFactory().register();
        new ImpulsePowerFactory().register();
        new InfiniteBladesPowerFactory().register();
        new IntangiblePowerFactory().register();
        new JuggernautPowerFactory().register();
        new KnowledgePowerFactory().register();
        new LoseStrengthPowerFactory().register();
        new MalleablePowerFactory().register();
        new MetallicizePowerFactory().register();
        new MinionPowerFactory().register();
        new ModeShiftPowerFactory().register();
        new NextTurnBlockPowerFactory().register();
        new NightmarePowerFactory().register();
        new NoDrawPowerFactory().register();
        new NoxiousFumesPowerFactory().register();
        new PainfulStabsPowerFactory().register();
        new PanachePowerFactory().register();
        new PenNibPowerFactory().register();
        new PhantasmalPowerFactory().register();
        new PlatedArmorPowerFactory().register();
        new PoisonPowerFactory().register();
        new RagePowerFactory().register();
        new ReduceDamagePowerFactory().register();
        new RegeneratePowerFactory().register();
        new RegenerationPowerFactory().register();
        new RegrowPowerFactory().register();
        new RepulsePowerFactory().register();
        new RetainCardPowerFactory().register();
        new RitualPowerFactory().register();
        new RupturePowerFactory().register();
        new SadisticPowerFactory().register();
        new SerpentinePowerFactory().register();
        new SharpHidePowerFactory().register();
        new ShriekPowerFactory().register();
        new SkillBurnPowerFactory().register();
        new SlowPowerFactory().register();
        new SplitPowerFactory().register();
        new SporeCloudPowerFactory().register();
        new StasisPowerFactory().register();
        new StrengthPowerFactory().register();
        new SystemsPowerFactory().register();
        new ThieveryPowerFactory().register();
        new ThornsPowerFactory().register();
        new ThousandCutsPowerFactory().register();
        new TimeWarpPowerFactory().register();
        new ToolsOfTheTradePowerFactory().register();
        new UnawakenedPowerFactory().register();
        new VenomologyPowerFactory().register();
        new VulnerablePowerFactory().register();
        new WeakPowerFactory().register();
        new WraithFormPowerFactory().register();
    }

    public static AbstractPower create(AbstractPowerDTO dto, CreateData data) {
        ensureInitialized();
        AbstractPowerFactory factory = factoryMap.get(dto.getId());

        if (factory != null) {
            return factory.create(dto, data);
        }
        return null;
    }

}
