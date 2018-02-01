package com.megacrit.cardcrawl.screens.mainMenu;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.GameCursor;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.credits.CreditsScreen;
import com.megacrit.cardcrawl.helpers.*;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.metrics.Metrics;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.scenes.TitleBackground;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.screens.charSelect.CharacterSelectScreen;
import com.megacrit.cardcrawl.screens.leaderboards.LeaderboardScreen;
import com.megacrit.cardcrawl.screens.options.OptionsPanel;
import com.megacrit.cardcrawl.screens.runHistory.RunHistoryScreen;
import com.megacrit.cardcrawl.screens.saveAndContinue.SaveAndContinue;
import com.megacrit.cardcrawl.screens.stats.StatsScreen;
import com.megacrit.cardcrawl.steam.SteamSaveSync;
import com.megacrit.cardcrawl.ui.buttons.ConfirmButton;
import com.megacrit.cardcrawl.ui.panels.RenamePanel;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

public class MainMenuScreen {
    private static final Logger logger = LogManager.getLogger(MainMenuScreen.class.getName());
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    private static final String VERSION_INFO;
    private Hitbox nameEditHb;
    public String newName;
    public boolean darken;
    public Color screenColor;
    public static final float OVERLAY_ALPHA = 0.8F;
    private Color overlayColor;
    public boolean fadedOut;
    public boolean isFadingOut;
    public long windId;
    private CharSelectInfo charInfo;
    public TitleBackground bg;
    private EarlyAccessPopup eaPopup;
    public MainMenuScreen.CurScreen screen;
    private RenamePanel renamePanel;
    public StatsScreen statsScreen;
    public com.megacrit.cardcrawl.screens.trial.TrialScreen trial;
    public CardLibraryScreen cardLibraryScreen;
    public LeaderboardScreen leaderboardsScreen;
    public RelicViewScreen relicScreen;
    public CreditsScreen creditsScreen;
    public PatchNotesScreen patchNotesScreen;
    public RunHistoryScreen runHistoryScreen;
    public CharacterSelectScreen charSelectScreen;
    public ConfirmButton confirmButton;
    public MenuCancelButton cancelButton;
    private Hitbox patchNotesHb;
    public OptionsPanel optionPanel;
    public boolean isSettingsUp;
    private Hitbox deckHb;
    public ArrayList<MenuButton> buttons;
    public boolean abandonedRun;

    public MainMenuScreen() {
        this(true);
    }

    public MainMenuScreen(boolean playBgm) {
        this.nameEditHb = new Hitbox(0.0F, (float) Settings.HEIGHT - 80.0F * Settings.scale, 300.0F * Settings.scale, 120.0F * Settings.scale);
        this.darken = false;
        this.screenColor = new Color(0.0F, 0.0F, 0.0F, 0.0F);
        this.overlayColor = new Color(0.0F, 0.0F, 0.0F, 0.0F);
        this.fadedOut = false;
        this.isFadingOut = false;
        this.windId = 0L;
        this.charInfo = null;
        this.bg = new TitleBackground();
        this.eaPopup = new EarlyAccessPopup();
        this.screen = MainMenuScreen.CurScreen.MAIN_MENU;
        this.renamePanel = new RenamePanel();
        this.statsScreen = new StatsScreen();
        this.trial = new com.megacrit.cardcrawl.screens.trial.TrialScreen();
        this.cardLibraryScreen = new CardLibraryScreen();
        this.leaderboardsScreen = new LeaderboardScreen();
        this.relicScreen = new RelicViewScreen();
        this.creditsScreen = new CreditsScreen();
        this.patchNotesScreen = new PatchNotesScreen();
        this.runHistoryScreen = new RunHistoryScreen();
        this.charSelectScreen = new CharacterSelectScreen();
        this.confirmButton = new ConfirmButton(TEXT[1]);
        this.cancelButton = new MenuCancelButton();
        this.patchNotesHb = new Hitbox(0.0F, 0.0F, 200.0F * Settings.scale, 30.0F * Settings.scale);
        this.optionPanel = new OptionsPanel();
        this.isSettingsUp = false;
        this.deckHb = new Hitbox(-1000.0F, 0.0F, 400.0F * Settings.scale, 80.0F * Settings.scale);
        this.buttons = new ArrayList();
        this.abandonedRun = false;
        if(Settings.isDemo && Settings.isShowBuild) {
            TipTracker.reset();
        }

        if(playBgm) {
            CardCrawlGame.music.changeBGM("MENU");
            if(Settings.AMBIANCE_ON) {
                this.windId = CardCrawlGame.sound.playAndLoop("WIND");
            } else {
                this.windId = CardCrawlGame.sound.playAndLoop("WIND", 0.0F);
            }
        }

        UnlockTracker.refresh();
        this.cardLibraryScreen.initialize();
        this.charSelectScreen.initialize();
        this.confirmButton.hide();
        this.updateAmbienceVolume();
        SaveAndContinue.checkForSaves();
        if(Settings.UPLOAD_DATA && !CardCrawlGame.playerPref.getBoolean("funMode", false)) {
            Metrics m = new Metrics();
            m.setValues(false, (MonsterGroup)null, Metrics.MetricRequestType.UPLOAD_FAILED_METRICS);
            Thread t = new Thread(m);
            t.run();
        }

        this.setMainMenuButtons();
    }

    private void setMainMenuButtons() {
        this.buttons.clear();
        byte index = 0;
        int var2 = index + 1;
        this.buttons.add(new MenuButton(MenuButton.ClickResult.QUIT, index));
        this.buttons.add(new MenuButton(MenuButton.ClickResult.CREDITS, var2++));
        this.buttons.add(new MenuButton(MenuButton.ClickResult.PATCH_NOTES, var2++));
        this.buttons.add(new MenuButton(MenuButton.ClickResult.SETTINGS, var2++));
        this.buttons.add(new MenuButton(MenuButton.ClickResult.MULTIPLAYER, var2++));
        if(!Settings.isShowBuild) {
            if(this.statsScreen.statScreenUnlocked()) {
                this.buttons.add(new MenuButton(MenuButton.ClickResult.LEADERBOARD, var2++));
                this.buttons.add(new MenuButton(MenuButton.ClickResult.STATS, var2++));
                if(Settings.isBeta) {
                    this.buttons.add(new MenuButton(MenuButton.ClickResult.RUN_HISTORY, var2++));
                }
            }

            this.buttons.add(new MenuButton(MenuButton.ClickResult.RELICS, var2++));
            this.buttons.add(new MenuButton(MenuButton.ClickResult.CARDS, var2++));
        }

        if(!SaveAndContinue.ironcladSaveExists && !SaveAndContinue.silentSaveExists && !SaveAndContinue.crowbotSaveExists) {
            this.buttons.add(new MenuButton(MenuButton.ClickResult.CHAR_SELECT, var2++));
        } else {
            this.buttons.add(new MenuButton(MenuButton.ClickResult.ABANDON_RUN, var2++));
            this.buttons.add(new MenuButton(MenuButton.ClickResult.RESUME_GAME, var2++));
        }

    }

    public void update() {
        if(this.isFadingOut) {
            InputHelper.justClickedLeft = false;
            InputHelper.justReleasedClickLeft = false;
            InputHelper.justClickedRight = false;
            InputHelper.justReleasedClickRight = false;
        }

        if(this.abandonedRun) {
            this.abandonedRun = false;
            this.buttons.remove(this.buttons.size() - 1);
            this.buttons.remove(this.buttons.size() - 1);
            this.buttons.add(new MenuButton(MenuButton.ClickResult.CHAR_SELECT, this.buttons.size()));
        }

        if(this.eaPopup != null && EarlyAccessPopup.isUp) {
            this.eaPopup.update();
            InputHelper.justClickedLeft = false;
        } else {
            this.eaPopup = null;
        }

        if(Settings.isInfo && Gdx.input.isKeyJustPressed(62)) {
            SteamSaveSync.deleteAllCloudFiles(SteamSaveSync.getAllCloudFiles());
            logger.info("[STEAM] Deleted all Cloud Files");
        }

        this.cancelButton.update();
        this.updateSettings();
        if(this.screen != MainMenuScreen.CurScreen.RENAME) {
            Iterator var1 = this.buttons.iterator();

            while(var1.hasNext()) {
                MenuButton b = (MenuButton)var1.next();
                b.update();
            }
        }

        switch(screen) {
            case CHAR_SELECT:
                this.charSelectScreen.update();
                break;
            case CARD_LIBRARY:
                this.cardLibraryScreen.update();
            default:
                break;
            case MAIN_MENU:
                if(this.patchNotesHb.hovered && InputHelper.justClickedLeft) {
                    InputHelper.justClickedLeft = false;
                    this.patchNotesScreen.open();
                }
                break;
            case LEADERBOARD:
                this.leaderboardsScreen.update();
                break;
            case RELIC_VIEW:
                this.relicScreen.update();
                break;
            case STATS:
                this.statsScreen.update();
                break;
            case CREDITS:
                this.creditsScreen.update();
                break;
            case PATCH_NOTES:
                this.patchNotesScreen.update();
                break;
            case RUN_HISTORY:
                this.runHistoryScreen.update();
        }

        this.renamePanel.update();
        this.bg.update();
        if(this.darken) {
            this.screenColor.a = MathHelper.popLerpSnap(this.screenColor.a, 0.8F);
        } else {
            this.screenColor.a = MathHelper.popLerpSnap(this.screenColor.a, 0.0F);
        }

        if(!this.statsScreen.screenUp && !this.trial.screenUp) {
            this.updateRenameArea();
        }

        if(this.charInfo != null && this.charInfo.resumeGame) {
            this.deckHb.update();
            if(this.deckHb.justHovered) {
                CardCrawlGame.sound.play("UI_HOVER");
            }
        }

        if(!this.isFadingOut) {
            this.handleInput();
        }

        this.fadeOut();
    }

    private void updateSettings() {
        if(!this.renamePanel.shown) {
            if(!EarlyAccessPopup.isUp && InputHelper.pressedEscape && this.screen == MainMenuScreen.CurScreen.MAIN_MENU && !this.isFadingOut) {
                if(!this.isSettingsUp) {
                    GameCursor.hidden = false;
                    CardCrawlGame.sound.play("END_TURN");
                    this.isSettingsUp = true;
                    InputHelper.pressedEscape = false;
                    this.lighten();
                    this.statsScreen.hide();
                    this.cancelButton.hide();
                    CardCrawlGame.cancelButton.show(TEXT[2]);
                    this.screen = MainMenuScreen.CurScreen.SETTINGS;
                    this.hideMenuButtons();
                } else if(!EarlyAccessPopup.isUp) {
                    this.isSettingsUp = false;
                    CardCrawlGame.cancelButton.hide();
                    this.screen = MainMenuScreen.CurScreen.MAIN_MENU;
                    if(this.screen == MainMenuScreen.CurScreen.MAIN_MENU) {
                        this.cancelButton.hide();
                    }
                }

                this.statsScreen.hide();
            }

            if(this.isSettingsUp) {
                this.optionPanel.update();
            }

            CardCrawlGame.cancelButton.update();
        }
    }

    private void updateRenameArea() {
        if(this.screen == MainMenuScreen.CurScreen.MAIN_MENU) {
            this.nameEditHb.update();
        }

        if(this.nameEditHb.hovered && InputHelper.justClickedLeft) {
            InputHelper.justClickedLeft = false;
            this.nameEditHb.hovered = false;
            this.renamePanel.show(CardCrawlGame.playerName);
            this.screen = MainMenuScreen.CurScreen.RENAME;
        }

        if(this.bg.slider <= 0.1F && !CardCrawlGame.ftuePopupShown) {
            CardCrawlGame.ftuePopupShown = true;
            CardCrawlGame.playerPref.putBoolean("ftuePopupShown", true);
            this.renamePanel.show(CardCrawlGame.playerName);
            this.screen = MainMenuScreen.CurScreen.RENAME;
        }

    }

    private void handleInput() {
        this.confirmButton.update();
    }

    public void fadeOutMusic() {
        CardCrawlGame.music.fadeOutBGM();
        if(Settings.AMBIANCE_ON) {
            CardCrawlGame.sound.fadeOut("WIND", this.windId);
        }

    }

    public void render(SpriteBatch sb) {
        this.bg.render(sb);
        this.cancelButton.render(sb);
        this.renderNameEdit(sb);
        Iterator var2 = this.buttons.iterator();

        while(var2.hasNext()) {
            MenuButton b = (MenuButton)var2.next();
            b.render(sb);
        }

        this.patchNotesHb.render(sb);
        sb.setColor(this.screenColor);
        sb.draw(ImageMaster.WHITE_SQUARE_IMG, 0.0F, 0.0F, (float)Settings.WIDTH, (float)Settings.HEIGHT);
        if(this.isFadingOut) {
            this.confirmButton.update();
        }

        if(this.screen == MainMenuScreen.CurScreen.CHAR_SELECT) {
            this.charSelectScreen.render(sb);
        }

        sb.setColor(this.overlayColor);
        sb.draw(ImageMaster.WHITE_SQUARE_IMG, 0.0F, 0.0F, (float)Settings.WIDTH, (float)Settings.HEIGHT);
        this.renderSettings(sb);
        this.confirmButton.render(sb);
        if(this.patchNotesHb.hovered) {
            FontHelper.renderSmartText(sb, FontHelper.cardDescFont_N, VERSION_INFO, 20.0F * Settings.scale - 700.0F * this.bg.slider, 30.0F * Settings.scale, 10000.0F, 32.0F * Settings.scale, new Color(1.0F, 1.0F, 1.0F, 1.0F));
        } else {
            FontHelper.renderSmartText(sb, FontHelper.cardDescFont_N, VERSION_INFO, 20.0F * Settings.scale - 700.0F * this.bg.slider, 30.0F * Settings.scale, 10000.0F, 32.0F * Settings.scale, new Color(1.0F, 1.0F, 1.0F, 0.3F));
        }

        switch(screen) {
            case CARD_LIBRARY:
                this.cardLibraryScreen.render(sb);
            default:
                break;
            case LEADERBOARD:
                this.leaderboardsScreen.render(sb);
                break;
            case RELIC_VIEW:
                this.relicScreen.render(sb);
                break;
            case STATS:
                this.statsScreen.render(sb);
                break;
            case CREDITS:
                this.creditsScreen.render(sb);
                break;
            case PATCH_NOTES:
                this.patchNotesScreen.render(sb);
                break;
            case RUN_HISTORY:
                this.runHistoryScreen.render(sb);
        }

        this.renamePanel.render(sb);
        if(this.eaPopup != null) {
            this.eaPopup.render(sb);
        }

    }

    private void renderSettings(SpriteBatch sb) {
        if(this.isSettingsUp) {
            this.optionPanel.render(sb);
        }

        CardCrawlGame.cancelButton.render(sb);
    }

    private void renderNameEdit(SpriteBatch sb) {
        String derp = "";
        derp = CardCrawlGame.playerName;
        if(!this.nameEditHb.hovered) {
            FontHelper.renderSmartText(sb, FontHelper.cardTitleFont_N, derp, 30.0F * Settings.scale - 500.0F * this.bg.slider, (float)Settings.HEIGHT - 24.0F * Settings.scale, 1000.0F, 30.0F * Settings.scale, Color.GOLD);
        } else {
            FontHelper.renderSmartText(sb, FontHelper.cardTitleFont_N, derp, 30.0F * Settings.scale - 500.0F * this.bg.slider, (float)Settings.HEIGHT - 24.0F * Settings.scale, 1000.0F, 30.0F * Settings.scale, Settings.GREEN_TEXT_COLOR);
        }

        FontHelper.renderSmartText(sb, FontHelper.cardDescFont_N, TEXT[3], 30.0F * Settings.scale - 500.0F * this.bg.slider, (float)Settings.HEIGHT - 60.0F * Settings.scale, 1000.0F, 30.0F * Settings.scale, Color.SKY);
        this.nameEditHb.render(sb);
    }

    private void fadeOut() {
        if(this.isFadingOut && !this.fadedOut) {
            this.overlayColor.a += Gdx.graphics.getDeltaTime();
            if(this.overlayColor.a > 1.0F) {
                this.overlayColor.a = 1.0F;
                this.fadedOut = true;
            }
        } else if(this.isSettingsUp) {
            if(this.overlayColor.a != 0.8F) {
                this.overlayColor.a += Gdx.graphics.getDeltaTime() * 2.0F;
                if(this.overlayColor.a > 0.8F) {
                    this.overlayColor.a = 0.8F;
                }
            }
        } else if(this.overlayColor.a != 0.0F) {
            this.overlayColor.a -= Gdx.graphics.getDeltaTime() * 2.0F;
            if(this.overlayColor.a < 0.0F) {
                this.overlayColor.a = 0.0F;
            }
        }

    }

    public void updateAmbienceVolume() {
        if(Settings.AMBIANCE_ON) {
            CardCrawlGame.sound.adjustVolume("WIND", this.windId);
        } else {
            CardCrawlGame.sound.adjustVolume("WIND", this.windId, 0.0F);
        }

    }

    public void darken() {
        this.darken = true;
    }

    public void lighten() {
        this.darken = false;
    }

    public void hideMenuButtons() {
        Iterator var1 = this.buttons.iterator();

        while(var1.hasNext()) {
            MenuButton b = (MenuButton)var1.next();
            b.hide();
        }

    }

    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("MainMenuScreen");
        TEXT = uiStrings.TEXT;
        VERSION_INFO = TEXT[0] + CardCrawlGame.VERSION_NUM;
    }

    public static enum CurScreen {
        CHAR_SELECT,
        RELIC_VIEW,
        BANNER_DECK_VIEW,
        DAILY,
        TRIALS,
        SETTINGS,
        MAIN_MENU,
        RENAME,
        STATS,
        RUN_HISTORY,
        CARD_LIBRARY,
        CREDITS,
        PATCH_NOTES,
        NONE,
        LEADERBOARD;

        private CurScreen() {
        }
    }
}
